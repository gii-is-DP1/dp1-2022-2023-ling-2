package org.harmony.endofline.singleplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SingleplayerService {

    @Autowired
    private SingleplayerRepository singleplayerRepository;

    @Transactional
    public void save(Singleplayer game) {
        singleplayerRepository.save(game);
    }
}
