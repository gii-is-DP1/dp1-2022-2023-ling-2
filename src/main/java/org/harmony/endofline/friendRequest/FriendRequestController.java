package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String SendRequest(@PathVariable("username") String username){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.findByUsername(auth.getName());

        User receiver = userService.findByUsername(username);

        friendRequestService.newRequest(sender, receiver);

        return "redirect:/u/{username}/friends";
    }

    @GetMapping("/{id}/accept")
    public String AcceptRequest(@PathVariable("id") Integer friendRequestId) throws ResponseStatusException {
        FriendRequest fr = friendRequestService.findById(friendRequestId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User receiver = userService.findByUsername(auth.getName());

        friendRequestService.IsReceiverOfRequest(receiver, fr);

        friendRequestService.acceptRequest(fr);

        return "redirect:/u/{receiver.username}/friends";
    }

    @GetMapping("/{id}/reject")
    public String RejectRequest(@PathVariable("id") Integer friendRequestId) throws ResponseStatusException{
        FriendRequest fr = friendRequestService.findById(friendRequestId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User receiver = userService.findByUsername(auth.getName());

        friendRequestService.IsReceiverOfRequest(receiver, fr);

        friendRequestService.rejectRequest(fr);

        return "redirect:/u/{receiver.username}/friends";
    }

}
