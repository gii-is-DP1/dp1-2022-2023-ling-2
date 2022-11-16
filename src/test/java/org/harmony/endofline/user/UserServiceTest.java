package org.harmony.endofline.user;


import org.assertj.core.api.Assertions;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.userGame.UserGame;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class UserServiceTest {

    @Autowired
    protected UserService userService;

    @Test
    public void shouldFindUsersByUsername() {
        User user = this.userService.findByUsername("user");
        assertThat(user.getId()).isEqualTo(2);
    }

    @Test
    public void usernameIsTaken() {
        assertThat(this.userService.isUsernameTaken("user")).isEqualTo(true);
    }

    @Test
    public void usernameIsFree() {
        assertThat(this.userService.isUsernameTaken("newUser")).isEqualTo(false);
    }

    @Test
    public void emailIsTaken() {
        assertThat(this.userService.isEmailTaken("admin@localhost.com")).isEqualTo(true);
    }

    @Test
    public void emailIsFree() {
        assertThat(this.userService.isEmailTaken("second-admin@localhost.com")).isEqualTo(false);
    }


    @Test
    public void saveNewUserWorks() {
        User user = new User();
        user.setUsername("username");
        user.setEmail("username@localhost.com");
        user.setPassword("password");
        this.userService.createUser(user);
        assertThat(user.getUsername()).isEqualTo("username");
        assertThat(user.getEmail()).isEqualTo("username@localhost.com");
        assertThat(user.getPassword()).isEqualTo("password");
    }

    @Test
    public void updateUserWorks() {
        User user = new User();
        user.setUsername("username");
        user.setEmail("username@localhost.com");
        user.setPassword("password");
        this.userService.createUser(user);
        assertThat(user.getUsername()).isEqualTo("username");

        user.setUsername("new-username");
        this.userService.updateUser(user);
        assertThat(user.getUsername()).isEqualTo("new-username");
    }

    @Test
    public void deleteUserWorks() {
        User user = new User();
        user.setUsername("username");
        user.setEmail("username@localhost.com");
        user.setPassword("password");
        this.userService.createUser(user);


        assertThat(this.userService.findByUsername("username")).isEqualTo(user);
        this.userService.deleteUser(user);
        assertThat(this.userService.findByUsername("username")).isNull();
    }

    @Test
    public void addUserGameWorks() {
        UserGame userGame = new UserGame();
        User user = new User();
        int userStats = user.getStatistic().getNumberGames();
        this.userService.addUserGame(user, userGame);
        int newUserStats = user.getStatistic().getNumberGames();
        Set<UserGame> gameSet = user.getMultiplayerGames();
        assertThat(gameSet.contains(userGame)).isTrue();
        assertThat(newUserStats).isEqualTo(userStats+1);
    }

    @Test
    public void addSingleplayerGame() {
        Singleplayer singleplayer = new Singleplayer();
        User user = new User();
        this.userService.addSingleplayerGame(user, singleplayer);
        Set<Singleplayer> gameSet = user.getSingleplayerGames();
        assertThat(gameSet.contains(singleplayer)).isTrue();

    }

    @Test
    public void getAllUsersWorks() {
        List<User> users = this.userService.getAllUsers();
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    void shouldGetMultiplayerGamesOfUser1(){
        List<Multiplayer> games = userService.getMultiplayerGames("admin");
        Assertions.assertThat(games).hasSize(1);
        Assertions.assertThat(games.get(0).getUsers()).hasSize(2);
    }

    @Test
    void shouldGetSingleplayerGamesOfUser1(){
        List<Singleplayer> games = userService.getSingleplayerGames("admin");
        Assertions.assertThat(games).hasSize(1);
    }
}
