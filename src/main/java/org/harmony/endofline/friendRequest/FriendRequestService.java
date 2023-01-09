package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FriendRequestService {

    private final FriendRequestRepository friendRequestRepository;

    @Autowired
    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    @Transactional
    public void newRequest(User sender, User receiver) throws InvalidFriendRequestException {
        if (sender.equals(receiver))
            throw new InvalidFriendRequestException("Cannot send a friend request to yourself");
        if (sender.getFriends().contains(receiver))
            throw new InvalidFriendRequestException("You are already friends with this user");
        if (friendRequestRepository.findPendingPair(sender, receiver)!=null)
            throw new InvalidFriendRequestException("Ongoing friend request with this user");
        FriendRequest request = new FriendRequest(sender, receiver);
        friendRequestRepository.save(request);
    }

    public void IsReceiverOfRequest(User user, FriendRequest friendRequest) throws InvalidFriendRequestException {
         boolean isReceiver = friendRequest.getReceiver().getId().equals(user.getId());
         if(!isReceiver)
            throw new InvalidFriendRequestException("You are not the receiver of this request");
    }

    public FriendRequest findById(Integer friendRequestId) throws InvalidFriendRequestException {
        FriendRequest res = friendRequestRepository.findById(friendRequestId).orElse(null);
        if (res==null)
            throw new InvalidFriendRequestException("Friend request not found");
        else
            return res;
    }

    @Transactional
    public void acceptRequest(FriendRequest fr) {
        fr.setState(FriendRequestState.ACCEPTED);
        fr.sender.addFriend(fr.receiver);
        fr.receiver.addFriend(fr.sender);
    }

    @Transactional
    public void rejectRequest(FriendRequest fr) {
        fr.setState(FriendRequestState.REJECTED);
    }

    public FriendRequest findRequestByUsers(User sender, User receiver) {
        return friendRequestRepository.findPendingPair(sender, receiver);
    }

}
