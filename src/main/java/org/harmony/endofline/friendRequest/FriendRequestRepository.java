package org.harmony.endofline.friendRequest;

import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Integer> {

    @Query("SELECT fr FROM FriendRequest fr WHERE fr.pending IS TRUE AND ((fr.sender=:sender AND fr.receiver=:receiver) OR (fr.sender=:receiver AND fr.receiver=:sender))")
    FriendRequest findPendingPair(User sender, User receiver);
}
