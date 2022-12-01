package org.harmony.endofline.singleplayer;

import org.harmony.endofline.card.Side;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.gameCard.GameCardRepository;
import org.harmony.endofline.puzzle.PuzzleRepository;
import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SingleplayerService {

    @Autowired
    private SingleplayerRepository singleplayerRepository;
    @Autowired
    private PuzzleRepository puzzleRepository;
    @Autowired
    private GameCardRepository gameCardRepository;

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
        return singleplayerRepository.FindAllGameCardsInBoard(id);
    }
    public List<GameCard> getAllCardsInHand(Integer id){
        return singleplayerRepository.FindAllGameCardsInHand(id);
    }

    @Transactional
    public void moveCard(Integer id, List<GameCard> cardsOnBoard, Integer cardToMoveId, Integer rotation, Integer x, Integer y) throws InvalidIDException {
        List<Integer> futurePosition = List.of(x, y);
        List<List<Integer>> validPositions = new ArrayList<>();
        Singleplayer game = findByID(id);
        GameCard cardToMove = gameCardRepository.findById(cardToMoveId).orElse(null);
        if (cardToMove!=null && cardToMove.getInHand())
            validPositions = getValidPositions(game, cardsOnBoard, cardToMove, rotation);

        if (validPositions.contains(futurePosition)) {
            cardToMove.setX(x);
            cardToMove.setY(y);
            cardToMove.setInHand(false);
            game.setLastPlacedCard(cardToMove);
        }
    }

    private List<List<Integer>> getValidPositions(Singleplayer game, List<GameCard> cardsOnBoard, GameCard cardToMove, Integer rotation) throws InvalidIDException {
        GameCard lastCard = game.getLastPlacedCard();

        // TODO normalize board dimesions
        Map<String, List<Integer>> requiredEntryForExit = new HashMap<>();
        if (lastCard==null){
            requiredEntryForExit.put("down", List.of((5-1)/2, (5-1)/2-1));

        } else {
            requiredEntryForExit = lastCard.getExitPositions(5);
        }

        List<List<Integer>> lastCardExitPositions = requiredEntryForExit.values().stream().toList();
        List<PuzzleCards> puzzleCards = puzzleRepository.findCardsOfPuzzle(game.getPuzzle().getId());

        List<List<Integer>> occupiedPositions = cardsOnBoard.stream().map(c -> List.of(c.getX(), c.getY())).collect(Collectors.toList());
        occupiedPositions.addAll(puzzleCards.stream().map(c -> List.of(c.getX(), c.getY())).toList());

        List<List<Integer>> availablePositions = lastCardExitPositions.stream().filter(p -> !occupiedPositions.contains(p)).toList();

        List<Side> cardToMoveSides = cardToMove.getRotatedSides(rotation);

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
                        if (availablePositions.contains(requiredEntryForExit.get("up")))
                            res.add(requiredEntryForExit.get("up"));
                    }
                    case 1 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("right")))
                            res.add(requiredEntryForExit.get("right"));
                    }
                    case 2 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("down")))
                            res.add(requiredEntryForExit.get("down"));
                    }
                    case 3 -> {
                        if (availablePositions.contains(requiredEntryForExit.get("left")))
                            res.add(requiredEntryForExit.get("left"));
                    }
                }
            }
        }
        return res;
    }
}
