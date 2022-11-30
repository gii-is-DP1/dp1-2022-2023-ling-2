package org.harmony.endofline.singleplayer;

import org.harmony.endofline.board.Board;
import org.harmony.endofline.board.BoardService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/singleplayer")
@Controller
public class SingleplayerController {

    private final SingleplayerService singleplayerService;
    private final UserService userService;
    private final BoardService boardService;

    @Autowired
    public SingleplayerController(SingleplayerService singleplayerService, UserService userService,BoardService boardService) {
        this.singleplayerService = singleplayerService;
        this.userService = userService;
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public ModelAndView createGame(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        Singleplayer game = new Singleplayer(user);
        singleplayerService.save(game);
        userService.addSingleplayerGame(user, game);
        Integer id = game.getId();
        String st = "redirect:/singleplayer/" + id;
        return new ModelAndView(st, model);
    }

    @GetMapping("/{id}")
    public ModelAndView showGame(@PathVariable("id") Integer id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Singleplayer game = singleplayerService.findByID(id);
            ModelAndView result = new ModelAndView("SingleplayerBoard");
            result.addObject("game", game);
            result.addObject("board", boardService.findById(1).get());
            result.addObject("cards", singleplayerService.getAllCardsInGame(id));
            result.addObject("handCards", singleplayerService.getAllCardsInHand(id));
            return result;
        }catch (InvalidIDException e){
            return new ModelAndView("welcome");
        }
    }
}
