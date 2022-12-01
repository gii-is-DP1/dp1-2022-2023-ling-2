package org.harmony.endofline.singleplayer;

import org.harmony.endofline.board.BoardService;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.puzzle.Difficulty;
import org.harmony.endofline.puzzle.Puzzle;
import org.harmony.endofline.puzzle.PuzzleService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/singleplayer")
@Controller
public class SingleplayerController {

    private static final String VIEWS_SINGLEPLAYER_CREATE_FORM = "singleplayer/difficulty";
    private static final String VIEWS_SINGLEPLAYER_BOARD = "SingleplayerBoard";
    private final SingleplayerService singleplayerService;
    private final UserService userService;
    private final BoardService boardService;
    private final PuzzleService puzzleService;

    @Autowired
    public SingleplayerController(SingleplayerService singleplayerService, UserService userService,BoardService boardService, PuzzleService puzzleService) {
        this.singleplayerService = singleplayerService;
        this.userService = userService;
        this.boardService = boardService;
        this.puzzleService = puzzleService;
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {
        return VIEWS_SINGLEPLAYER_CREATE_FORM;
    }

    @PostMapping("/create")
    public ModelAndView createGame(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        Puzzle puzzle = puzzleService.randomByDifficulty(Difficulty.HARD);

        Singleplayer game = new Singleplayer(user, puzzle);

        singleplayerService.save(game);
        userService.addSingleplayerGame(user, game);
        Integer id = game.getId();
        String st = "redirect:/singleplayer/" + id;
        return new ModelAndView(st, model);
    }

    @GetMapping("/{id}")
    public String showGame(@PathVariable("id") Integer id, Map<String, Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Singleplayer game = singleplayerService.findByID(id);

            model.put("game", game);
            model.put("board", boardService.findById(1).get());
            //result.addObject("cards", singleplayerService.getAllCardsInBoard(id));
            //result.addObject("handCards", singleplayerService.getAllCardsInHand(id));
            model.put("puzzleCards", puzzleService.getPuzzleCards(game.getPuzzle().getId()));
            model.put("gameCards", singleplayerService.getAllCardsInBoard(id));
            model.put("handCards", singleplayerService.getAllCardsInHand(id));
            return VIEWS_SINGLEPLAYER_BOARD;
        }catch (InvalidIDException e){
            return "welcome";
        }
    }

    @PostMapping("/{id}/place")
    public String placeCard(@PathVariable("id") Integer id, @RequestParam("gcid") Integer gameCardId, @RequestParam("rotation") Integer rotation, @RequestParam("x") Integer x, @RequestParam("y") Integer y){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            List<GameCard> boardCards = singleplayerService.getAllCardsInBoard(id);

            singleplayerService.moveCard(id, boardCards, gameCardId, rotation, x, y);

            return "redirect:/singleplayer/"+id;
        }catch (InvalidIDException e){
            return "welcome";
        }
    }
}
