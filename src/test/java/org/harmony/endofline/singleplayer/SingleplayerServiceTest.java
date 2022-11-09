package org.harmony.endofline.singleplayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SingleplayerServiceTest {
    @Autowired
    protected SingleplayerService singleplayerService;

    @Test
    void shouldGiveAllSingleplayerGames(){
        List<Singleplayer> games = singleplayerService.getAllGamesWithUser();
        assertThat(games).hasSize(1);
    }
}
