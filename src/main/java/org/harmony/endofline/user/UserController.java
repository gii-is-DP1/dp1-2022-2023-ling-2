package org.harmony.endofline.user;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.multiplayer.MultiplayerService;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.singleplayer.SingleplayerService;
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
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private static final String VIEWS_USER_CREATE_UPDATE_FORM = "users/createOrUpdateUserForm";
    private static final String VIEWS_USER_GAMES_FORM = "users/viewUsersGames";
    private static final String VIEWS_DASHBOARD = "admin/dashboard";

    private final UserService userService;
    private final MultiplayerService multiplayerService;
    private final SingleplayerService singleplayerService;

    @Autowired
    public UserController(UserService us, MultiplayerService multiplayerService, SingleplayerService singleplayerService) {
        this.userService = us;
        this.multiplayerService = multiplayerService;
        this.singleplayerService = singleplayerService;
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

        List<Multiplayer> multiplayerGames = userService.getMultiplayerGames(username);
        mav.addObject("multiplayerGames", multiplayerGames);

        List<Singleplayer> singleplayerGames = userService.getSingleplayerGames(username);
        mav.addObject("singleplayerGames", singleplayerGames);

        return mav;
    }


    @GetMapping("/u/{username}/games")
    public String getUserGames(@PathVariable("username") String username, Map<String, Object> model) throws ResponseStatusException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        if (authenticatedUser==null || !authenticatedUser.getUsername().equals(username)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        if (userService.findByUsername(username)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        List<Multiplayer> multiplayerGames = userService.getMultiplayerGames(username);
        model.put("multiplayerGames", multiplayerGames);

        List<Singleplayer> singleplayerGames = userService.getSingleplayerGames(username);
        model.put("singleplayerGames", singleplayerGames);

        return VIEWS_USER_GAMES_FORM;
    }

    @GetMapping("/dashboard")
    public String getAdminDashboard(Map<String, Object> model) throws ResponseStatusException{        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authenticatedUser = userService.findByUsername(auth.getName());
        if (authenticatedUser==null || !authenticatedUser.getIsAdmin()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        List<Multiplayer> multiplayerGames = multiplayerService.getAllGamesWithUser();
        List<Singleplayer> singleplayerGames = singleplayerService.getAllGamesWithUser();

        List<User> users = userService.getAllUsers();

        // TODO List<Achievements>

        model.put("multi", multiplayerGames);
        model.put("single", singleplayerGames);
        model.put("users", users);
        // TODO model.put("achievements", achievements");

        return VIEWS_DASHBOARD;
    }
}
