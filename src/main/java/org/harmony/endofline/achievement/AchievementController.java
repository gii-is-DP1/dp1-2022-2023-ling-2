package org.harmony.endofline.achievement;


import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;


@RequestMapping("/achievement")
@Controller
public class AchievementController {

    private final AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping(value = "/{achievementName}")
    public ModelAndView showAchievement(@PathVariable("achievementName") String achievementName) {
        Achievement achievement = this.achievementService.findByName(achievementName);

        ModelAndView result = new ModelAndView("achievementInfo");
        result.addObject("achievement", achievement);

        result.addObject("condition", Arrays.stream(Achievement.condits.values()).toList());
        return result;
    }
    @PostMapping(value = "/{achievementName}")
    public String processCreationForm(@Valid Achievement achievement, BindingResult result, Map<String, Object> model) {
        if(achievementService.exists(achievement)){
            achievementService.updateAchievement(achievement, achievement.getId());
        }else {
            this.achievementService.addAchievement(achievement);
        }
        return "redirect:/dashboard";
        /*if (result.hasErrors()) {
            model.put("achievement", achievement);
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else if (achievementService.isUsernameTaken(achievement.getName())) {
            result.rejectValue("username", "taken", "This username is already taken");
            model.put("achievement", achievement);
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else if (userService.isEmailTaken(user.getEmail())) {
            result.rejectValue("email", "taken", "This email is already in use");
            model.put("achievement", achievement);
            return VIEWS_USER_CREATE_UPDATE_FORM;
        }
        else {

         */
            //creating owner, user, and authority

        //}
    }
}
