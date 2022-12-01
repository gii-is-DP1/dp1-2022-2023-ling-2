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
        assertEquals(cards.size(), 3);
        assertEquals(cards.get(0).getCard().getId(), 3);
    }

    @Test
    void shouldGiveAllBoardCardsOfGameOne(){
        List<GameCard> cards = singleplayerService.getAllCardsInBoard(1);
        assertEquals(cards.size(), 1);
        assertThat(cards.stream().allMatch(c -> c.getCard().getId()==3));
    }

    @Test
    void validCardsPlacement() throws InvalidIDException {
        shouldPlaceCardNoRotationNoWrapAround();
        shouldHaveLastPlacedCardIdTwo();
        shouldPlaceCardWithWrapAround();
        shouldPlaceCardWithCorrectRotation();
    }

    private void shouldPlaceCardNoRotationNoWrapAround() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 2;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 0;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 2);
        assertEquals(newCardsOnBoard.get(1).getX(), 2);
        assertEquals(newCardsOnBoard.get(1).getY(), 0);
    }

    private void shouldHaveLastPlacedCardIdTwo() throws InvalidIDException {
        Singleplayer game = singleplayerService.findByID(1);
        assertEquals(game.getLastPlacedCard().getId(), 2);
    }

    void shouldPlaceCardWithWrapAround() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 3;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 4;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 3);
        assertEquals(newCardsOnBoard.get(2).getX(), 2);
        assertEquals(newCardsOnBoard.get(2).getY(), 4);
    }

    void shouldPlaceCardWithCorrectRotation() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 4;
        Integer rotation = 1;
        Integer x = 3;
        Integer y = 4;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 4);
        assertEquals(newCardsOnBoard.get(3).getX(), 3);
        assertEquals(newCardsOnBoard.get(3).getY(), 4);
    }

}
