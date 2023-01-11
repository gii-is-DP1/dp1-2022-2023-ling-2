package org.harmony.endofline.multiplayer;

import org.harmony.endofline.deck.DeckService;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.singleplayer.InvalidIDException;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.harmony.endofline.userGame.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RequestMapping("/multiplayer")
@Controller
public class MultiplayerController {

    private static final String VIEWS_MULTIPLAYER_GAME = "multiplayer/MultiplayerBoard";
    private static final String VIEWS_MULTIPLAYER_CREATE_FORM = "multiplayer/gameSearch";
    private static final String VIEWS_PREGAME = "multiplayer/pregame";

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
    public String createGame(@RequestParam("isPublic") String isPublic, Map<String, Object> model) {
        Multiplayer game;
        boolean isGamePublic = Boolean.parseBoolean(isPublic);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        if (isGamePublic) {
            Multiplayer gameInQueue = multiplayerService.getNextGameInQueue();

            if (gameInQueue == null) {
                game = multiplayerService.createNewGame(isGamePublic, user);
            } else {
                game = gameInQueue;
                multiplayerService.addUserToGameInQueue(isGamePublic, game, user);
                multiplayerService.addInitialCards(game, deckService.getDeckCards(deckService.findByID(1)));
                multiplayerService.drawCardsFromDeck(game);
            }
            return "redirect:/multiplayer/pregamelobby/" + game.getId();

        } else {
            game = multiplayerService.createNewGame(Boolean.parseBoolean(isPublic), user);
            return "redirect:/invitefriend/" + game.getId();
        }
    }

    @GetMapping("/startGame/{gameId}")
    public String startGame(@PathVariable("gameId") Integer id, Map<String, Object> model) {
        Multiplayer game = multiplayerService.getById(id);
        multiplayerService.startGame(id);
        return "redirect:/multiplayer/" + game.getId();
    }

    @GetMapping("/pregamelobby/{gameId}")
    public String showLobby(@PathVariable("gameId") Integer id, Map<String, Object> model) {
        Multiplayer game = multiplayerService.getById(id);
        if (game.getIsPublic()) {
            Boolean ready = multiplayerService.checkGameReady(id);
            if (ready) {
                multiplayerService.startGame(game.getId());
                return "redirect:/multiplayer/" + id;
            } else {
                return VIEWS_PREGAME;
            }
        } else {
            if (multiplayerService.checkGameStarted(id)) {
                return "redirect:/multiplayer/" + id;
            } else {
                model.put("player1Username", game.getUsers().stream().filter(ug -> ug.getPlayer() == 1).findFirst().get().getUser().getUsername());
                model.put("player2Username", game.getUsers().stream().filter(ug -> ug.getPlayer() == 2).findFirst().get().getUser().getUsername());
                return VIEWS_PREGAME;
            }
        }
    }


    @GetMapping("/{id}")
    public String getGame(@PathVariable("id") Integer id, Map<String, Object> model) {
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
        model.put("isPlayerActive", game.getActivePlayer().equals(user));
        model.put("player", user);
        model.put("player1Id", game.getUsers().stream().filter(ug -> ug.getPlayer() == 1).findFirst().get().getUser().getId());
        model.put("player2Id", game.getUsers().stream().filter(ug -> ug.getPlayer() == 2).findFirst().get().getUser().getId());
        model.put("player1Username", game.getUsers().stream().filter(ug -> ug.getPlayer() == 1).findFirst().get().getUser().getUsername());
        model.put("player2Username", game.getUsers().stream().filter(ug -> ug.getPlayer() == 2).findFirst().get().getUser().getUsername());
        model.put("cards_left", multiplayerService.getAllCardsInDeck(id, user.getId()).size());
        model.put("messages", multiplayerService.getAllGameMessages(id));
        return VIEWS_MULTIPLAYER_GAME;
    }

    @PostMapping("/{id}/place")
    public String placeCard(@PathVariable("id") Integer id, @RequestParam("gcid") Integer gameCardId, @RequestParam("rotation") Integer rotation, @RequestParam("x") Integer x, @RequestParam("y") Integer y, @RequestParam("energy") Boolean energyUsed, @RequestParam("ability") Integer abilityOrdinal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            User user = userService.findByUsername(auth.getName());
            Multiplayer game = multiplayerService.getById(id);
            if (!multiplayerService.checkUserInGame(user, game))
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);

            List<GameCard> boardCards = multiplayerService.getAllCardsInBoard(id);

            abilityOrdinal = abilityOrdinal == null ? 0 : abilityOrdinal;
            multiplayerService.moveCard(id, user.getId(), boardCards, gameCardId, rotation, x, y, energyUsed, abilityOrdinal);
            multiplayerService.setResultIfApplicable(game);

            return "redirect:/multiplayer/" + id;
        } catch (InvalidIDException e) {
            return "welcome";
        }
    }


    @RequestMapping(value = "/info/queueStatus/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String checkPublicGameIsReady(@PathVariable("id") Integer id) {
        Boolean response = this.multiplayerService.checkGameReady(id);
        return response.toString();
    }


    @RequestMapping(value = "/info/queueStarted/{id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String checkGameIsStarted(@PathVariable("id") Integer id) {
        Boolean response = this.multiplayerService.checkGameStarted(id);
        return response.toString();
    }


}
