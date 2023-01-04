package org.harmony.endofline.multiplayer;

import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MultiplayerRepository extends CrudRepository<Multiplayer, Integer> {

    @Override
    @Query("SELECT DISTINCT m FROM Multiplayer m jOIN FETCH m.users ug JOIN FETCH ug.user")
    List<Multiplayer> findAll();

    @Query("SELECT m FROM Multiplayer m WHERE m.gameStatus = 0 AND m.isPublic = TRUE ORDER BY m.searchDate")
    List<Multiplayer> findSearching();

    @Query("SELECT ug.user FROM UserGame ug JOIN ug.game g WHERE g.id=:gameid AND g.activePlayer<>ug.user")
    User getInactivePlayer(@Param("gameid") Integer id);

}
