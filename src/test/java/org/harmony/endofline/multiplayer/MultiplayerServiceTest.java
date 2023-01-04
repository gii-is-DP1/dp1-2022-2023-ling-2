package org.harmony.endofline.multiplayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class MultiplayerServiceTest {
    @Autowired
    protected MultiplayerService multiService;
/*
    @Test
    void shouldFindAll(){
        Collection<Multiplayer> multiplayers =this.multiService.getAllGamesWithUser();
        assertThat(multiplayers).hasSize(2);
    }

    @Test
    void shouldAdvanceRound(){
        Multiplayer game = this.multiService.findGame(2);

        assertThat(game.getRound()==1);
        assertThat(game.getActivePlayer().getId()==1);

        this.multiService.advanceRound(game);

        assertThat(game.getRound()==2);
        assertThat(game.getActivePlayer().getId()==2);
    }



 */



}
