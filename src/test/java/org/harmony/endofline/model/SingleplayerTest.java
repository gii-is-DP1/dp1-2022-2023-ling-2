package org.harmony.endofline.model;

import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.singleplayer.SingleplayerController;
import org.harmony.endofline.singleplayer.SingleplayerRepository;
import org.harmony.endofline.singleplayer.SingleplayerService;
import org.harmony.endofline.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = SingleplayerController.class, excludeAutoConfiguration= SecurityConfiguration.class)
public class SingleplayerTest {
    @MockBean
    SingleplayerService singleService;
    @MockBean
    UserService userService;
    @MockBean
    SingleplayerRepository singleRepo;
    @Autowired
    MockMvc mockMvc;


    @Test
    public void singleplayerTest() throws Exception{
        singleplayerNotLoggedIn();
        singleplayerLoggedIn();
    }


    @WithMockUser
    private void singleplayerLoggedIn() throws Exception {
        // TODO everything fine
        mockMvc.perform(post("/singleplayer/create")).andExpect(status().isOk())
            .andExpect(model().attributeExists("game"));
    }

    private void singleplayerNotLoggedIn() {

        // TODO not possible
    }

}
