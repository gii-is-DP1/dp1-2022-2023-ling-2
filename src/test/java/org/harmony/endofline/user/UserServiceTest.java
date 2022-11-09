package org.harmony.endofline.user;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserServiceTest {

    @Autowired
    protected UserRepository users;

    @Test
    void shouldGetMultiplayerGamesOfUser1(){
        List<Multiplayer> games = users.findUserMultiplayerGames("admin");
        assertThat(games).hasSize(1);
        assertThat(games.get(0).getUsers()).hasSize(2);
    }

    @Test
    void shouldGetSingleplayerGamesOfUser1(){
        List<Multiplayer> games = users.findUserMultiplayerGames("admin");
        assertThat(games).hasSize(1);
    }
}
