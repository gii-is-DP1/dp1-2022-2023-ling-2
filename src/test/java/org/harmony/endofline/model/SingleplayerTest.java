package org.harmony.endofline.model;

import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.singleplayer.SingleplayerController;
import org.harmony.endofline.singleplayer.SingleplayerService;
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
@WebMvcTest(value = SingleplayerController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
    excludeAutoConfiguration= SecurityConfiguration.class)
public class SingleplayerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SingleplayerService singleService;
    @MockBean
    UserService userService;
    @MockBean
    UserGameService userGameService;

    @WithMockUser(value = "spring")
    @Test
    public void singleplayerLoggedIn() throws Exception {
        // TODO everything fine
        mockMvc.perform(post("/singleplayer/create").with(csrf())).andExpect(status().isOk())
            .andExpect(model().attributeExists("game"));
    }

    @Test
    public void singleplayerNotLoggedIn() throws Exception {
        mockMvc.perform(post("/singleplayer/create").with(csrf()))
            .andExpect(status().isUnauthorized());
    }

    @WithMockUser(value = "spring")
    @Test
    public void userGameRelation() {
        // TODO check the game is related to the user spring
    }


}
