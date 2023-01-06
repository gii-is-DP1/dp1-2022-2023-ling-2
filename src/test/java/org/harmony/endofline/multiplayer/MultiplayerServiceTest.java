package org.harmony.endofline.multiplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.singleplayer.InvalidIDException;
import org.harmony.endofline.user.User;
import org.harmony.endofline.userGame.EnergyAbility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class MultiplayerServiceTest {
    @Autowired
    protected MultiplayerService multiService;

    @Test
    void shouldFindAll(){
        Collection<Multiplayer> multiplayers =this.multiService.getAllGamesWithUser();
        assertThat(multiplayers).hasSize(5);
    }

    @Test
    void shouldAdvanceRoundSamePlayerActive(){
        Multiplayer game = this.multiService.getById(2);

        assertEquals(1, game.getRound());
        assertEquals(1, game.getActivePlayer().getId());

        this.multiService.advanceRound(game);

        assertEquals(2, game.getRound());
        assertEquals(1, game.getActivePlayer().getId());
    }

    @Test
    void shouldAdvanceRoundDifferentPlayerActive(){
        Multiplayer game = this.multiService.getById(4);

        assertEquals(3, game.getRound());
        assertEquals(2, game.getActivePlayer().getId());

        this.multiService.advanceRound(game);

        assertEquals(4, game.getRound());
        assertEquals(1, game.getActivePlayer().getId());
    }

    @Test
    void roundShouldBeFinished(){
        Multiplayer game = this.multiService.getById(4);
        assertEquals(true, multiService.isRoundFinished(game));
    }

    @Test
    void roundShouldNotBeFinished(){
        Multiplayer game = this.multiService.getById(1);
        assertEquals(false, multiService.isRoundFinished(game));
    }

    @Test
    void shouldPlaceFirstCardOfUser1NoEnergyNoTurnFinish() throws InvalidIDException {
        Integer userId = 1;
        Integer gameId = 2;
        Integer cardToMove = 16;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 2;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = multiService.getAllCardsInBoard(gameId);
        multiService.moveCard(gameId, userId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed, 0);

        List<GameCard> newCardsOnBoard = multiService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 3);
        assertEquals(newCardsOnBoard.get(2).getX(), 2);
        assertEquals(newCardsOnBoard.get(2).getY(), 2);

        Multiplayer game = this.multiService.getById(2);
        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        assertEquals(1, game.getRound());
        assertEquals(playerOne.getId(), game.getActivePlayer().getId());
    }

    @Test
    void shouldPlaceFirstCardOfUser2EnergyTurnFinish() throws InvalidIDException {
        Integer userId = 2;
        Integer gameId = 5;
        Integer cardToMove = 26;
        Integer rotation = 0;
        Integer x = 4;
        Integer y = 2;
        boolean energyUsed = true;
        List<GameCard> cardsOnBoard = multiService.getAllCardsInBoard(gameId);
        multiService.moveCard(gameId, userId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed, 3);

        // Even though we used the energy, its only turn 1 so it should not work
        List<GameCard> newCardsOnBoard = multiService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 4);

        Multiplayer game = this.multiService.getById(5);
        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        assertEquals(4, game.getRound());
        assertEquals(playerOne.getId(), game.getActivePlayer().getId());
        assertEquals(2, game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getEnergy());
    }

    @Test
    void shouldNotPlaceFirstCardOfUser1EnergyNoTurnFinish() throws InvalidIDException {
        Integer userId = 1;
        Integer gameId = 2;
        Integer cardToMove = 16;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 2;
        boolean energyUsed = true;
        List<GameCard> cardsOnBoard = multiService.getAllCardsInBoard(gameId);
        multiService.moveCard(gameId, userId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed, 3);

        // Even though we used the energy, its only turn 1 so it should not work
        List<GameCard> newCardsOnBoard = multiService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 2);

        Multiplayer game = this.multiService.getById(2);
        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        assertEquals(1, game.getRound());
        assertEquals(playerOne.getId(), game.getActivePlayer().getId());
        assertEquals(3, game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getEnergy());
    }

    @Test
    void shouldNotPlaceFirstCardOfUser1OnUser2Turn() throws InvalidIDException {
        Integer userId = 1;
        Integer gameId = 3;
        Integer cardToMove = 19;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 2;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = multiService.getAllCardsInBoard(gameId);
        multiService.moveCard(gameId, userId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed, 0);

        List<GameCard> newCardsOnBoard = multiService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 2);
    }

    @Test
    void shouldNotPlaceFirstCardOfUser1() throws InvalidIDException {
        Integer userId = 2;
        Integer gameId = 3;
        Integer cardToMove = 19;
        Integer rotation = 0;
        Integer x = 2;
        Integer y = 2;
        boolean energyUsed = false;
        List<GameCard> cardsOnBoard = multiService.getAllCardsInBoard(gameId);
        multiService.moveCard(gameId, userId, cardsOnBoard, cardToMove, rotation, x, y, energyUsed, 0);

        List<GameCard> newCardsOnBoard = multiService.getAllCardsInBoard(gameId);
        assertEquals(newCardsOnBoard.size(), 2);
    }



}
