package org.harmony.endofline.gameInvite;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Controller
public class GameInviteController {

    private static final String VIEWS_USER_INVITATIONS = "users/invitations";

    private final UserService userService;

    private final GameInviteService gameInviteService;

    private final MultiplayerService multiplayerService;

    @Autowired
    public GameInviteController(GameInviteService gameInviteService, UserService userService, MultiplayerService multiplayerService) {
        this.gameInviteService = gameInviteService;
        this.userService = userService;
        this.multiplayerService = multiplayerService;
    }


    @GetMapping("/u/{username}/invitations")
    public String getInvitations(@PathVariable String username, Map<String, Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());

        User user = this.userService.findByUsername(username);
        if (!user.equals(authenticatedUser))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        model.put("invitations", userService.getInvitations(user));
        model.put("pending_received_invitations", gameInviteService.getByReciever(user));
        model.put("pending_sent_invitations", gameInviteService.getBySender(user));
        return VIEWS_USER_INVITATIONS;
    }

    @GetMapping("/gameinvites/{id}/accept")
    public String acceptInvite(@PathVariable("id") Integer id){

        gameInviteService.acceptInvite(id);
        return "redirect:/multiplayer/" + gameInviteService.getGameById(id).getId();
    }

    @GetMapping("/gameinvites/{id}/decline")
    public String declineInvite(@PathVariable("id") Integer id){

        gameInviteService.declineInvite(id);
        return "redirect:/multiplayer/" + gameInviteService.getGameById(id).getId();
    }

    @GetMapping("/invitefriend/{id}")
    public String inviteForm(@PathVariable("id") Integer gameId,Map<String, Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        model.put("friends", userService.getFriends(user));
        model.put("gameId", gameId);
        model.put("invites", gameInviteService.getBySender(user));

        return "multiplayer/gameInviteCreate";
    }

    @GetMapping("/gameinvite/{gameId}")
    public String createGameInvite(@RequestParam("friend") String friend,@PathVariable("gameId") Integer gameId, Map<String, Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        gameInviteService.sendInvite(multiplayerService.getById(gameId),user,userService.findByUsername(friend),InviteType.PLAYER);

        return "redirect:/invitefriend/" + gameId;
    }



    @GetMapping("/spectateinvite/{gameId}")
    public String createSpectateInvite(@RequestParam("friend") String friend,@PathVariable("gameId") Integer gameId, Map<String, Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        gameInviteService.sendInvite(multiplayerService.getById(gameId),user,userService.findByUsername(friend),InviteType.SPECTATE);

        return "redirect:/invitefriend/" + gameId;
    }

    @GetMapping("invite/delete/{id}/{gameId}")
    public String deleteInvite(@PathVariable("id") Integer inviteId,@PathVariable("gameId") Integer gameId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        gameInviteService.cancelInvite(inviteId);

        return "redirect:/invitefriend/" + gameId;
    }
}
