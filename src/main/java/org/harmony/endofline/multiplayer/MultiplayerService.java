package org.harmony.endofline.multiplayer;

import org.harmony.endofline.userGame.UserGame;
import org.harmony.endofline.userGame.UserGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
