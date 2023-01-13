package org.harmony.endofline.multiplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MultiplayerRepository extends CrudRepository<Multiplayer, Integer> {

    @Override
    @Query("SELECT DISTINCT m FROM Multiplayer m jOIN FETCH m.users ug JOIN FETCH ug.user")
    List<Multiplayer> findAll();

    @Query("SELECT m FROM Multiplayer m WHERE m.gameStatus = 0 AND m.isPublic = TRUE ORDER BY m.dateCreated")
    List<Multiplayer> findSearching();

    @Query("SELECT ug.user FROM UserGame ug JOIN ug.game g WHERE ug.role = 0 AND g.id=:gameid AND g.activePlayer<>ug.user")
    User getInactivePlayer(@Param("gameid") Integer id);

    @Query("SELECT gc FROM Multiplayer m JOIN m.gameCards gc WHERE m.id=:id AND gc.status=0")
    List<GameCard> findCardsInBoard(@Param("id") Integer id);

    @Query("SELECT gc FROM Multiplayer m JOIN m.gameCards gc WHERE m.id=:gameId AND gc.user.id=:userId AND gc.status=1")
    List<GameCard> findCardsInHand(@Param("gameId") Integer gameId, @Param("userId") Integer userId);

    @Query("SELECT gc FROM Multiplayer m JOIN m.gameCards gc WHERE m.id=:gameId AND gc.user.id=:userId AND gc.status=2")
    List<GameCard> findCardsInDeck(@Param("gameId") Integer gameId, @Param("userId") Integer userId);

    @Query("SELECT u FROM UserGame ug JOIN ug.user u JOIN ug.game g WHERE g.id=:gameId AND ug.player=1")
    User findPlayer1(@Param("gameId") Integer gameid);

    @Query("SELECT u FROM UserGame ug JOIN ug.user u JOIN ug.game g WHERE g.id=:gameId AND ug.player=2")
    User findPlayer2(@Param("gameId") Integer gameid);

}
