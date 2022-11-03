package org.harmony.endofline.multiplayer;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.harmony.endofline.usersGames.UsersGames;
import org.harmony.endofline.usersGames.UsersGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/multiplayer")
@Controller
public class MultiplayerController {

    private static final String VIEWS_MULTIPLAYER_GAME = "MultiplayerBoard";

    private final MultiplayerService multiplayerService;
    private final UserService userService;
    private final UsersGamesService usersGamesService;

    @Autowired
    public MultiplayerController(MultiplayerService multiplayerService, UserService userService, UsersGamesService usersGamesService) {
        this.multiplayerService = multiplayerService;
        this.userService = userService;
        this.usersGamesService = usersGamesService;
    }

    @PostMapping("/create")
    public String createGame(Map<String, Object> model){

        Multiplayer game = new Multiplayer();
        multiplayerService.save(game);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        UsersGames userGame = new UsersGames(user, game, 1, "player");
        usersGamesService.save(userGame);

        multiplayerService.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);

        model.put("game", game);

        return VIEWS_MULTIPLAYER_GAME;
    }

}
