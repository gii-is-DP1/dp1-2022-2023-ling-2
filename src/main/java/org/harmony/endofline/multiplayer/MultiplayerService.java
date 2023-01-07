package org.harmony.endofline.multiplayer;

import org.harmony.endofline.card.Card;
import org.harmony.endofline.card.CardService;
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
    @Autowired
    private CardService cardService;

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
        return multiplayerRepository.findSearching().size() > 0 ? multiplayerRepository.findSearching().get(0) : null;
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

    private List<GameCard> getCardsByUserIdAndRound(Multiplayer game, Integer userId) {
        return gameCardRepository.findByUserIdAndRound(game.getId(), userId, game.getRound());
    }

    public GameCard getLastPlacedCard(Integer gameId, Integer userId){
        return gameCardRepository.findByUserId(gameId, userId).get(0);
    }

    public List<GameCard> getAllUserCardByGame(Integer gameId, Integer userId){
        return gameCardRepository.findByUserId(gameId, userId);
    }

    @Transactional
    public Multiplayer createNewGame(Boolean isPublic, User user){
        // no game in queue or not elegable
        Multiplayer game = new Multiplayer(isPublic);
        this.save(game);
        UserGame userGame = new UserGame(user, game, 1, PlayerType.PLAYER,3);
        userGameService.save(userGame);
        this.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);
        return game;
    }

    @Transactional
    public Multiplayer addUserToGameInQueue(Boolean isPublic, Multiplayer game, User user){
        //Game in Queue exists and is elegable
        UserGame userGame = new UserGame(user, game, 2, PlayerType.PLAYER,3);
        userGameService.save(userGame);
        this.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);
        return game;
    }

    public void addSpectator(User user, Multiplayer game){
        UserGame userGame = new UserGame(user, game, null, PlayerType.SPECTATOR,0);
        userGameService.save(userGame);
        this.addUserGame(game, userGame);
        userService.addUserGame(user, userGame);
    }

    @Transactional
    public void startGame(Integer id){
        Multiplayer game = multiplayerRepository.findById(id).get();
        game.setGameStatus(GameStatus.STARTED);
        game.setDateStarted(LocalDateTime.now());
        game.setActivePlayer(game.getUsers().stream().filter(ug -> ug.getPlayer()==1).map(ug -> ug.getUser()).findFirst().get());
        game.setRound(0);
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
        drawCardsFromDeck(game);
    }

    @Transactional
    public User getNextRoundFirstPlayer(Multiplayer game) {
        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        User playerTwo = game.getUsers().stream().filter(ug -> ug.getPlayer()==2).findFirst().orElse(null).getUser();
        List<GameCard> playerOneCards = getCardsByUserIdAndRound(game, playerOne.getId());
        List<GameCard> playerTwoCards = getCardsByUserIdAndRound(game, playerTwo.getId());

        List<Integer> gameCardsComparison = IntStream.range(0, Math.min(playerOneCards.size(), playerTwoCards.size()))
            .boxed()
            .map(i -> playerOneCards.get(i).getCard().getInitiative() < playerTwoCards.get(i).getCard().getInitiative() ? 1 :
                (playerOneCards.get(i).getCard().getInitiative() > playerTwoCards.get(i).getCard().getInitiative() ? 2 : 0))
            .toList();

        switch (gameCardsComparison.stream().filter(e -> e!=0).findFirst().orElse(0)){
            case 1: return playerOne;
            case 2: return playerTwo;
            default: return game.getActivePlayer();
        }
    }

    @Transactional
    public boolean isEnergyAvailable(Multiplayer game, Integer userId){
        List<GameCard> cardsPlacedOnRoundByUser = getCardsByUserIdAndRound(game, userId);
        return game.getRound() >= 3 && cardsPlacedOnRoundByUser.size() == 0 && game.getUsers().stream().filter(ug -> ug.getUser().getId().equals(userId)).findFirst().get().getEnergy() > 0;
    }

    @Transactional
    public boolean isTurnFinished(Multiplayer game, Integer userId) {
        var cardsPlacedOnRoundByUser = getCardsByUserIdAndRound(game, userId);
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
        var cardsPlacedOnRoundByUserOne = getCardsByUserIdAndRound(game, playerOne.getId());
        var cardsPlacedOnRoundByUserTwo = getCardsByUserIdAndRound(game, playerTwo.getId());
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
            case 1: abilityUsed = EnergyAbility.BACK_IN_TIME; break;
            case 2: abilityUsed = EnergyAbility.BOOST; break;
            case 3: abilityUsed = EnergyAbility.BREAK; break;
            default: abilityUsed = EnergyAbility.NONE; break;
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
            } else if (getCardsByUserIdAndRound(game, userId).size() == 1){
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
        GameCard lastCard = getLastPlacedCard(game.getId(), userId);
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
        // TODO normalize board dimensions
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

    @Transactional
    public void addInitialCards(Multiplayer game, List<Card> deckCards) {
        for(User user: game.getUsers().stream().filter(ug -> ug.getRole().equals(PlayerType.PLAYER)).map(ug -> ug.getUser()).toList()){
            game.getGameCards().addAll(
                deckCards.stream()
                .map(card -> gameCardRepository.save(new GameCard(card, user, Status.DECK, null, null, 0)))
                .collect(Collectors.toList()));
        }

        User playerOne = game.getUsers().stream().filter(ug -> ug.getPlayer()==1).findFirst().orElse(null).getUser();
        User playerTwo = game.getUsers().stream().filter(ug -> ug.getPlayer()==2).findFirst().orElse(null).getUser();
        game.gameCards.add(gameCardRepository.save(new GameCard(
            cardService.getInitialCard(),
            playerOne,
            Status.BOARD,
            2,
            3,
            0
        )));
        game.gameCards.add(gameCardRepository.save(new GameCard(
            cardService.getInitialCard(),
            playerTwo,
            Status.BOARD,
            4,
            3,
            0
        )));
    }

    @Transactional
    public void drawCardsFromDeck(Multiplayer game) {
        for(User user: game.getUsers().stream().filter(ug -> ug.getRole().equals(PlayerType.PLAYER)).map(ug -> ug.getUser()).toList()){
            Integer cardsInHand = game.getGameCards().stream().filter(c -> c.getStatus().equals(Status.HAND) && c.getUser().equals(user)).toList().size();
            Integer cardsInDeck = game.getGameCards().stream().filter(c -> c.getStatus().equals(Status.DECK) && c.getUser().equals(user)).toList().size();
            if(cardsInHand < 5 && cardsInDeck > 0){
                int cardsToDraw = 5 - cardsInHand;
                if(cardsInDeck < cardsToDraw)
                    cardsToDraw = cardsInDeck;
                Collections.shuffle(game.getGameCards());
                game.getGameCards().stream().filter(c -> c.getStatus().equals(Status.DECK) && c.getUser().equals(user)).limit(cardsToDraw).forEach(c -> c.setStatus(Status.HAND));
            }

        }
    }

    @Transactional
    public void setResultIfApplicable(Multiplayer game) {
        List<GameCard> cardsOnBoard = multiplayerRepository.findCardsInBoard(game.getId());
        if(cardsOnBoard.size() == 7*7){
            game.setGameStatus(GameStatus.FINISHED);
            game.setWinner(null);
            game.setDateEnded(LocalDateTime.now());
        } else { // Find which users have legal moves and determine the result from there
            List<User> usersWithMoves = new ArrayList<>();
            for(UserGame userGame: game.getUsers().stream().filter(ug -> ug.getRole().equals(PlayerType.PLAYER)).toList()){
                List<GameCard> userCardsOnBoard = gameCardRepository.findByUserId(game.getId(), userGame.getUser().getId());
                List<List<Integer>> availablePositions = null;
                Map<String, List<List<Integer>>> requiredEntriesForExit = calculateEntriesForExits(userCardsOnBoard, userGame.getEnergy()>0,
                    getLastPlacedCard(game.getId(), userGame.getUser().getId()));
                availablePositions = getAllAvailablePositions(game, cardsOnBoard, requiredEntriesForExit);
                if(availablePositions.size()!=0){
                    usersWithMoves.add(userGame.getUser());
                }
            }
            switch (usersWithMoves.size()){
                case 0 -> {
                    game.setGameStatus(GameStatus.FINISHED);
                    game.setDateEnded(LocalDateTime.now());
                    game.setWinner(null);
                }
                case 1 -> {
                    game.setGameStatus(GameStatus.FINISHED);
                    game.setDateEnded(LocalDateTime.now());
                    game.setWinner(usersWithMoves.get(0));
                }
                default -> {
                    ;
                }
            }
        }
    }
}
