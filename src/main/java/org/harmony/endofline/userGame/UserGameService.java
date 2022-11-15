package org.harmony.endofline.userGame;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserGameService {

    private final UserGameRepository userGameRepository;

    public UserGameService(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }

    @Transactional
    public void save(UserGame userGame) {
        userGameRepository.save(userGame);
    }
}
