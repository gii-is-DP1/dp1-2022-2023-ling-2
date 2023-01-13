package org.harmony.endofline.gameInvite;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameInviteRepository extends CrudRepository<GameInvite, Integer> {

    @Query("SELECT g FROM GameInvite g WHERE g.game.id =:gameID AND g.status=0 AND g.type = 0")
    List<GameInvite> findAllInvitesOfGame(@Param("gameID") Integer gameID);

    @Query("SELECT g FROM GameInvite g WHERE g.receiver.id =:userId AND g.status=0")
    List<GameInvite> findByReciever(@Param("userId") Integer userId);

    @Query("SELECT g FROM GameInvite g WHERE g.receiver.id =:userId AND g.status=0 AND g.game.id=:gameId")
    List<GameInvite> findByRecieverAndGame(@Param("userId") Integer userId, @Param("gameId") Integer gameId);

    @Query("SELECT g FROM GameInvite g WHERE g.sender.id =:userId AND g.status=0 AND g.game.id=:gameId")
    List<GameInvite> findBySenderAndGame(@Param("userId") Integer userId, @Param("gameId") Integer gameId);

    @Query("SELECT g FROM GameInvite g WHERE g.sender.id =:userId AND g.status=0")
    List<GameInvite> findBySender(@Param("userId") Integer userId);

    @Query("SELECT g.game FROM GameInvite g WHERE g.id =:inviteId")
    Multiplayer findGameByInviteId(@Param("inviteId") Integer inviteId);

    @Query("SELECT DISTINCT u FROM GameInvite g JOIN g.sender s JOIN g.receiver u JOIN g.game game WHERE s.id=:userId AND game.id=:gameId")
    List<User> findFriendsInvited(@Param("userId") Integer userId, @Param("gameId") Integer gameId);
}
