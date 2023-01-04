package org.harmony.endofline.multiplayer;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.harmony.endofline.userGame.PlayerType;
import org.harmony.endofline.userGame.UserGame;
import org.harmony.endofline.userGame.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/multiplayer")
@Controller
public class MultiplayerController {

    private static final String VIEWS_MULTIPLAYER_GAME = "MultiplayerBoard";
    private static final String VIEWS_MULTIPLAYER_CREATE_FORM = "multiplayer/gameSearch";

    private final MultiplayerService multiplayerService;
    private final UserService userService;
    private final UserGameService userGameService;

    @Autowired
    public MultiplayerController(MultiplayerService multiplayerService, UserService userService, UserGameService userGameService) {
        this.multiplayerService = multiplayerService;
        this.userService = userService;
        this.userGameService = userGameService;
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {
        return VIEWS_MULTIPLAYER_CREATE_FORM;
    }

    @PostMapping("/create")
    public String createGame(@RequestParam("isPublic") String isPublic, Map<String, Object> model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());



        int size;
        if(multiplayerService.getNextGameInQueue() == null){
            size = 0;
        }else{
            size = multiplayerService.getNextGameInQueue().getUsers().size();
        }
        User user2;
        Multiplayer game;
        if(size > 0) {
            user2 = multiplayerService.getNextGameInQueue().getUsers().get(0).getUser();
            if (size == 1 && !user2.getId().equals(user.getId())) {
                game = addPlayer2(user);
            }else{
                game = addPlayer1(Boolean.parseBoolean(isPublic),user);
            }
        }else {
            game = addPlayer1(Boolean.parseBoolean(isPublic),user);
        }

        model.put("game", game);

        if(Boolean.parseBoolean(isPublic)) {
            return "redirect:/multiplayer/queue/" + game.getId();
        }else{
            return "redirect:/invitefriend/" + game.getId();
        }
    }
    @GetMapping("/queue/{id}")
    public String queueStatus(@PathVariable("id") Integer id, Map<String, Object> model){
        Boolean ready = multiplayerService.checkGameReady(id);
        if(ready){
            return "redirect:/multiplayer/" + id;
        }else{
            return "multiplayer/gameQueuePublic";
        }
    }

    @GetMapping("/{id}")
    public String getGame(@PathVariable("id") Integer id, Map<String, Object> model){
        model.put("game", multiplayerService.getById(id));
        return VIEWS_MULTIPLAYER_GAME;
    }
    private Multiplayer addPlayer1(Boolean type, User user){
        // no game in queue or not elegable
        Multiplayer game = new Multiplayer(type);
        game.setIsPublic(true);
        multiplayerService.save(game);
        UserGame userGame = new UserGame(user, game, 1, PlayerType.PLAYER,3);
        userGameService.save(userGame);
        multiplayerService.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);
        return game;
    }

    private Multiplayer addPlayer2(User user){
        //Game in Queue exists and is elegable
        Multiplayer game = multiplayerService.getNextGameInQueue();
        UserGame userGame = new UserGame(user, game, 2, PlayerType.PLAYER,3);
        userGameService.save(userGame);
        multiplayerService.startGame(game.getId());
        return game;
    }

}
