package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.harmony.endofline.friendRequest.FriendRequestState;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Integer> {

    @Query("SELECT fr FROM FriendRequest fr WHERE (fr.sender = ?1 AND fr.receiver = ?2) OR (fr.sender = ?2 AND fr.receiver = ?1)")
    FriendRequest findByUsers(User sender, User receiver);

    @Query("SELECT fr FROM FriendRequest fr WHERE fr.state = 0 AND ((fr.sender=:sender AND fr.receiver=:receiver) OR (fr.sender=:receiver AND fr.receiver=:sender))")
    FriendRequest findPendingPair(User sender, User receiver);
}
