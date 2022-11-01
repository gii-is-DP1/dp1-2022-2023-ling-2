package org.harmony.endofline.singleplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleplayerService {

    @Autowired
    private SingleplayerRepository singleplayerRepository;

    public void save(Singleplayer game) {
        singleplayerRepository.save(game);
    }
}
