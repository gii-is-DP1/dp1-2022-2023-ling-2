package org.harmony.endofline.multiplayer;


import org.harmony.endofline.configuration.SecurityConfiguration;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MultiplayerController.class,
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
    excludeAutoConfiguration= SecurityConfiguration.class)
public class MultiplayerCreationTest {
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
    public void multiplayerLoggedIn() throws Exception {
        mockMvc.perform(post("/multiplayer/create?type=public").with(csrf())).andExpect(status().isOk())
            .andExpect(model().attributeExists("game"));
    }

    @Test
    public void multiplayerNotLoggedIn() throws Exception {
        mockMvc.perform(post("/multiplayer/create").with(csrf()))
            .andExpect(status().isUnauthorized());
    }
}
