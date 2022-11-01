package org.harmony.endofline.singleplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/singleplayer")
@Controller
public class SingleplayerController {

    private final SingleplayerService singleplayerService;

    @Autowired
    public SingleplayerController(SingleplayerService singleplayerService) {
        this.singleplayerService = singleplayerService;
    }

    @PostMapping("/create")
    public ModelAndView createGame(){
        Singleplayer game = new Singleplayer();
        singleplayerService.save(game);
        ModelAndView result = new ModelAndView("SingleplayerBoard");
        result.addObject("game", game);
        return result;
    }
}
