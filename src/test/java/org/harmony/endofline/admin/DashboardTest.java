package org.harmony.endofline.admin;


import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.singleplayer.SingleplayerService;
import org.harmony.endofline.user.UserController;
import org.harmony.endofline.user.UserService;
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
@WebMvcTest(value = UserController.class,
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
    excludeAutoConfiguration= SecurityConfiguration.class)
public class DashboardTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    @MockBean
    MultiplayerService multiService;
    @MockBean
    SingleplayerService singleService;

    @WithMockUser
    @Test
    public void dashboardIsAdmin() throws Exception {
        mockMvc.perform(get("/dashboard").with(csrf())).andExpect(status().isOk())
            .andExpect(model().attributeExists("multi"))
            .andExpect(model().attributeExists("single"))
            .andExpect(model().attributeExists("users"));
    }


    @Test
    public void dashboardNotAdmin() throws Exception {
        mockMvc.perform(get("/dashboard")).andExpect(status().isForbidden());
    }

    @Test
    public void dashboardNotLoggedIn() throws Exception {
        mockMvc.perform(get("/dashboard")).andExpect(status().isUnauthorized());
    }

}
