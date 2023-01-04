package org.harmony.endofline.gameInvite;

import org.harmony.endofline.achievement.Achievement;
import org.harmony.endofline.userGame.UserGame;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameInviteRepository extends CrudRepository<GameInvite, Integer> {

    @Query("SELECT g FROM GameInvite g WHERE g.game.id =:gameID AND g.pending = TRUE AND g.canceled = FALSE")
    List<GameInvite> findAllInvitesOfGame(@Param("gameID") Integer gameID);

    @Modifying
    @Query("UPDATE GameInvite invite SET invite.accepted=:accepted, invite.pending=:pending, invite.canceled=:canceled WHERE invite.id =:id")
    void update(@Param("accepted") Boolean accepted, @Param("pending") Boolean pending, @Param("canceled") Boolean canceled, @Param("id")Integer id);


}
