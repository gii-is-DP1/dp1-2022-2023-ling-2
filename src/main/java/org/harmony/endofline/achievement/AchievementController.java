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
    private final String VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM = "achievements/createOrUpdateAchievement";

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping(value = "/{achievementName}")
    public String showAchievement(@PathVariable("achievementName") String achievementName, Map<String, Object> model) {
        Achievement achievement = this.achievementService.findByName(achievementName);

        model.put("achievement", achievement);
        model.put("condition", Arrays.stream(Achievement.condits.values()).toList());
        return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
    }
    @PostMapping(value = "/{achievementName}")
    public String processCreationForm(@Valid Achievement achievement, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("achievement", achievement);
            model.put("condition", Arrays.stream(Achievement.condits.values()).toList());
            return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
        }
        else{
            try{
                if(achievementService.exists(achievement)){
                    achievementService.updateAchievement(achievement, achievement.getId());
                }else {
                    this.achievementService.addAchievement(achievement);
                }
            }catch (InvalidAchievementNameExeption e){
                result.rejectValue("name", "invalid", "This name is already in use");
                return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
            }
            return "redirect:/dashboard";
        }
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
