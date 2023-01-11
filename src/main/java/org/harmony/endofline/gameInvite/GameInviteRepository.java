package org.harmony.endofline.gameInvite;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameInviteRepository extends CrudRepository<GameInvite, Integer> {

    @Query("SELECT g FROM GameInvite g WHERE g.game.id =:gameID AND g.pending = TRUE AND g.canceled = FALSE AND g.type = 0")
    List<GameInvite> findAllInvitesOfGame(@Param("gameID") Integer gameID);

    @Modifying
    @Query("UPDATE GameInvite invite SET invite.accepted=:accepted, invite.pending=:pending, invite.canceled=:canceled WHERE invite.id =:id")
    void update(@Param("accepted") Boolean accepted, @Param("pending") Boolean pending, @Param("canceled") Boolean canceled, @Param("id")Integer id);

    @Query("SELECT g FROM GameInvite g WHERE g.receiver.id =:userId AND g.pending = TRUE AND g.canceled = FALSE")
    List<GameInvite> findByReciever(@Param("userId") Integer userId);

    @Query("SELECT g FROM GameInvite g WHERE g.sender.id =:userId AND g.pending = TRUE AND g.canceled = FALSE")
    List<GameInvite> findBySender(@Param("userId") Integer userId);

    @Query("SELECT g FROM GameInvite g WHERE g.receiver.id =:userId AND g.pending = TRUE AND g.canceled = FALSE AND g.game.id =:gameId")
    List<GameInvite> findByRecieverandId(@Param("userId") Integer userId,@Param("gameId")Integer gameId);

    @Query("SELECT g FROM GameInvite g WHERE g.sender.id =:userId AND g.pending = TRUE AND g.canceled = FALSE AND g.game.id =:gameId")
    List<GameInvite> findBySenderandId(@Param("userId") Integer userId, @Param("gameId")Integer gameId);

    @Query("SELECT g.game FROM GameInvite g WHERE g.id =:inviteId")
    Multiplayer findGameById(@Param("inviteId") Integer inviteId);
}
