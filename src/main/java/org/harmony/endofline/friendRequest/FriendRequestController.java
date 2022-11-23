package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/send")
    public String SendRequest(User receiver){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.findByUsername(auth.getName());

        friendRequestService.newRequest(sender, receiver);
        return "redirect:/u/{username}/friends";
    }

    @GetMapping("/{id}/accept")
    public String AcceptRequest(@PathVariable Integer friendRequestId){
        FriendRequest fr = friendRequestService.findById(friendRequestId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.findByUsername(auth.getName());

        friendRequestService.IsReceiverOfRequest(sender, fr);

        friendRequestService.acceptRequest(fr);

        return "redirect:/u/{username}/friends";
    }

    @GetMapping("/{id}/reject")
    public String RejectRequest(@PathVariable Integer friendRequestId){
        FriendRequest fr = friendRequestService.findById(friendRequestId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.findByUsername(auth.getName());

        friendRequestService.IsReceiverOfRequest(sender, fr);

        friendRequestService.rejectRequest(fr);

        return "redirect:/u/{username}/friends";
    }

}
