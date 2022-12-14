package org.harmony.endofline.singleplayer;

import org.harmony.endofline.board.BoardService;
import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.deck.DeckService;
import org.harmony.endofline.puzzle.PuzzleService;
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
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
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
    BoardService boardService;
    @MockBean
    PuzzleService puzzleService;
    @MockBean
    DeckService deckService;
    @MockBean
    UserService userService;
    @MockBean
    UserGameService userGameService;

    @WithMockUser(value = "user")
    @Test
    public void singleplayerLoggedIn() throws Exception {
        mockMvc.perform(post("/singleplayer/create").param("difficulty", "easy").with(csrf())).andExpect(status().isOk());
    }

    @Test
    public void singleplayerNotLoggedIn() throws Exception {
        mockMvc.perform(post("/singleplayer/create").with(csrf()))
            .andExpect(status().isUnauthorized());
    }

}
