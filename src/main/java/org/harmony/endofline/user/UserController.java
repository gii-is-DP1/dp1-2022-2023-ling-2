package org.harmony.endofline.user;

import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.singleplayer.Singleplayer;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService us) {
        this.userService = us;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/users/new")
    public String initCreationForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return VIEWS_USER_CREATE_UPDATE_FORM;
    }

    @PostMapping(value = "/users/new")
    public String processCreationForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else {
            //creating owner, user, and authority
            this.userService.createUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/users/{username}")
    public ModelAndView showUser(@PathVariable("username") String username) {
        ModelAndView mav = new ModelAndView("users/userDetails");
        mav.addObject(this.userService.getUser(username));
        return mav;
    }


    @GetMapping("/users/{username}/games")
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
}
