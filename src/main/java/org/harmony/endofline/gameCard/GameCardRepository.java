package org.harmony.endofline.gameCard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GameCardRepository extends CrudRepository<GameCard, Integer> {
    @Query("SELECT gc FROM Multiplayer m JOIN m.gameCards gc WHERE m.id = ?1 AND gc.user.id = ?2 AND gc.round = ?3")
    List<GameCard> findByUserIdAndRound(Integer gameId, Integer userId, Integer round);

    @Query("SELECT gc FROM Multiplayer m JOIN m.gameCards gc WHERE m.id = ?1 AND gc.user.id = ?2 AND gc.status = 0 ORDER BY gc.updated DESC")
    List<GameCard> findByUserId(Integer gameId, Integer userId);
}
