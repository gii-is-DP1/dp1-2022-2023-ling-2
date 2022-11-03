package org.harmony.endofline.usersGames;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsersGamesService {

    private final UsersGamesRepository usersGamesRepository;

    public UsersGamesService(UsersGamesRepository usersGamesRepository) {
        this.usersGamesRepository = usersGamesRepository;
    }

    @Transactional
    public void save(UsersGames userGame) {
        usersGamesRepository.save(userGame);
    }
}
