package org.harmony.endofline.singleplayer;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/singleplayer")
@Controller
public class SingleplayerController {

    private final SingleplayerService singleplayerService;
    private final UserService userService;

    @Autowired
    public SingleplayerController(SingleplayerService singleplayerService, UserService userService) {
        this.singleplayerService = singleplayerService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ModelAndView createGame(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        Singleplayer game = new Singleplayer(user);
        singleplayerService.save(game);

        userService.addSingleplayerGame(user, game);

        ModelAndView result = new ModelAndView("SingleplayerBoard");
        result.addObject("game", game);
        return result;
    }
}
