package org.harmony.endofline.achievement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
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

    @ModelAttribute("condition")
    public List<Achievement.condits> populatePets() {
        return Arrays.stream(Achievement.condits.values()).toList();
    }

    @GetMapping("/new")
    public String getAchievementForm(Map<String, Object> model) {
        Achievement achievement = new Achievement();

        model.put("achievement", achievement);
        return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
    }

    @PostMapping(value = "/new")
    public String createAchievement(@Valid Achievement achievement, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("achievement", achievement);
            return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
        }
        else{
            try{
                achievementService.addAchievement(achievement);
            }catch (InvalidAchievementNameExeption e){
                result.rejectValue("name", "invalid", "This name is already in use");
                return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
            }
            return "redirect:/dashboard";
        }
    }

    @GetMapping(value = "/{achievementName}")
    public String showAchievement(@PathVariable("achievementName") String achievementName, Map<String, Object> model) {
        Achievement achievement = this.achievementService.findByName(achievementName);

        model.put("achievement", achievement);
        return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
    }
    @PostMapping(value = "/{achievementName}")
    public String updateAchievement(@Valid Achievement achievement, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("achievement", achievement);
            return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
        }
        else{
            try{
                achievementService.updateAchievement(achievement, achievement.getId());
            }catch (InvalidAchievementNameExeption e){
                result.rejectValue("name", "invalid", "This name is already in use");
                return VIEWS_ACHIEVEMENTS_CREATE_UPDATE_FORM;
            }
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/{achievementName}/delete")
    public String deleteAchievement(@PathVariable("achievementName") String achievementName){
        achievementService.deleteAchievement(achievementName);
        return  "redirect:/dashboard";
    }
}
