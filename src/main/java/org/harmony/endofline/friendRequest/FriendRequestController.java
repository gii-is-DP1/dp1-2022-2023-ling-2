package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("/friendrequest")
public class FriendRequestController {

    private final FriendRequestService friendRequestService;
    private final UserService userService;

    @Autowired
    public FriendRequestController(FriendRequestService friendRequestService, UserService userService) {
        this.friendRequestService = friendRequestService;
        this.userService = userService;
    }

    @PostMapping("/send/{username}")
    public String sendRequest(@PathVariable("username") String username) throws InvalidFriendRequestException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.findByUsername(auth.getName());

        User receiver = userService.findByUsername(username);

        try {
            friendRequestService.newRequest(sender, receiver);
        } catch (InvalidFriendRequestException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }

        return "redirect:/u/{username}";
    }

    @GetMapping("/{id}/accept")
    public String acceptRequest(@PathVariable("id") Integer friendRequestId) throws InvalidFriendRequestException {
        FriendRequest fr = friendRequestService.findById(friendRequestId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User receiver = userService.findByUsername(auth.getName());

        friendRequestService.isReceiverOfRequest(receiver, fr);

        friendRequestService.acceptRequest(fr);

        return "redirect:/u/"+receiver.getUsername()+"/friends";
    }

    @GetMapping("/{id}/reject")
    public String rejectRequest(@PathVariable("id") Integer friendRequestId) throws InvalidFriendRequestException {
        FriendRequest fr = friendRequestService.findById(friendRequestId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User receiver = userService.findByUsername(auth.getName());

        friendRequestService.isReceiverOfRequest(receiver, fr);

        friendRequestService.rejectRequest(fr);

        return "redirect:/u/"+receiver.getUsername()+"/friends";
    }

}
