package org.harmony.endofline.multiplayer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MultiplayerRepository extends CrudRepository<Multiplayer, Integer> {

    @Override
    @Query("SELECT DISTINCT m FROM Multiplayer m jOIN FETCH m.users ug JOIN FETCH ug.user")
    List<Multiplayer> findAll();

    @Query("SELECT m FROM Multiplayer m WHERE m.inQueue = 0 AND m.isPublic = 1 ORDER BY m.searchDate")
    List<Multiplayer> findSearching();
}
