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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String createGame(@RequestParam("type") String type, Map<String, Object> model){
        Boolean isPublic = true;
        if(type.equals("public")){
            isPublic = true;
        }else if(type.equals("private")){
            isPublic = false;
        }
        Multiplayer game = new Multiplayer(isPublic);
        multiplayerService.save(game);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        UserGame userGame = new UserGame(user, game, 1, PlayerType.PLAYER);
        userGameService.save(userGame);

        multiplayerService.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);

        model.put("game", game);


        return "multiplayer/gameQueuePublic";
    }

}
