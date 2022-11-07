package org.harmony.endofline.singleplayer;

import org.harmony.endofline.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleplayerUserGameRelationTest {

    @Spy
    User user = new User();
    @Spy
    Singleplayer game = new Singleplayer();

    @Test
    public void test() {
        addGameToUser();
        setUserInGame();
    }

    void setUserInGame() {
        game.setUser(user);
        assertEquals(user, game.getUser());
    }

    void addGameToUser() {
        user.addSingleplayerGame(game);
        assertEquals(1, user.getSingleplayerGames().size());
    }

}
