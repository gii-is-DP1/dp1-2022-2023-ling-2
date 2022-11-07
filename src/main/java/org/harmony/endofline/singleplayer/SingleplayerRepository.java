package org.harmony.endofline.singleplayer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingleplayerRepository extends CrudRepository<Singleplayer, Integer> {
    @Override
    @Query("SELECT s FROM Singleplayer s jOIN FETCH s.user")
    List<Singleplayer> findAll();
}
