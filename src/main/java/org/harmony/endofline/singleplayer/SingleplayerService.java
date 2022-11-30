package org.harmony.endofline.singleplayer;

import org.harmony.endofline.card.Side;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.puzzle.PuzzleRepository;
import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SingleplayerService {

    @Autowired
    private SingleplayerRepository singleplayerRepository;
    @Autowired
    private PuzzleRepository puzzleRepository;

    @Transactional
    public void save(Singleplayer game) {
        singleplayerRepository.save(game);
    }

    public List<Singleplayer> getAllGamesWithUser() {
        return singleplayerRepository.findAll();
    }

    public Singleplayer findByID(Integer id) throws InvalidIDException {
        Optional<Singleplayer> opt =  singleplayerRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }else{
            throw new InvalidIDException();
        }
    }

    public List<GameCard> getAllCardsInBoard(Integer id){
        return singleplayerRepository.FindAllGameCards(id).stream().filter(c -> !c.getInHand()).toList();
    }
    public List<GameCard> getAllCardsInHand(Integer id){
        var a = singleplayerRepository.FindAllGameCards(id).stream().filter(c -> c.getInHand()).toList();
        return a;
    }

    @Transactional
    public void moveCard(Integer id, List<GameCard> cards, GameCard cardToMove, Integer x, Integer y) throws InvalidIDException {
        List<Integer> futurePosition = List.of(x, y);
        List<List<Integer>> validPositions = getValidPositions(id, cards, cardToMove);

        if (validPositions.contains(futurePosition)) {
            cardToMove.setX(x);
            cardToMove.setY(y);
            cardToMove.setInHand(false);
        }
    }

    private List<List<Integer>> getValidPositions(Integer id, List<GameCard> cards, GameCard cardToMove) throws InvalidIDException {
        Singleplayer game = findByID(id);
        // TODO GameCard lastCard = game.getLastPlacedCard()
        GameCard lastCard = null;

        // TODO normalize board dimesions
        Map<String, List<Integer>> requiredEntryForExit = lastCard.getExitPositions(5);

        List<List<Integer>> lastCardExitPositions = (List<List<Integer>>) requiredEntryForExit.values();
        List<PuzzleCards> puzzleCards = puzzleRepository.findCardsOfPuzzle(game.getPuzzle().getId());

        List<List<Integer>> occupiedPositions = cards.stream().map(c -> List.of(c.getX(), c.getY())).toList();
        occupiedPositions.addAll(puzzleCards.stream().map(c -> List.of(c.getX(), c.getY())).toList());

        List<List<Integer>> availablePositions = lastCardExitPositions.stream().filter(p -> !occupiedPositions.contains(p)).toList();

        List<Side> cardToMoveSides = cardToMove.getRotatedSides();

        List<List<Integer>> validPositions = cleanAvailablePositionsUsingCardToMove(requiredEntryForExit, availablePositions, cardToMoveSides);

        return validPositions;
    }

    private static List<List<Integer>> cleanAvailablePositionsUsingCardToMove(Map<String, List<Integer>> requiredEntryForExit, List<List<Integer>> availablePositions, List<Side> cardToMoveSides) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i< cardToMoveSides.size(); i++){
            Side side = cardToMoveSides.get(i);
            if(side.equals(Side.ENTRY)){
                switch (i){
                    case 0 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("down")))
                            res.add(requiredEntryForExit.get("down"));
                    }
                    case 1 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("left")))
                            res.add(requiredEntryForExit.get("left"));
                    }
                    case 2 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("up")))
                            res.add(requiredEntryForExit.get("up"));
                    }
                    case 3 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("right")))
                            res.add(requiredEntryForExit.get("right"));
                    }
                }
            }
        }
        return res;
    }
}
