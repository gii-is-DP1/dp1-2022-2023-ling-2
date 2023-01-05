package org.harmony.endofline.multiplayer;

import org.harmony.endofline.card.Side;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.gameCard.GameCardRepository;
import org.harmony.endofline.gameCard.Status;
import org.harmony.endofline.model.GameStatus;
import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.harmony.endofline.singleplayer.InvalidIDException;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.user.User;
import org.harmony.endofline.userGame.EnergyAbility;
import org.harmony.endofline.userGame.UserGame;
import org.harmony.endofline.userGame.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MultiplayerService {

    @Autowired
    private MultiplayerRepository multiplayerRepository;

    @Autowired
    private UserGameRepository usersGamesRepository;

    @Autowired
    private GameCardRepository gameCardRepository;

    @Transactional
    public void save(Multiplayer game) {
        multiplayerRepository.save(game);
    }

    @Transactional
    public void addUserGame(Multiplayer game, UserGame userGame) {
        game.addUser(userGame);
    }

    public Multiplayer getById(Integer id){
        return multiplayerRepository.findById(id).orElse(null);
    }

    public List<Multiplayer> getAllGamesWithUser() {
        return (List<Multiplayer>) multiplayerRepository.findAll();
    }

    public Multiplayer getNextGameInQueue(){
        if(multiplayerRepository.findSearching().size() > 0) {
            return multiplayerRepository.findSearching().get(0);
        }else{
            return null;
        }
    }
    public List<Multiplayer> getAllGameInQueue(){
        return multiplayerRepository.findSearching();
    }

    public Boolean checkGameReady(Integer id){
        Multiplayer game = multiplayerRepository.findById(id).get();
        if(game.getUsers().size() == 2) {
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public void startGame(Integer id){
        Multiplayer game = multiplayerRepository.findById(id).get();
        game.setGameStatus(GameStatus.STARTED);
        game.setDateStarted(LocalDateTime.now());
        multiplayerRepository.save(game);
    }

    @Transactional
    public void finishTurn(Multiplayer game){
        User inactivePlayer = multiplayerRepository.getInactivePlayer(game.getId());
        game.setActivePlayer(inactivePlayer);
    }

    @Transactional
    public void advanceRound(Multiplayer game){
        User nextPlayer = getNextRoundFirstPlayer(game);
        game.setRound(game.getRound()+1);
        game.setActivePlayer(nextPlayer);
    }

    @Transactional
    public User getNextRoundFirstPlayer(Multiplayer game) {
        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        User playerTwo = game.getUsers().stream().filter(ug -> ug.getPlayer()==2).findFirst().orElse(null).getUser();
        List<GameCard> playerOneCards = gameCardRepository.findByUserId(game.getId(), playerOne.getId());
        List<GameCard> playerTwoCards = gameCardRepository.findByUserId(game.getId(), playerTwo.getId());

        List<Integer> gameCardsComparison = IntStream.range(0, Math.min(playerOneCards.size(), playerTwoCards.size()))
            .boxed()
            .map(i -> playerOneCards.get(i).getCard().getInitiative() < playerOneCards.get(i).getCard().getInitiative() ? 1 :
                (playerOneCards.get(i).getCard().getInitiative() > playerOneCards.get(i).getCard().getInitiative() ? 2 : 0))
            .toList();

        switch (gameCardsComparison.stream().filter(e -> e!=0).findFirst().orElse(0)){
            case 1: return playerOne;
            case 2: return playerTwo;
            default: return game.getActivePlayer();
        }
    }

    @Transactional
    public boolean isEnergyAvailable(Multiplayer game, User user){
        List<GameCard> cardsPlacedOnRoundByUser = gameCardRepository.findByUserIdAndRound(game.getId(), user.getId(), game.getRound());
        return game.getRound() >= 3 && cardsPlacedOnRoundByUser.size() == 0 && game.getUsers().stream().filter(ug -> ug.getUser().equals(user)).findFirst().get().getEnergy() > 0;
    }

    @Transactional
    public boolean isTurnFinished(Multiplayer game, User user) {
        var cardsPlacedOnRoundByUser = gameCardRepository.findByUserIdAndRound(game.getId(), user.getId(), game.getRound());
        switch (game.getUsers().stream().filter(ug -> ug.getUser().getId().equals(user.getId())).findFirst().get().getAbilityUsed()) {
            case BOOST -> {
                return cardsPlacedOnRoundByUser.size() >= 3;
            }
            case BREAK -> {
                return cardsPlacedOnRoundByUser.size() >= 1;
            }
            default -> {
                return cardsPlacedOnRoundByUser.size() >= 2;
            }
        }
    }


    @Transactional
    public void moveCard(Integer gameId, User user, List<GameCard> cardsOnBoard, Integer cardToMoveId, Integer rotation, Integer x, Integer y, boolean energyUsed, Integer abilityUsedOrdinal) throws InvalidIDException {
        List<Integer> futurePosition = List.of(x, y);
        List<List<Integer>> validPositions = new ArrayList<>();
        Multiplayer game = getById(gameId);
        GameCard cardToMove = gameCardRepository.findById(cardToMoveId).orElse(null);

        EnergyAbility abilityUsed = null;
        switch (abilityUsedOrdinal){
            case 1: abilityUsed = EnergyAbility.BACK_IN_TIME;
            case 2: abilityUsed = EnergyAbility.BOOST;
            case 3: abilityUsed = EnergyAbility.BREAK;
            default: abilityUsed = EnergyAbility.NONE;
        }

        if (cardToMove!=null && cardToMove.getStatus().equals(Status.HAND) && (!energyUsed || isEnergyAvailable(game, user)))
            validPositions = getValidPositions(game, user, cardsOnBoard, cardToMove, rotation, abilityUsed.equals(EnergyAbility.BACK_IN_TIME));

        if (validPositions.contains(futurePosition)) {
            cardToMove.setX(x);
            cardToMove.setY(y);
            cardToMove.setRotation(rotation);
            cardToMove.setStatus(Status.BOARD);
            if(energyUsed && isEnergyAvailable(game, user))
                game.getUsers().stream().filter(ug -> ug.getUser().equals(user)).findFirst().get().reduceEnergy();
                game.getUsers().stream().filter(ug -> ug.getUser().equals(user)).findFirst().get().setAbilityUsed(abilityUsed );
        }
    }

    private List<List<Integer>> getValidPositions(Multiplayer game, User user, List<GameCard> cardsOnBoard, GameCard cardToMove, Integer rotation, Boolean backInTime) {
        GameCard lastCard = gameCardRepository.findByUserId(user.getId(), game.getId()).get(0);
        List<GameCard> userCardsOnBoard = cardsOnBoard.stream().filter(c -> c.getUser().equals(user)).toList();

        var requiredEntriesForExit = calculateEntriesForExits(userCardsOnBoard, backInTime, lastCard);

        List<List<Integer>> availablePositions = getAllAvailablePositions(game, cardsOnBoard, requiredEntriesForExit);

        List<Side> cardToMoveSides = cardToMove.getRotatedSides(rotation);

        List<List<Integer>> validPositions = cleanAvailablePositionsUsingCardToMove(requiredEntriesForExit, availablePositions, cardToMoveSides);

        return validPositions;
    }

    private List<List<Integer>> getAllAvailablePositions(Multiplayer game, List<GameCard> cardsOnBoard, Map<String, List<List<Integer>>> requiredEntriesForExit){

        List<List<Integer>> exitPositions = requiredEntriesForExit.values().stream().flatMap(list -> list.stream()).toList();

        List<List<Integer>> occupiedPositions = cardsOnBoard.stream().map(c -> List.of(c.getX(), c.getY())).collect(Collectors.toList());

        List<List<Integer>> availablePositions = exitPositions.stream().filter(p -> !occupiedPositions.contains(p)).toList();

        return availablePositions;
    }

    private static Map<String, List<List<Integer>>> calculateEntriesForExits(List<GameCard> userCardsOnBoard, Boolean backInTime, GameCard lastCard) {
        // TODO normalize board dimesions
        Map<String, List<List<Integer>>> requiredEntriesForExit = new HashMap<>();

        if (lastCard ==null){
            requiredEntriesForExit.put("down", List.of(List.of((5-1)/2, (5-1)/2-1)));
        } else {
            if(!backInTime) {
                Map<String, List<Integer>> cardEntryForExitMap = lastCard.getExitPositions(5);
                for(Map.Entry<String, List<Integer>> item: cardEntryForExitMap.entrySet()){
                    requiredEntriesForExit.put(item.getKey(), List.of(item.getValue()));
                }
            }
            else{
                for(GameCard card: userCardsOnBoard){
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

    public boolean checkUserInGame(User user, Multiplayer game) {
        return game.getUsers().stream().map(UserGame::getUser).anyMatch(u -> u.equals(user));
    }

    public List<GameCard> getAllCardsInBoard(Integer gameId) {
        return multiplayerRepository.findCardsInBoard(gameId);
    }

    public List<GameCard> getAllCardsInHand(Integer gameId, Integer userId) {
        return multiplayerRepository.findCardsInHand(gameId, userId);
    }

    public List<GameCard> getAllCardsInDeck(Integer gameId, Integer userId) {
        return multiplayerRepository.findCardsInDeck(gameId, userId);
    }
}
