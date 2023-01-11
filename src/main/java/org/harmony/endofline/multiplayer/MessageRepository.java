package org.harmony.endofline.multiplayer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Query("SELECT DISTINCT m FROM Message m JOIN m.game g WHERE g.id=:gameId ORDER BY m.creationDateTime ASC")
    List<Message> findAllGameMessages(@Param("gameId") Integer gameId);
}
