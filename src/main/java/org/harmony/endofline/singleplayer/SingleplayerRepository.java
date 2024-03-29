package org.harmony.endofline.singleplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SingleplayerRepository extends CrudRepository<Singleplayer, Integer> {
    @Override
    @Query("SELECT s FROM Singleplayer s jOIN FETCH s.user ORDER BY s.dateCreated DESC")
    List<Singleplayer> findAll();

    @Query("SELECT s.gameCards FROM Singleplayer s WHERE s.id=:id")
    List<GameCard> FindAllGameCards(@Param("id") Integer id);

    @Query("SELECT gc FROM Singleplayer s JOIN s.gameCards gc WHERE s.id=:id AND gc.status=2")
    List<GameCard> findCardsInDeck(@Param("id") Integer id);

    @Query("SELECT gc FROM Singleplayer s JOIN s.gameCards gc WHERE s.id=:id AND gc.status=1")
    List<GameCard> findCardsInHand(@Param("id") Integer id);

    @Query("SELECT gc FROM Singleplayer s JOIN s.gameCards gc WHERE s.id=:id AND gc.status=0")
    List<GameCard> findCardsInBoard(@Param("id") Integer id);

    @Query("SELECT s FROM Singleplayer s WHERE s.user=:user AND s.id=:gameId")
    List<Singleplayer> FindUserSingleplayerGame(User user, Integer gameId);

    @Query("SELECT gc FROM Singleplayer s JOIN s.gameCards gc WHERE s.id=:gameId AND gc.status = 0 ORDER BY gc.updated DESC")
    List<GameCard> findLastPlacedCard(@Param("gameId") Integer gameId);
}
