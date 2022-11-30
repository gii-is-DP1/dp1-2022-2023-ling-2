package org.harmony.endofline.singleplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SingleplayerRepository extends CrudRepository<Singleplayer, Integer> {
    @Override
    @Query("SELECT s FROM Singleplayer s jOIN FETCH s.user")
    List<Singleplayer> findAll();

    @Query("SELECT s.gameCards FROM Singleplayer s WHERE s.id=:id")
    List<GameCard> FindAllGameCards(@Param("id") Integer id);

}
