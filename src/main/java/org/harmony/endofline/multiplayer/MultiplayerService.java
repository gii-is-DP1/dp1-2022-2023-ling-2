package org.harmony.endofline.multiplayer;

import org.harmony.endofline.model.GameStatus;
import org.harmony.endofline.user.User;
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

    @Transactional
    public void save(Multiplayer game) {
        multiplayerRepository.save(game);
    }

    @Transactional
    public void addUserGame(Multiplayer game, UserGame userGame) {
        game.addUser(userGame);
    }

    public Multiplayer findGame(Integer id){
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

    @Transactional
    public void advanceRound(Multiplayer game){
        User inactivePlayer = multiplayerRepository.getInactivePlayer(game.getId());
        game.setRound(game.getRound()+1);
        game.setActivePlayer(inactivePlayer);
    }

    public boolean energyAvailable(Multiplayer game, User user){
        return true;
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

    public Multiplayer getById(Integer id){
        return multiplayerRepository.findById(id).get();
    }
}
