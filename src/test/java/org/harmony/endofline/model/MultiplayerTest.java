package org.harmony.endofline.model;


import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.multiplayer.MultiplayerController;
import org.harmony.endofline.multiplayer.MultiplayerRepository;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MultiplayerController.class, excludeAutoConfiguration= SecurityConfiguration.class)
public class MultiplayerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired(required = false)
    MultiplayerRepository multiRepo;
    @MockBean
    MultiplayerService multiService;
    @MockBean
    UserService userService;


    @Test
    public void multiplayerTest() throws Exception {
        multiplayerNotLoggedIn();
        multiplayerLoggedIn();
    }

    private void multiplayerLoggedIn() throws Exception {

        // TODO everything fine
        mockMvc.perform(post("/multiplayer/create")).andExpect(status().isOk())
            .andExpect(model().attributeExists("game"));
    }

    private void multiplayerNotLoggedIn() {
        // TODO must take you to game page and associate game with players
    }
}
