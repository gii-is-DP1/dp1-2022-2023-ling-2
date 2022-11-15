package org.harmony.endofline.achievement;

import org.harmony.endofline.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AchievementRepository extends CrudRepository<Achievement, Integer> {

    @Query("SELECT achievement FROM Achievement achievement WHERE achievement.name =:achievementName")
    Achievement findByName(@Param("achievementName") String achievementName);

    @Modifying
    @Query("UPDATE Achievement achievement SET achievement.name=:name, achievement.description =:description, achievement.conditions=:conditions,achievement.conditionAmounts=:conditionAmount WHERE achievement.id =:id")
    void update(@Param("name") String name, @Param("description") String description, @Param("conditions") Achievement.condits conditions, @Param("conditionAmount") Integer conditionAmount, @Param("id")Integer id);

    @Query("SELECT a FROM Achievement a WHERE a.name=:name")
    Achievement getByName(@Param("name") String name);
}
