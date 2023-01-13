package org.harmony.endofline.gameInvite;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class GameInviteServiceTest {

    @Autowired
    GameInviteService gameInviteService;

    @Autowired
    UserService userService;

    @Autowired
    MultiplayerService multiplayerService;



    @Test
    void testFindById(){
        GameInvite invite = gameInviteService.findById(1);

        assertEquals(invite.getId(), 1);
        assertEquals(invite.getReceiver(), userService.findByUsername("admin"));
        assertEquals(invite.getSender(), userService.findByUsername("user"));
        assertEquals(invite.status, GameInvite.GameInviteStatus.PENDING);

    }
    @Test
    void testGetByReciever(){
        GameInvite invite = gameInviteService.findById(1);
        User user1 = userService.findByUsername("admin");

        List<GameInvite> invites = gameInviteService.getByReciever(user1);
        assertEquals(2, invites.size());
        assertEquals(gameInviteService.findById(1),invites.get(0));
        assertEquals(gameInviteService.findById(2),invites.get(1));

    }
    @Test
    void testGetBySender(){
        GameInvite invite = gameInviteService.findById(1);
        User user1 = userService.findByUsername("user");

        List<GameInvite> invites = gameInviteService.getBySender(user1);
        assertEquals(1, invites.size());
        assertEquals(gameInviteService.findById(1),invites.get(0));

    }

    @Test
    void getGameByInviteId(){
        Multiplayer game = gameInviteService.getGameByInviteId(1);
        assertEquals(4, game.getId());

    }

    @Test
    void testGetFriendsNotInvited(){
        User user = userService.getUser("user").get();

        List<User> notInvited = gameInviteService.getFriendsNotInvited(user, 4);

        assertEquals(2,notInvited.size());
        Assert.assertTrue(notInvited.get(0).getId() == 5 ||notInvited.get(0).getId() == 4 );
        Assert.assertTrue(notInvited.get(1).getId() == 5 ||notInvited.get(1).getId() == 4 );
        Assert.assertTrue(notInvited.get(0).getId() != notInvited.get(1).getId());


    }

    @Test
    void testGetPendingInvitesBySenderAndGame(){
        User user1 = userService.findByUsername("user");
        User user2 = userService.findByUsername("user2");
        User user3 = userService.findByUsername("user3");

        List<GameInvite> invites = gameInviteService.getPendingInvitesBySenderAndGame(user1,3);
        assertEquals(0,invites.size());

        gameInviteService.sendInvite(multiplayerService.getById(3),user1 ,user2,InviteType.PLAYER);

        List<GameInvite> invites2 = gameInviteService.getPendingInvitesBySenderAndGame(user1,3);
        assertEquals(1,invites2.size());
        assertEquals(4,invites2.get(0).getReceiver().getId());

    }

    @Test
    void testIsSenderOfRequest(){
        GameInvite invite1 = gameInviteService.findById(1);
        User user2 = userService.getUser("user").get();
        User user3 = userService.getUser("spectator").get();
        GameInvite invite2 = gameInviteService.findById(2);

        assertEquals(true, gameInviteService.isSenderOfRequest(user2,invite1));
        assertEquals(true, gameInviteService.isSenderOfRequest(user3,invite2));
        assertEquals(false,gameInviteService.isSenderOfRequest(user2,invite2));

        GameInvite invite3 = gameInviteService.sendInvite(multiplayerService.getById(2),userService.getUser("user2").get(),userService.getUser("user3").get(),InviteType.PLAYER);

        assertEquals(true, gameInviteService.isSenderOfRequest(userService.getUser("user2").get(),invite3));
    }

    @Test
    void testIsReceiverOfRequest(){
        GameInvite invite1 = gameInviteService.findById(1);
        User admin = userService.getUser("admin").get();
        User user2 = userService.getUser("user2").get();
        GameInvite invite2 = gameInviteService.findById(2);

        assertEquals(true, gameInviteService.isReceiverOfRequest(admin,invite1));
        assertEquals(true, gameInviteService.isReceiverOfRequest(admin,invite2));
        assertEquals(false,gameInviteService.isReceiverOfRequest(user2,invite2));

    }

    @Test
    void testCreateInvite(){
        Multiplayer game = new Multiplayer(false);
        multiplayerService.save(game);
        User user1 = userService.findByUsername("admin");
        User user2 = userService.findByUsername("user");

        GameInvite newInvite = gameInviteService.sendInvite(game, user1, user2, InviteType.PLAYER);
        assertEquals(user1.getId(), newInvite.getSender().getId());
        assertEquals(user2.getId(), newInvite.getReceiver().getId());
        assertEquals(InviteType.PLAYER, newInvite.getType());
        assertEquals(newInvite.status, GameInvite.GameInviteStatus.PENDING);

    }


    @Test
    void testAcceptInvite(){

        GameInvite invite = gameInviteService.findById(1);
        assertEquals(invite.getId(), 1);

        gameInviteService.acceptInvite(invite);
        GameInvite updatedInvite = gameInviteService.findById(1);

        assertEquals(GameInvite.GameInviteStatus.ACCEPTED,updatedInvite.status);

    }

    @Test
    void testDeclineInvite(){
        GameInvite invite = gameInviteService.findById(2);
        assertEquals(invite.getId(), 2);

        gameInviteService.declineInvite(invite);
        GameInvite updatedInvite = gameInviteService.findById(2);

        assertEquals(GameInvite.GameInviteStatus.REJECTED,updatedInvite.status);
    }

    @Test
    void testDeleteAllGameInvitesToReceiver(){

        User admin = userService.getUser("admin").get();
        User user3 = userService.getUser("user3").get();

        GameInvite newInvite = gameInviteService.sendInvite(multiplayerService.getById(4),user3,admin,InviteType.PLAYER);
        gameInviteService.findById(1).setStatus(GameInvite.GameInviteStatus.PENDING);
        gameInviteService.deleteAllGameInvitesToReceiver(admin,4);

        assertEquals(null, gameInviteService.findById(newInvite.getId()));

    }
    @Test
    void testDeleteInvite(){
        GameInvite invite1 = gameInviteService.findById(2);
        assertNotEquals(null, invite1.getId());
        gameInviteService.deleteInvite(invite1);
        assertEquals(null, gameInviteService.findById(2));




    }
}

