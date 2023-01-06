package org.harmony.endofline.multiplayer;

import org.harmony.endofline.card.Side;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.gameCard.GameCardRepository;
import org.harmony.endofline.gameCard.Status;
import org.harmony.endofline.model.GameStatus;
import org.harmony.endofline.singleplayer.InvalidIDException;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.harmony.endofline.userGame.*;
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
    private GameCardRepository gameCardRepository;
    @Autowired
    private UserGameService userGameService;
    @Autowired
    private UserService userService;

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
    public boolean isEnergyAvailable(Multiplayer game, Integer userId){
        List<GameCard> cardsPlacedOnRoundByUser = gameCardRepository.findByUserIdAndRound(game.getId(), userId, game.getRound());
        return game.getRound() >= 3 && cardsPlacedOnRoundByUser.size() == 0 && game.getUsers().stream().filter(ug -> ug.getUser().getId().equals(userId)).findFirst().get().getEnergy() > 0;
    }

    @Transactional
    public boolean isTurnFinished(Multiplayer game, Integer userId) {
        var cardsPlacedOnRoundByUser = gameCardRepository.findByUserIdAndRound(game.getId(), userId, game.getRound());
        switch (game.getUsers().stream().filter(ug -> ug.getUser().getId().equals(userId)).findFirst().get().getAbilityUsed()) {
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
    public boolean isRoundFinished(Multiplayer game){
        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        User playerTwo = game.getUsers().stream().filter(ug -> ug.getPlayer()==2).findFirst().orElse(null).getUser();
        var cardsPlacedOnRoundByUserOne = gameCardRepository.findByUserIdAndRound(game.getId(), playerOne.getId(), game.getRound());
        var cardsPlacedOnRoundByUserTwo = gameCardRepository.findByUserIdAndRound(game.getId(), playerTwo.getId(), game.getRound());
        return cardsPlacedOnRoundByUserOne.size() > 0 && cardsPlacedOnRoundByUserTwo.size() > 0;
    }

    private boolean isUserTurn(Multiplayer game, Integer userId) {
        return game.getActivePlayer().getId().equals(userId);
    }


    @Transactional
    public void moveCard(Integer gameId, Integer userId, List<GameCard> cardsOnBoard, Integer cardToMoveId, Integer rotation, Integer x, Integer y, boolean energyUsed, Integer abilityUsedOrdinal) throws InvalidIDException {
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

        // Can't move a null card, card needs to be in hand, energy has to be available or not used and it's the user's turn
        if (cardToMove!=null && cardToMove.getStatus().equals(Status.HAND) && (!energyUsed || isEnergyAvailable(game, userId)) && isUserTurn(game, userId))
            validPositions = getValidPositions(game, userId, cardsOnBoard, cardToMove, rotation, abilityUsed.equals(EnergyAbility.BACK_IN_TIME));

        if (validPositions.contains(futurePosition)) {
            cardToMove.setX(x);
            cardToMove.setY(y);
            cardToMove.setRotation(rotation);
            cardToMove.setStatus(Status.BOARD);
            cardToMove.setRound(game.getRound());
            if(energyUsed && isEnergyAvailable(game, userId)) {
                game.getUsers().stream().filter(ug -> ug.getUser().getId().equals(userId)).findFirst().get().reduceEnergy();
                game.getUsers().stream().filter(ug -> ug.getUser().getId().equals(userId)).findFirst().get().setAbilityUsed(abilityUsed);
            }

            // Turn and round advancement
            if (isTurnFinished(game, userId)) {
                if (isRoundFinished(game))
                    advanceRound(game);
                else
                    finishTurn(game);
            }
        }
    }

    private List<List<Integer>> getValidPositions(Multiplayer game, Integer userId, List<GameCard> cardsOnBoard, GameCard cardToMove, Integer rotation, Boolean backInTime) {
        GameCard lastCard = gameCardRepository.findByUserId(game.getId(), userId).get(0);
        List<GameCard> userCardsOnBoard = cardsOnBoard.stream().filter(c -> c.getUser().getId().equals(userId)).toList();

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

    public Multiplayer addPlayer1(Boolean isPublic, User user){
        // no game in queue or not elegable
        Multiplayer game = new Multiplayer(isPublic);
        this.save(game);
        UserGame userGame = new UserGame(user, game, 1, PlayerType.PLAYER,3);
        userGameService.save(userGame);
        this.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);
        return game;
    }

    public Multiplayer addPlayer2(Boolean isPublic, User user, Multiplayer game){
        //Game in Queue exists and is elegable
        UserGame userGame = new UserGame(user, game, 2, PlayerType.PLAYER,3);
        userGameService.save(userGame);
        this.startGame(game.getId());
        return game;
    }
}
