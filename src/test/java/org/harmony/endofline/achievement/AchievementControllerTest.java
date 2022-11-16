package org.harmony.endofline.achievement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class AchievementControllerTest {

    @Autowired
    AchievementService aService;

    @Test
    public void shouldValidateUserAchievement() throws InvalidAchievementNameExeption {
        // TODO
        // user meets achievement criteria
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);



    }

    @Test
    public void shouldNotValidateUserAchievement() throws InvalidAchievementNameExeption {
        // TODO
        // user doesn't meet achievement criteria
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);
    }

    @Test
    public void updateAchievementNameTooLong() throws InvalidAchievementNameExeption {
        // Exception expected temporarily changed to ConstraintViolationException
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);

        a.setName("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Integer id = a.getId();
        assertThrows(ConstraintViolationException.class,
            () -> this.aService.updateAchievement(a, id));
    }


    @Test
    public void updateAchievementNameTooShort() throws InvalidAchievementNameExeption {
        // Exception expected temporarily changed to ConstraintViolationException
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);

        a.setName("hi");
        Integer id = a.getId();
        assertThrows(ConstraintViolationException.class,
            () -> this.aService.updateAchievement(a, id));
    }
}
