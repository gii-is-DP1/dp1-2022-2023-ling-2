package org.harmony.endofline.multiplayer;

import org.harmony.endofline.usersGames.UsersGames;
import org.harmony.endofline.usersGames.UsersGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MultiplayerService {

    @Autowired
    private MultiplayerRepository multiplayerRepository;

    @Autowired
    private UsersGamesRepository usersGamesRepository;

    @Transactional
    public void save(Multiplayer game) {
        multiplayerRepository.save(game);
    }

    @Transactional
    public void addUserGame(Multiplayer game, UsersGames userGame) {
        game.addUser(userGame);
    }
}
