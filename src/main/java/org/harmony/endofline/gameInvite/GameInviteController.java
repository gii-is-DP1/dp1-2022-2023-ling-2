package org.harmony.endofline.gameInvite;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Controller
public class GameInviteController {

    private static final String VIEWS_USER_INVITATIONS = "users/invitations";

    private final UserService userService;

    private final GameInviteService gameInviteService;

    public GameInviteController(GameInviteService gameInviteService, UserService userService) {
        this.gameInviteService = gameInviteService;
        this.userService = userService;
    }


    @GetMapping("/u/{username}/invitations")
    public String getInvitations(@PathVariable String username, Map<String, Object> model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());

        User user = this.userService.findByUsername(username);
        if (!user.equals(authenticatedUser))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        model.put("invitations", userService.getInvitations(user));
        model.put("pending_received_invitations", userService.getPendingReceivedInvitations(user));
        model.put("pending_sent_invitations", userService.getPendingSentInvitations(user));
        return VIEWS_USER_INVITATIONS;
    }
}
