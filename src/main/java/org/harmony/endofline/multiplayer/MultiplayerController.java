package org.harmony.endofline.multiplayer;

import org.harmony.endofline.singleplayer.InvalidIDException;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.harmony.endofline.userGame.PlayerType;
import org.harmony.endofline.userGame.UserGame;
import org.harmony.endofline.userGame.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RequestMapping("/multiplayer")
@Controller
public class MultiplayerController {

    private static final String VIEWS_MULTIPLAYER_GAME = "MultiplayerBoard";
    private static final String VIEWS_MULTIPLAYER_CREATE_FORM = "multiplayer/gameSearch";

    private final MultiplayerService multiplayerService;
    private final UserService userService;


    @Autowired
    public MultiplayerController(MultiplayerService multiplayerService, UserService userService, UserGameService userGameService) {
        this.multiplayerService = multiplayerService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {
        return VIEWS_MULTIPLAYER_CREATE_FORM;
    }

    @PostMapping("/create")
    public String createGame(@RequestParam("isPublic") String isPublic, Map<String, Object> model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());




        if(Boolean.parseBoolean(isPublic)) {
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
                    game = multiplayerService.addPlayer2(Boolean.parseBoolean(isPublic),user,multiplayerService.getNextGameInQueue());
                }else{
                    game = multiplayerService.addPlayer1(Boolean.parseBoolean(isPublic),user);
                }
            }else {
                game = multiplayerService.addPlayer1(Boolean.parseBoolean(isPublic),user);
            }
            model.put("game", game);

            return "redirect:/multiplayer/queue/" + game.getId();
        }else{
            Multiplayer game = multiplayerService.addPlayer1(Boolean.parseBoolean(isPublic),user);
            model.put("game", game);

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Multiplayer game = multiplayerService.getById(id);
        User user = userService.findByUsername(auth.getName());
        if (!multiplayerService.checkUserInGame(user, game))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        model.put("game", game);
        model.put("gameCards", multiplayerService.getAllCardsInBoard(id));
        model.put("handCards", multiplayerService.getAllCardsInHand(id, user.getId()));
        model.put("cards_left", multiplayerService.getAllCardsInDeck(id, user.getId()).size());
        return VIEWS_MULTIPLAYER_GAME;
    }


}
