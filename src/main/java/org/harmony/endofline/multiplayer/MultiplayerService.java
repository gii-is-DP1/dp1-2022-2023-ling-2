package org.harmony.endofline.multiplayer;

import org.harmony.endofline.user.User;
import org.harmony.endofline.userGame.UserGame;
import org.harmony.endofline.userGame.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return multiplayerRepository.findSearching().get(0);
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



}
