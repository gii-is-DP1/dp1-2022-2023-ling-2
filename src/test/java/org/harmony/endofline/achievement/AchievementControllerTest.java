package org.harmony.endofline.achievement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;



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


}
