package org.harmony.endofline.user;

import org.harmony.endofline.achievement.Achievement;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT user FROM User user WHERE user.username=:username")
    User findByUsername(@Param("username") String username);

    @Query("SELECT DISTINCT mult FROM Multiplayer mult JOIN mult.users ug JOIN ug.user u WHERE u.username=:username ORDER BY mult.dateStarted DESC")
    List<Multiplayer> findUserMultiplayerGames(String username);

    @Query("SELECT DISTINCT singl FROM Singleplayer singl JOIN singl.user u WHERE u.username=:username ORDER BY singl.dateStarted DESC")
    List<Singleplayer> findUserSingleplayerGames(String username);

    @Query("SELECT user FROM User user WHERE user.email=:email")
    User findByEmail(@Param("email") String email);

    @Modifying
    void deleteByUsername(String username);

    @Query("SELECT DISTINCT a FROM Achievement a JOIN a.users u WHERE u.username=:username")
    List<Achievement> findAchievementsByUsername(@Param("username") String username);
}
