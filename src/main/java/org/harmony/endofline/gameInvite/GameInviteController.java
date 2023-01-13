package org.harmony.endofline.gameInvite;

import org.harmony.endofline.deck.DeckService;
import org.harmony.endofline.model.GameStatus;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Controller
@RequestMapping("/gameinvite")
public class GameInviteController {

    private final UserService userService;
    private final GameInviteService gameInviteService;
    private final MultiplayerService multiplayerService;
    private final DeckService deckService;

    @Autowired
    public GameInviteController(GameInviteService gameInviteService, UserService userService, MultiplayerService multiplayerService, DeckService deckService) {
        this.gameInviteService = gameInviteService;
        this.userService = userService;
        this.multiplayerService = multiplayerService;
        this.deckService = deckService;
    }

    @GetMapping("/create")
    public String createGameInvite(@RequestParam("friend") String friend, @RequestParam("gameId") Integer gameId, @RequestParam("type") Integer type){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        InviteType inviteType;
        Multiplayer game = multiplayerService.getById(gameId);

        switch (type){
            case 0: inviteType = InviteType.PLAYER; break;
            default: inviteType = InviteType.SPECTATE; break;
        }
        if(game.getGameStatus().equals(GameStatus.CREATED)                          ){
            gameInviteService.deleteAllGameInvitesToReceiver(userService.findByUsername(friend), gameId);
            gameInviteService.sendInvite(multiplayerService.getById(gameId),user,userService.findByUsername(friend),inviteType);
        }

        return "redirect:/multiplayer/" + gameId;
    }

    @GetMapping("/delete/{id}/{gameId}")
    public String deleteInvite(@PathVariable("id") Integer inviteId,@PathVariable("gameId") Integer gameId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        GameInvite invite = gameInviteService.findById(inviteId);

        if(!gameInviteService.isSenderOfRequest(user, invite))
            return "redirect:/welcome";

        gameInviteService.deleteInvite(invite);

        return "redirect:/multiplayer/" + gameId;
    }

    @GetMapping("/{id}/accept")
    public String acceptInvite(@PathVariable("id") Integer id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        GameInvite invite = gameInviteService.findById(id);

        if(!gameInviteService.isReceiverOfRequest(user, invite))
            return "redirect:/welcome";

        gameInviteService.acceptInvite(invite);
        if(invite.type == InviteType.PLAYER) {
            gameInviteService.setAllPendingCanceled(invite.game.getId());
            multiplayerService.addUserToGameInQueue(false,invite.game, invite.getReceiver());
            multiplayerService.addInitialCards(invite.game, deckService.getDeckCards(deckService.findByID(1)));
            multiplayerService.drawCardsFromDeck(invite.game);
        }else{
            this.multiplayerService.addSpectator(invite.getReceiver(),invite.game);
        }

        Integer gameId = gameInviteService.getGameByInviteId(id).getId();
        return "redirect:/multiplayer/" + gameId;
    }


    @GetMapping("/{id}/decline")
    public String declineInvite(@PathVariable("id") Integer id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        GameInvite invite = gameInviteService.findById(id);

        if(!gameInviteService.isReceiverOfRequest(user, invite))
            return "redirect:/welcome";

        gameInviteService.declineInvite(invite);
        return "redirect:/u/" + user.getUsername() +"/invitations";
    }
}
