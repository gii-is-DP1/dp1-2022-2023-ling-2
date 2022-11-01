package org.harmony.endofline.multiplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RequestMapping("/multiplayer")
@Controller
public class MultiplayerController {

    private final MultiplayerService multiplayerService;

    @Autowired
    public MultiplayerController(MultiplayerService multiplayerService) { this.multiplayerService = multiplayerService; }

    @PostMapping("/create")
    public ModelAndView createGame(){
        Multiplayer game = new Multiplayer();
        multiplayerService.save(game);
        ModelAndView result = new ModelAndView("MultiplayerBoard");
        result.addObject("game", game);
        return result;
    }

}
