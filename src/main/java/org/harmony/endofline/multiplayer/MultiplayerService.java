package org.harmony.endofline.multiplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MultiplayerService {

    @Autowired
    private MultiplayerRepository multiplayerRepository;

    @Transactional
    public void save(Multiplayer game) {
        multiplayerRepository.save(game);
    }
}
