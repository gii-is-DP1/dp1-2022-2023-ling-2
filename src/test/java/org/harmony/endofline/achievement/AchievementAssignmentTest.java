package org.harmony.endofline.achievement;

import org.harmony.endofline.puzzle.Difficulty;
import org.harmony.endofline.puzzle.PuzzleService;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.statistic.Statistic;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class AchievementAssignmentTest {

    @Autowired
    AchievementService aService;

    @Autowired
    UserService uService;

    @Autowired
    PuzzleService pService;

    @Test
    public void shouldValidateUserAchievement() throws InvalidAchievementNameExeption {
        // TODO
        // user meets achievement criteria
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.SINGLEPLAYER_AMOUNT);
        a.setConditionAmounts(5);
        this.aService.addAchievement(a);
        List<Achievement> achievements = aService.getAllAchievements();

        User user = new User();
        user.setUsername("username");
        user.setEmail("username@localhost.com");
        user.setPassword("password");
        this.uService.createUser(user);
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.EASY)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.EASY)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.MEDIUM)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.MEDIUM)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.MEDIUM)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.HARD)));

        user = aService.calculateAchievementsForUser(user,new Statistic(),achievements);
        assertThat(user.getAchievements()).contains(a);

    }

    @Test
    public void shouldNotValidateUserAchievement() throws InvalidAchievementNameExeption {
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.SINGLEPLAYER_AMOUNT);
        a.setConditionAmounts(10);
        this.aService.addAchievement(a);
        List<Achievement> achievements = aService.getAllAchievements();


        User user = new User();
        user.setUsername("username");
        user.setEmail("username@localhost.com");
        user.setPassword("password");
        this.uService.createUser(user);
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.EASY)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.EASY)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.MEDIUM)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.MEDIUM)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.MEDIUM)));
        this.uService.addSingleplayerGame(user,new Singleplayer(user, pService.randomByDifficulty(Difficulty.HARD)));

        user = aService.calculateAchievementsForUser(user,new Statistic(),achievements);

        assertThat(user.getAchievements()).doesNotContain(a);

    }


}
