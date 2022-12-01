package org.harmony.endofline.singleplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void shouldGiveAllHandCardsOfGameOne(){
        List<GameCard> cards = singleplayerService.getAllCardsInHand(1);
        assertEquals(cards.size(), 1);
        assertThat(cards.stream().allMatch(c -> c.getCard().getId()==3));
    }

    @Test
    void shouldGiveAllBoardCardsOfGameOne(){
        List<GameCard> cards = singleplayerService.getAllCardsInBoard(1);
        assertEquals(cards.size(), 1);
        assertThat(cards.stream().allMatch(c -> c.getCard().getId()==3));
    }


}
