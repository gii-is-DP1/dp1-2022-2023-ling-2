package org.harmony.endofline.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

    private static final String VIEWS_USER_CREATE_UPDATE_FORM = "users/createOrUpdateUserForm";

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
}
