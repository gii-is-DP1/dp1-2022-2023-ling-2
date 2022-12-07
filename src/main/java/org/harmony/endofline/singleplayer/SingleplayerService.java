package org.harmony.endofline.singleplayer;

import org.harmony.endofline.card.Card;
import org.harmony.endofline.card.Side;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.gameCard.GameCardRepository;
import org.harmony.endofline.gameCard.Status;
import org.harmony.endofline.puzzle.PuzzleRepository;
import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SingleplayerService {

    @Autowired
    private SingleplayerRepository singleplayerRepository;
    @Autowired
    private PuzzleRepository puzzleRepository;
    @Autowired
    private GameCardRepository gameCardRepository;
    private Random random = new Random();

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

    public boolean isGameFromUser(Integer gameId, User user){
        return singleplayerRepository.FindUserSingleplayerGame(user, gameId).size()>0;
    }

    public void addInitialCards(Singleplayer game, List<Card> deckCards) {
        deckCards.stream()
            .map(card -> new GameCard(card, game.getUser(), game.getId(), false, Status.DECK, null, null, 0))
            .forEach(gameCard -> gameCardRepository.save(gameCard));
    }

    public void addCardToGame(Singleplayer game, GameCard gameCard) {
        gameCardRepository.save(gameCard);
    }

    public List<GameCard> getAllCardsInBoard(Integer id){
        return singleplayerRepository.findCardsInBoard(id);
    }
    public List<GameCard> getAllCardsInHand(Integer id){
        return singleplayerRepository.findCardsInHand(id);
    }

    @Transactional
    public void moveCard(Integer id, List<GameCard> cardsOnBoard, Integer cardToMoveId, Integer rotation, Integer x, Integer y, boolean energyUsed) throws InvalidIDException {
        List<Integer> futurePosition = List.of(x, y);
        List<List<Integer>> validPositions = new ArrayList<>();
        Singleplayer game = findByID(id);
        GameCard cardToMove = gameCardRepository.findById(cardToMoveId).orElse(null);
        if (cardToMove!=null && cardToMove.getStatus().equals(Status.HAND) && (!energyUsed || !game.getEnergy().equals(0)))
            validPositions = getValidPositions(game, cardsOnBoard, cardToMove, rotation, energyUsed);

        if (validPositions.contains(futurePosition)) {
            cardToMove.setX(x);
            cardToMove.setY(y);
            cardToMove.setRotation(rotation);
            cardToMove.setStatus(Status.BOARD);
            game.setLastPlacedCard(cardToMove);
            if(energyUsed && !game.getEnergy().equals(0))
                game.setEnergy(game.getEnergy()-1);
        }
    }

    private List<List<Integer>> getValidPositions(Singleplayer game, List<GameCard> cardsOnBoard, GameCard cardToMove, Integer rotation, Boolean energyUsed) throws InvalidIDException {
        GameCard lastCard = game.getLastPlacedCard();

        var requiredEntriesForExit = calculateEntriesForExits(cardsOnBoard, energyUsed, lastCard);

        List<List<Integer>> exitPositions = requiredEntriesForExit.values().stream().flatMap(list -> list.stream()).toList();
        List<PuzzleCards> puzzleCards = puzzleRepository.findCardsOfPuzzle(game.getPuzzle().getId());

        List<List<Integer>> occupiedPositions = cardsOnBoard.stream().map(c -> List.of(c.getX(), c.getY())).collect(Collectors.toList());
        occupiedPositions.addAll(puzzleCards.stream().map(c -> List.of(c.getX(), c.getY())).toList());

        List<List<Integer>> availablePositions = exitPositions.stream().filter(p -> !occupiedPositions.contains(p)).toList();

        List<Side> cardToMoveSides = cardToMove.getRotatedSides(rotation);

        List<List<Integer>> validPositions = cleanAvailablePositionsUsingCardToMove(requiredEntriesForExit, availablePositions, cardToMoveSides);

        return validPositions;
}

    private static Map<String, List<List<Integer>>> calculateEntriesForExits(List<GameCard> cardsOnBoard, Boolean energyUsed, GameCard lastCard) {
        // TODO normalize board dimesions
        Map<String, List<List<Integer>>> requiredEntriesForExit = new HashMap<>();

        if (lastCard ==null){
            requiredEntriesForExit.put("down", List.of(List.of((5-1)/2, (5-1)/2-1)));
        } else {
            if(!energyUsed) {
                Map<String, List<Integer>> cardEntryForExitMap = lastCard.getExitPositions(5);
                for(Map.Entry<String, List<Integer>> item: cardEntryForExitMap.entrySet()){
                    requiredEntriesForExit.put(item.getKey(), List.of(item.getValue()));
                }
            }
            else{
                for(GameCard card: cardsOnBoard){
                    Map<String, List<Integer>> cardEntryForExitMap = card.getExitPositions(5);
                    for(Map.Entry<String, List<Integer>> item: cardEntryForExitMap.entrySet()){
                           if(requiredEntriesForExit.containsKey(item.getKey()))
                               requiredEntriesForExit.get(item.getKey()).add(item.getValue());
                           else {
                               List<List<Integer>> value = new ArrayList<>();
                               value.add(item.getValue());
                               requiredEntriesForExit.put(item.getKey(), value);
                           }
                    }
                }
            }
        }
        return requiredEntriesForExit;
    }

    private static List<List<Integer>> cleanAvailablePositionsUsingCardToMove(Map<String, List<List<Integer>>> requiredEntriesForExit, List<List<Integer>> availablePositions, List<Side> cardToMoveSides) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i< cardToMoveSides.size(); i++){
            Side side = cardToMoveSides.get(i);
            if(side.equals(Side.ENTRY)){
                switch (i){
                    case 0 -> {
                        for(List<Integer> position: requiredEntriesForExit.getOrDefault("up", new ArrayList<>())){
                            boolean validPosition = availablePositions.contains(position);
                            if(validPosition)
                                res.add(position);
                        }
                    }
                    case 1 -> {
                        for(List<Integer> position: requiredEntriesForExit.getOrDefault("right", new ArrayList<>())){
                            boolean validPosition = availablePositions.contains(position);
                            if(validPosition)
                                res.add(position);
                        }
                    }
                    case 2 -> {
                        for(List<Integer> position: requiredEntriesForExit.getOrDefault("down", new ArrayList<>())){
                            boolean validPosition = availablePositions.contains(position);
                            if(validPosition)
                                res.add(position);
                        }
                    }
                    case 3 -> {
                        for(List<Integer> position: requiredEntriesForExit.getOrDefault("left", new ArrayList<>())){
                            boolean validPosition = availablePositions.contains(position);
                            if(validPosition)
                                res.add(position);
                        }
                    }
                }
            }
        }
        return res;
    }

    public void drawCardsFromDeck(Singleplayer game) {
        List<GameCard> cardsInHand = singleplayerRepository.findCardsInHand(game.getId());
        List<GameCard> cardsInDeck = singleplayerRepository.findCardsInDeck(game.getId());
        if(cardsInHand.size() < 5 && cardsInDeck.size() > 0){
            int cardsToDraw = 5 - cardsInHand.size();
            if(cardsInDeck.size() < cardsToDraw)
                cardsToDraw = cardsInDeck.size();
            IntStream.range(0, cardsToDraw).forEach(i -> {
                cardsInDeck.get(random.nextInt(cardsInDeck.size())).setStatus(Status.HAND);
            });
        }
    }
}
