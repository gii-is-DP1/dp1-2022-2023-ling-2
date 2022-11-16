package org.harmony.endofline.achievement;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void addAchievementWorks() throws InvalidAchievementNameExeption {
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);
        assertThat(a.getName()).isEqualTo("Test Achievement");
        assertThat(a.getDescription()).isEqualTo("An achievement for tests");
        assertThat(a.getConditions()).isEqualTo(Achievement.condits.MULTIPLAYER_AMOUNT);
        assertThat(a.getConditionAmounts()).isEqualTo(20);
        assertThat(this.aService.exists(a)).isEqualTo(true);
    }

    @Test
    public void updateAchievementWorks() throws InvalidAchievementNameExeption {
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);
        assertThat(a.getName()).isEqualTo("Test Achievement");
        assertThat(a.getDescription()).isEqualTo("An achievement for tests");
        assertThat(a.getConditions()).isEqualTo(Achievement.condits.MULTIPLAYER_AMOUNT);
        assertThat(a.getConditionAmounts()).isEqualTo(20);

        a.setName("Changed name");
        Integer id = a.getId();
        this.aService.updateAchievement(a, id);
        assertThat(a.getName()).isEqualTo("Changed name");
        assertThat(this.aService.exists(a)).isEqualTo(true);
    }

    @Test
    public void deleteAchievementWorks() throws InvalidAchievementNameExeption {
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);

        this.aService.deleteAchievement(a.getName());
        assertThat(this.aService.exists(a)).isEqualTo(false);
    }

    @Test
    public void updateAchievementNameTooLong() throws InvalidAchievementNameExeption {
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

    @Test
    public void addAchievementNameTaken() throws InvalidAchievementNameExeption {
        Achievement a = new Achievement();
        a.setName("Winner");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);

        assertThrows(InvalidAchievementNameExeption.class,
            () -> this.aService.addAchievement(a));
    }

    @Test
    public void updateAchievementNameTaken() throws InvalidAchievementNameExeption {
        Achievement a = new Achievement();
        a.setName("Test Achievement");
        a.setDescription("An achievement for tests");
        a.setConditions(Achievement.condits.MULTIPLAYER_AMOUNT);
        a.setConditionAmounts(20);
        this.aService.addAchievement(a);

        a.setName("Winner");
        Integer id = a.getId();
        assertThrows(DataIntegrityViolationException.class,
            () -> this.aService.updateAchievement(a, id));
    }
}
