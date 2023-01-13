package org.harmony.endofline.gameInvite;

import org.harmony.endofline.deck.DeckService;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameInviteService {

    private final GameInviteRepository gameInviteRepository;

    @Autowired
    public GameInviteService(GameInviteRepository gameInviteRepository){
        this.gameInviteRepository = gameInviteRepository;
    }

    public GameInvite findById(Integer id){
        return gameInviteRepository.findById(id).orElse(null);
    }

    @Transactional
    public void setAllPendingCanceled(Integer gameID){
        List<GameInvite> pendingInvites = gameInviteRepository.findAllInvitesOfGame(gameID);
        for (GameInvite invite: pendingInvites.stream().filter(i -> i.type.equals(InviteType.PLAYER)).toList()) {
            deleteInvite(invite);
        }
    }

    @Transactional
    public void deleteAllGameInvitesToReceiver(User receiver, Integer gameId) {
        List<GameInvite> pendingInvites = gameInviteRepository.findByRecieverAndGame(receiver.getId(), gameId);
        for (GameInvite invite: pendingInvites.stream().filter(i -> i.type.equals(InviteType.PLAYER)).toList()) {
            deleteInvite(invite);
        }
    }

    @Transactional
    public void acceptInvite(GameInvite invite){
        invite.setStatus(GameInvite.GameInviteStatus.ACCEPTED);
    }

    @Transactional
    public void declineInvite(GameInvite invite){
        invite.setStatus(GameInvite.GameInviteStatus.REJECTED);
    }

    @Transactional
    public void deleteInvite(GameInvite invite){
        gameInviteRepository.deleteById(invite.getId());
    }


    @Transactional
    public GameInvite sendInvite(Multiplayer game, User sender, User receiver, InviteType type){
        GameInvite newInvite = new GameInvite(game,sender,receiver,type);
        return this.gameInviteRepository.save(newInvite);
    }

    public List<GameInvite> getByReciever(User user){
        return this.gameInviteRepository.findByReciever(user.getId());
    }

    public List<GameInvite> getBySender(User user){
        return this.gameInviteRepository.findBySender(user.getId());
    }

    public Multiplayer getGameByInviteId(Integer id){
        return this.gameInviteRepository.findGameByInviteId(id);
    }

    public List<User> getFriendsNotInvited(User user, Integer gameId) {
        List<User> friendsInvited = gameInviteRepository.findFriendsInvited(user.getId(), gameId);
        List<User> friends = user.getFriends().stream().collect(Collectors.toList());

        friends.removeAll(friendsInvited);
        return friends;
    }

    public List<GameInvite> getPendingInvitesBySenderAndGame(User user, Integer gameId) {
        return gameInviteRepository.findBySenderAndGame(user.getId(), gameId);
    }

    public boolean isSenderOfRequest(User user, GameInvite invite) {
        return invite.getSender().equals(user);
    }

    public boolean isReceiverOfRequest(User user, GameInvite invite) {
        return invite.getReceiver().equals(user);
    }

}
