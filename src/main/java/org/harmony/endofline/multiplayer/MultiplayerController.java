package org.harmony.endofline.multiplayer;

import org.harmony.endofline.deck.DeckService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
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

    private static final String VIEWS_MULTIPLAYER_GAME = "multiplayer/MultiplayerBoard";
    private static final String VIEWS_MULTIPLAYER_CREATE_FORM = "multiplayer/gameSearch";

    private final MultiplayerService multiplayerService;
    private final UserService userService;
    private final DeckService deckService;

    @Autowired
    public MultiplayerController(MultiplayerService multiplayerService, UserService userService, UserGameService userGameService, DeckService deckService) {
        this.multiplayerService = multiplayerService;
        this.userService = userService;
        this.deckService = deckService;
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {
        return VIEWS_MULTIPLAYER_CREATE_FORM;
    }

    @PostMapping("/create")
    public String createGame(@RequestParam("isPublic") String isPublic, Map<String, Object> model){
        Multiplayer game;
        boolean isGamePublic = Boolean.parseBoolean(isPublic);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        if(isGamePublic) {
            Multiplayer gameInQueue = multiplayerService.getNextGameInQueue();

            if(gameInQueue==null){
                game = multiplayerService.createNewGame(isGamePublic, user);
            } else {
                game = gameInQueue;
                multiplayerService.addUserToGameInQueue(isGamePublic, game, user);
                multiplayerService.addInitialCards(game, deckService.getDeckCards(deckService.findByID(1)));
                multiplayerService.drawCardsFromDeck(game);
                multiplayerService.startGame(game.getId());
            }
            return "redirect:/multiplayer/queue/" + game.getId();

        }else{
            game = multiplayerService.createNewGame(Boolean.parseBoolean(isPublic),user);
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
        model.put("cardsOnBoard", multiplayerService.getAllCardsInBoard(id));
        model.put("userCardsOnBoard", multiplayerService.getAllUserCardByGame(game.getId(), user.getId()));
        model.put("handCards", multiplayerService.getAllCardsInHand(id, user.getId()));
        model.put("lastPlacedCard", multiplayerService.getLastPlacedCard(game.getId(), user.getId()));
        model.put("userGameRelation", game.getUsers().stream().filter(ug -> ug.getUser().equals(user)).findFirst().get());
        model.put("cards_left", multiplayerService.getAllCardsInDeck(id, user.getId()).size());
        return VIEWS_MULTIPLAYER_GAME;
    }


}
