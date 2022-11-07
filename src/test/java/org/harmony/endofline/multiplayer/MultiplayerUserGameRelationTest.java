package org.harmony.endofline.multiplayer;

import org.harmony.endofline.user.User;
import org.harmony.endofline.userGame.UserGame;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplayerUserGameRelationTest {

    @Spy
    User user = new User();
    @Spy
    Multiplayer game = new Multiplayer();
    @Spy
    UserGame ug = new UserGame();

    @Test
    public void test(){
        UserGameInstanceTest();
        MultiplayerUserGameTest();
        UserUserGameTest();
    }

    private void UserUserGameTest() {
        user.addMultiplayerGame(ug);
        assertEquals(1, user.getMultiplayerGames().size());
    }

    private void MultiplayerUserGameTest() {
        game.addUser(ug);
        assertEquals(1, game.getUsers().size());
    }

    private void UserGameInstanceTest() {
        ug.setUser(user);
        ug.setGame(game);
        assertEquals(user, ug.getUser());
        assertEquals(game, ug.getGame());
    }
}
