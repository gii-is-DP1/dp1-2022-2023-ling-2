package org.harmony.endofline.achievement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class AchievementServiceTest {
    @Autowired
    AchievementService aService;

    @Test
    public void shouldFindByName(){
        Achievement a = this.aService.findByName("Winner");
        assertThat(a.getId()).isEqualTo(1);
    }

    @Test
    public void shouldExist(){
        Achievement a = this.aService.findByName("TEST admin 2");
        assertThat(this.aService.exists(a)).isEqualTo(true);
    }

    @Test
    public void addAchievementWorks(){
        // TODO
    }

    @Test
    public void updateAchievementWorks(){
        // TODO
    }

    @Test
    public void deleteAchievementWorks(){
        // TODO
    }

    @Test
    public void shouldValidateUserAchievement(){
       // TODO
       // user meets achievement criteria
    }

    @Test
    public void shouldNotValidateUserAchievement(){
       // TODO
       // user doesn't meet achievement criteria
    }

    @Test
    public void updateAchievementNameTooLong(){
        // TODO
    }

    @Test
    public void updateAchievementNameTooShort(){
        // TODO
    }




}
