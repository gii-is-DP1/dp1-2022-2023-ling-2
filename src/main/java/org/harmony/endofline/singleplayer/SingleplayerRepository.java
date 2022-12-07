package org.harmony.endofline.singleplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SingleplayerRepository extends CrudRepository<Singleplayer, Integer> {
    @Override
    @Query("SELECT s FROM Singleplayer s jOIN FETCH s.user")
    List<Singleplayer> findAll();

    @Query("SELECT gc FROM GameCard gc WHERE gc.gameID=:id AND gc.isMultiplayer=false")
    List<GameCard> FindAllGameCards(@Param("id") Integer id);

    @Query("SELECT gc FROM GameCard gc WHERE gc.gameID=:id AND gc.isMultiplayer=false AND gc.status=2")
    List<GameCard> findCardsInDeck(@Param("id") Integer id);

    @Query("SELECT gc FROM GameCard gc WHERE gc.gameID=:id AND gc.isMultiplayer=false AND gc.status=1")
    List<GameCard> findCardsInHand(@Param("id") Integer id);

    @Query("SELECT gc FROM GameCard gc WHERE gc.gameID=:id AND gc.isMultiplayer=false AND gc.status=0")
    List<GameCard> findCardsInBoard(@Param("id") Integer id);

    @Query("SELECT s FROM Singleplayer s WHERE s.user=:user AND s.id=:gameId")
    List<Singleplayer> FindUserSingleplayerGame(User user, Integer gameId);

}
