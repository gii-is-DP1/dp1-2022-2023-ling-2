package org.harmony.endofline.gameInvite;

import org.harmony.endofline.user.User;
import org.harmony.endofline.userGame.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GameInviteService {

    private final GameInviteRepository gameInviteRepository;

    @Autowired
    public GameInviteService(GameInviteRepository gameInviteRepository){
        this.gameInviteRepository = gameInviteRepository;
    }

    public void setAllPendingCanceled(Integer gameID){
        List<GameInvite> pendingInvites = this.gameInviteRepository.findAllInvitesOfGame(gameID);
        for (GameInvite invite: pendingInvites) {
            this.gameInviteRepository.update(invite.accepted,invite.pending, true, invite.getId());
        }
    }

    public void acceptInvite(Integer id){
        GameInvite invite = this.gameInviteRepository.findById(id).get();
        this.gameInviteRepository.update(true,false,false,invite.getId());
        if(invite.type == InviteType.PLAYER) {
            this.setAllPendingCanceled(invite.userGame.getId());
        }
    }

    public void declineInvite(Integer id){
        GameInvite invite = this.gameInviteRepository.findById(id).get();
        this.gameInviteRepository.update(false,false,false,invite.getId());
    }

    @Transactional
    public void sendInvite(UserGame userGame, User sender, User receiver, InviteType type){
        GameInvite newInvite = new GameInvite(userGame,sender,receiver,type);
        this.gameInviteRepository.save(newInvite);
    }

    public void findById(Integer id){
        this.gameInviteRepository.findById(id);
    }

}
