package org.harmony.endofline.gameInvite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GameInviteService {
    @Autowired
    private GameInviteRepository gameInviteRepository;

    @Transactional
    public void sendGameInvite(GameInvite gameInvite){
        //if(gameInvite.getRecipient().isFriendOf(gameInvite.getSender())){
            this.gameInviteRepository.save(gameInvite);
        //}

    }

    @Transactional
    public void deleteGameInvite(GameInvite gameInvite){
        this.gameInviteRepository.delete(gameInvite);
    }
}
