package org.harmony.endofline.friendRequest;

import org.harmony.endofline.card.Card;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface friendRequestRepository extends CrudRepository<FriendRequest, Integer> {

}
