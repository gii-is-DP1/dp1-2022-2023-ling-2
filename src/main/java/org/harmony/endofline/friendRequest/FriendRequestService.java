package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class FriendRequestService {

    private final FriendRequestRepository friendRequestRepository;

    @Autowired
    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    @Transactional
    public void newRequest(User sender, User receiver){
        FriendRequest request = new FriendRequest(sender, receiver);
        friendRequestRepository.save(request);
    }

    public void IsReceiverOfRequest(User user, FriendRequest friendRequest){
         boolean isReceiver = friendRequest.getReceiver().getId().equals(user.getId());
         if(!isReceiver)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not the receiver of this request");
    }

    public FriendRequest findById(Integer friendRequestId) {
        FriendRequest res = friendRequestRepository.findById(friendRequestId).orElse(null);
        if (res==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Friend Request not found");
        else
            return res;
    }

    @Transactional
    public void acceptRequest(FriendRequest fr) {
        fr.setPending(false);
        fr.setAccepted(true);
        fr.sender.addFriend(fr.receiver);
        fr.receiver.addFriend(fr.sender);
    }

    public void rejectRequest(FriendRequest fr) {
        fr.setPending(false);
        fr.setAccepted(false);
    }
}
