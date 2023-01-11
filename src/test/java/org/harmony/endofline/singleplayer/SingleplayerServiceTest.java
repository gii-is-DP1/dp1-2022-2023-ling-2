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
        assertThat(games).hasSize(4);
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
        shouldPlaceCardWithEnergy();
    }

    private void shouldPlaceCardNoRotationNoWrapAround() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 2;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 0;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 2);
        assertEquals(newCardsOnBoard.get(1).getX(), 2);
        assertEquals(newCardsOnBoard.get(1).getY(), 0);
    }

    private void shouldHaveLastPlacedCardIdTwo() throws InvalidIDException {
        assertEquals(singleplayerService.getLastPlacedCard(1).getId(), 2);
    }

    void shouldPlaceCardWithWrapAround() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 3;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 4;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

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
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 4);
        assertEquals(newCardsOnBoard.get(3).getX(), 3);
        assertEquals(newCardsOnBoard.get(3).getY(), 4);
        assertEquals(newCardsOnBoard.get(3).getRotation(), 1);
    }

    private void shouldPlaceCardWithEnergy() throws InvalidIDException {
        Integer gameId = 2;
        Integer cardToMove = 6;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 0;
        boolean energyUsed = true;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 3);
        assertEquals(newCardsOnBoard.get(0).getX(), 2);
        assertEquals(newCardsOnBoard.get(0).getY(), 0);
        assertEquals(newCardsOnBoard.get(0).getRotation(), 0);
    }

    @Test
    void invalidCardsPlacement() throws InvalidIDException {
        shouldNotPlaceCardNoRotationNoWrapAround();
        shouldNotHaveLastPlacedCardIdTwo();
        shouldNotPlaceCardWithIncorrectRotation();
        shouldNotPlaceCardInOccupiedPosition();
        shouldPlaceCardWithNoEnergyLeft();
    }

    private void shouldNotPlaceCardNoRotationNoWrapAround() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 2;
        Integer rotation = 0;
        Integer x = 3;
        Integer y = 0;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard, cardsOnBoard);
    }

    private void shouldNotHaveLastPlacedCardIdTwo() throws InvalidIDException {
        assertEquals(singleplayerService.getLastPlacedCard(1).getId(), 1);
    }

    void shouldNotPlaceCardWithIncorrectRotation() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 4;
        Integer rotation = 1;
        Integer x = 3;
        Integer y = 4;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard, cardsOnBoard);
    }

    void shouldNotPlaceCardInOccupiedPosition() throws InvalidIDException {
        Integer gameId = 1;
        Integer cardToMove = 4;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 2;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard, cardsOnBoard);
    }

    private void shouldPlaceCardWithNoEnergyLeft() throws InvalidIDException {
        Integer gameId = 3;
        Integer cardToMove = 10;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 0;
        boolean energyUsed = true;
        List<GameCard> cardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        singleplayerService.moveCard(gameId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed);

        List<GameCard> newCardsOnBoard = singleplayerService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard, cardsOnBoard);
    }

    @Test
    public void shouldDrawCard() throws InvalidIDException{
        Integer gameId = 1;
        Singleplayer game = singleplayerService.findByID(gameId);

        assertEquals(game.getGameCards().stream().filter(c -> c.getStatus().ordinal()==2).toList().size(), 1);
        singleplayerService.drawCardsFromDeck(game);

        assertEquals(game.getGameCards().stream().filter(c -> c.getStatus().ordinal()==2).toList().size(), 0);
    }

}
