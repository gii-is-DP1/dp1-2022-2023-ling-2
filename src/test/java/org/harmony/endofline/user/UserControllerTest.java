package org.harmony.endofline.user;

import org.harmony.endofline.achievement.AchievementService;
import org.harmony.endofline.configuration.SecurityConfiguration;
import org.harmony.endofline.friendRequest.FriendRequestService;
import org.harmony.endofline.gameInvite.GameInviteService;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.singleplayer.SingleplayerService;
import org.harmony.endofline.statistic.StatisticService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
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
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    @MockBean
    AchievementService achievementService;
    @MockBean
    StatisticService statisticService;
    @MockBean
    FriendRequestService friendRequestService;
    @MockBean
    MultiplayerService multiService;
    @MockBean
    SingleplayerService singleService;
    @MockBean
    GameInviteService gameInviteService;

    private User user;
    private User user2;

    private static final String TEST_USER_USERNAME = "user";

    @BeforeEach
    void setup() {
        user = new User();
        user.setUsername(TEST_USER_USERNAME);
        user.setEmail("user@user.com");
        user.setPassword("user");
        user.setIsAdmin(false);

        user2 = new User();
        user2.setUsername("user2");
        user2.setEmail("user2@user.com");
        user2.setPassword("user2");
        user2.setIsAdmin(false);

        user.addFriend(user2);
        user2.addFriend(user);

        given(this.userService.findByUsername(anyString())).willReturn(user);
    }


    @WithMockUser(value = "spring")
    @Test
    void testShowUser() throws Exception {

        mockMvc.perform(get("/u/{username}", TEST_USER_USERNAME)).andExpect(status().isOk())
            .andExpect(model().attribute("user", hasProperty("username", is(TEST_USER_USERNAME))))
            .andExpect(model().attribute("user", hasProperty("email", is("user@user.com"))))
            .andExpect(model().attribute("user", hasProperty("password", is("user")))) // TODO: test for password?
            .andExpect(view().name("users/userDetails"));
    }

    @WithMockUser(value = "spring")
    @Test
    void testShowUserWithErrors() throws Exception {

        when(mockMvc.perform(get("/u/{username}", "no_user")))
            .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

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
            .andExpect(status().is2xxSuccessful());
    }


    @WithMockUser(value = "spring")
    @Test
    void testInitUpdateUserForm() throws Exception {

        mockMvc.perform(get("/u/{username}/edit", TEST_USER_USERNAME)).andExpect(status().isOk())
            .andExpect(view().name("users/createOrUpdateUserForm"));
    }

    @WithMockUser(value = "spring")
    @Test
    void testProcessUpdateUserFormSuccess() throws Exception {
        mockMvc.perform(post("/u/{username}/edit", TEST_USER_USERNAME).with(csrf())
                .param("email", "newTest@mail.com"))
            .andExpect(status().isOk())
            .andExpect(view().name("users/createOrUpdateUserForm"));
    }


    @WithMockUser(value = "spring")
    @Test
    void testProcessUpdateUserFormHasErrors() throws Exception {
        mockMvc.perform(post("/u/{username}/edit", TEST_USER_USERNAME).with(csrf())
                .param("username", "newUser")
                .param("email", "newmail@user.com"))
            .andExpect(status().isOk())
            .andExpect(model().attributeHasErrors("user"))
            .andExpect(model().attributeHasFieldErrors("user", "password"))
            .andExpect(view().name("users/createOrUpdateUserForm"));
    }


    @WithMockUser
    @Test
    void testInitDeleteUserFormSuccessful() throws Exception {
        mockMvc.perform(get("/u/{username}/delete", TEST_USER_USERNAME)).andExpect(status().isOk())
            .andExpect(view().name("users/deleteUserForm"));
    }

    @WithMockUser
    @Test
    void testInitDeleteUserFormWithError() throws Exception {
        when(mockMvc.perform(get("/u/{username}/delete", "no_user")))
            .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @WithMockUser
    @Test
    void processDeleteUserFormSuccessful() throws Exception {
        mockMvc.perform(post("/u/{username}/delete", TEST_USER_USERNAME).with(csrf()))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/logout")); // TODO: why redirect to logout?
    }

    @WithMockUser
    @Test
    void getAdminDashboardSuccessful() throws Exception {
        mockMvc.perform(get("/dashboard"))
            .andExpect(status().isOk())
            .andExpect(view().name("admin/dashboard"));
    }

    @WithMockUser
    @Test
    void getFriendsSuccessful() throws Exception {
        mockMvc.perform(get("/u/{username}/friends", TEST_USER_USERNAME))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("friends"))
            .andExpect(view().name("users/friends"));
    }

}
