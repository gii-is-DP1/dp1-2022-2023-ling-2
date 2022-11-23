package org.harmony.endofline.user;

import org.ehcache.core.spi.service.StatisticsService;
import org.harmony.endofline.achievement.Achievement;
import org.harmony.endofline.achievement.AchievementService;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.singleplayer.SingleplayerService;
import org.harmony.endofline.statistic.Statistic;
import org.harmony.endofline.statistic.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private static final String VIEWS_USER_CREATE_UPDATE_FORM = "users/createOrUpdateUserForm";
    private static final String VIEWS_USER_DELETE_FORM = "users/deleteUserForm";
    private static final String VIEWS_USER_GAMES_FORM = "users/viewUsersGames";
    private static final String VIEWS_DASHBOARD = "admin/dashboard";

    private final UserService userService;
    private final MultiplayerService multiplayerService;
    private final SingleplayerService singleplayerService;
    private final AchievementService achievementService;
    private final StatisticService statisticService;

    @Autowired
    public UserController(UserService us, MultiplayerService multiplayerService, SingleplayerService singleplayerService, AchievementService achievementService,StatisticService statisticService) {
        this.userService = us;
        this.multiplayerService = multiplayerService;
        this.singleplayerService = singleplayerService;
        this.achievementService = achievementService;
        this.statisticService = statisticService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/u/new")
    public String initCreationForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return VIEWS_USER_CREATE_UPDATE_FORM;
    }

    @PostMapping(value = "/u/new")
    public String processCreationForm(@Valid User user, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("user", user);
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else if (userService.isUsernameTaken(user.getUsername())) {
            result.rejectValue("username", "taken", "This username is already taken");
            model.put("user", user);
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else if (userService.isEmailTaken(user.getEmail())) {
            result.rejectValue("email", "taken", "This email is already in use");
            model.put("user", user);
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else {
            //creating owner, user, and authority
            this.userService.createUser(user);
            return "welcome";
        }
    }

    @GetMapping("/u/{username}")
    public ModelAndView showUser(@PathVariable("username") String username) {
        var user = this.userService.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        ModelAndView mav = new ModelAndView("users/userDetails");
        mav.addObject(user);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        mav.addObject(
            "private_info",
            user.getUsername().equals(authenticatedUser.getUsername()) || authenticatedUser.getIsAdmin()
        );
        mav.addObject(
            "admin",
            user.getIsAdmin()
        );

        List<Multiplayer> multiplayerGames = userService.getMultiplayerGames(username);
        mav.addObject("multiplayerGames", multiplayerGames);

        mav.addObject("singleplayerGames", user.getSingleplayerGames());

        mav.addObject("statistic", user.getStatistic());

        List<Achievement> allAchievements = achievementService.getAllAchievements();
        achievementService.calculateAchievementsForUser(user, user.getStatistic(), allAchievements);

        mav.addObject("achievements", user.getAchievements());

        return mav;
    }

    @GetMapping("/u/{username}/edit")
    public String initUpdateUserForm(@PathVariable("username") String username, Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        if (authenticatedUser==null || (!authenticatedUser.getUsername().equals(username) && !authenticatedUser.getIsAdmin())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        User user = this.userService.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        model.put("user", user);
        model.put("own", authenticatedUser.getUsername().equals(username));
        return VIEWS_USER_CREATE_UPDATE_FORM;
    }

    @PostMapping("/u/{username}/edit")
    public String processUpdateUserForm(@Valid User user, BindingResult result, @PathVariable("username") String username, Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        User oldUser = userService.findByUsername(username);
        if (oldUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (authenticatedUser==null || (!authenticatedUser.getUsername().equals(username) && !authenticatedUser.getIsAdmin())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        if (result.hasFieldErrors("email") || (result.hasFieldErrors("password") && authenticatedUser.getUsername().equals(username))) {
            user.setId(userService.findByUsername(username).getId());
            model.put("user", user);
            model.put("own", authenticatedUser.getUsername().equals(username));
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else if (userService.isEmailTaken(user.getEmail()) && !user.getEmail().equals(authenticatedUser.getEmail())) {
            result.rejectValue("email", "taken", "This email is already in use");
            user.setId(userService.findByUsername(username).getId());
            model.put("user", user);
            model.put("own", authenticatedUser.getUsername().equals(username));
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else {
            userService.updateUser(oldUser, user);
            return "welcome";
        }
    }

    @GetMapping("u/{username}/delete")
    public String initDeleteUserForm(@PathVariable("username") String username, Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        User user = this.userService.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (authenticatedUser == null || user.getIsAdmin() || (!authenticatedUser.getUsername().equals(username) && !authenticatedUser.getIsAdmin())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        model.put("user", user);
        return VIEWS_USER_DELETE_FORM;
    }

    @PostMapping("u/{username}/delete")
    public String processDeleteUserForm(@PathVariable("username") String username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        User user = this.userService.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (authenticatedUser == null || user.getIsAdmin() || (!authenticatedUser.getUsername().equals(username) && !authenticatedUser.getIsAdmin())){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        this.userService.deleteUser(user);
        return "redirect:/logout";
    }

    @GetMapping("/dashboard")
    public String getAdminDashboard(Map<String, Object> model) {
        List<Multiplayer> multiplayerGames = multiplayerService.getAllGamesWithUser();
        List<Singleplayer> singleplayerGames = singleplayerService.getAllGamesWithUser();

        List<User> users = userService.getAllUsers();

        List<Achievement> achievements = achievementService.getAllAchievements();

        model.put("multi", multiplayerGames);
        model.put("single", singleplayerGames);
        model.put("users", users);
        model.put("achievements", achievements);

        return VIEWS_DASHBOARD;
    }
}
