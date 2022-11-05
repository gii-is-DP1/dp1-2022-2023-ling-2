package org.harmony.endofline.model;


import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.multiplayer.MultiplayerController;
import org.harmony.endofline.multiplayer.MultiplayerRepository;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.user.UserService;
import org.harmony.endofline.userGame.UserGameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MultiplayerController.class,
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
    excludeAutoConfiguration= SecurityConfiguration.class)
public class MultiplayerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MultiplayerService multiService;
    @MockBean
    UserService userService;
    @MockBean
    UserGameService userGameService;


    @WithMockUser(value = "spring")
    @Test
    public void multiplayerTest() throws Exception {
        multiplayerLoggedIn();
        multiplayerNotLoggedIn();
        userGameRelation();
    }

    private void multiplayerLoggedIn() throws Exception {
        mockMvc.perform(post("/multiplayer/create").with(csrf())).andExpect(status().isOk())
            .andExpect(model().attributeExists("game"));
    }

    private void multiplayerNotLoggedIn() {
        // TODO must take you to game page and associate game with players
    }

    private void userGameRelation() {
        // TODO check the game is related to the user spring
    }
}
