package org.harmony.endofline.user;

import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.singleplayer.SingleplayerService;
import org.junit.jupiter.api.BeforeEach;
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

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test class for {@link UserController}
 *
 * @author
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = SecurityConfiguration.class)
public class UserControllerTests {

    private static final String TEST_USER_USERNAME = "georgify";

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @MockBean
    private MultiplayerService multiplayerService;

    @MockBean
    private SingleplayerService singleplayerService;

    @Autowired
    private MockMvc mockMvc;

    private User george;

    @BeforeEach
    void setup() {
        george = new User();
        george.setId(1);
        george.setUsername(TEST_USER_USERNAME);
        george.setEmail("george@localhost.com");
        george.setPassword("12345");

        given(this.userService.findByUsername(TEST_USER_USERNAME)).willReturn(george);
    }


    @WithMockUser(value = "spring")
    @Test
    void testShowUser() throws Exception {
        mockMvc.perform(get("/u/{username}", TEST_USER_USERNAME)).andExpect(status().isOk())
            .andExpect(model().attribute("george", hasProperty("username", is(TEST_USER_USERNAME))))
            .andExpect(model().attribute("george", hasProperty("email", is("george@localhost.com"))))
            .andExpect(model().attribute("george", hasProperty("password", is("testPassword")))) // TODO: test for password?
            .andExpect(view().name("users/userDetails"));
    }

    @WithMockUser(value = "spring")
    @Test
    void testInitCreationForm() throws Exception {
        mockMvc.perform(get("/u/new")).andExpect(status().isOk()).andExpect(model().attributeExists("user"))
            .andExpect(view().name("users/createOrUpdateUserForm"));
    }

    @WithMockUser(value = "spring")
    @Test
    void testProcessCreationFormSuccess() throws Exception {
        mockMvc.perform(post("/u/new").param("username", "testUser").param("email", "test@mail.com").with(csrf())
                .param("password", "testPassword"))
            .andExpect(status().is3xxRedirection());
    }



    @WithMockUser(value = "spring")
    @Test
    void testInitUpdateUserForm() throws Exception {
        mockMvc.perform(get("/u/{username}/edit", TEST_USER_USERNAME)).andExpect(status().isOk())
            .andExpect(model().attributeExists("user"))
            .andExpect(model().attribute("user", hasProperty("username", is(TEST_USER_USERNAME))))
            .andExpect(model().attribute("user", hasProperty("email", is("test@mail.com"))))
            .andExpect(model().attribute("user", hasProperty("password", is("testPassword."))))
            .andExpect(view().name("users/createOrUpdateUserForm"));
    }

    @WithMockUser(value = "spring")
    @Test
    void testProcessUpdateUserFormSuccess() throws Exception {
        mockMvc.perform(post("/u/{username}/edit", TEST_USER_USERNAME).with(csrf())
                .param("username", "newGeorgify")
                .param("email", "newTest@mail.com")
                .param("password", "newTestPassword"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/u/{username}"));
    }


    @WithMockUser(value = "spring")
    @Test
    void testProcessUpdateUserFormHasErrors() throws Exception {
        mockMvc.perform(post("/u/{username}/edit", TEST_USER_USERNAME).with(csrf())
                .param("username", "newGeorgify")
                .param("email", "newTest@mail.com"))
            .andExpect(status().isOk())
            .andExpect(model().attributeHasErrors("user"))
            .andExpect(model().attributeHasFieldErrors("user", "password"))
            .andExpect(view().name("users/createOrUpdateUserForm"));
    }




}
