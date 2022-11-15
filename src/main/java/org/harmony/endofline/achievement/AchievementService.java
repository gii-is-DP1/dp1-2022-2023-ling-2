package org.harmony.endofline.achievement;

import org.harmony.endofline.statistic.Statistic;
import org.harmony.endofline.statistic.StatisticService;
import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;
    @Autowired
    private StatisticService statService;

    @Transactional
    public void addAchievement(Achievement achievement) throws InvalidAchievementNameExeption {
        if (!checkNameIsValid(achievement.getName())){
            throw new InvalidAchievementNameExeption();
        }
        achievementRepository.save(achievement);
    }

    public boolean exists(Achievement achievement){
        return achievementRepository.existsById(achievement.getId());
    }

    @Transactional
    public void updateAchievement(Achievement achievement, Integer id) throws InvalidAchievementNameExeption {
        String currentAchievementName = achievementRepository.findById(id).get().getName();
        if (!checkNameIsValid(achievement.getName()) && !achievement.getName().equals(currentAchievementName)){
            throw new InvalidAchievementNameExeption();
        }
        achievementRepository.update(achievement.getName(),achievement.getDescription(),achievement.getConditions(),achievement.getConditionAmounts(),id);
    }

    private boolean checkNameIsValid(String name) {
        if (!(achievementRepository.getByName(name)==null)) {
            return false;
        }
        return true;
    }
    public List<Achievement> getAllAchievements(){
        return (List<Achievement>) achievementRepository.findAll();
    }

    public void deleteAchievement(String achievementName) {
        int id = achievementRepository.getByName(achievementName).getId();
        achievementRepository.deleteById(id);
    }



    //Achievement checks for User
    private boolean checkMultiplayerAmount(Statistic stat, int amount){
        return false;
    }
    private boolean checkSingleplayerAmount(Statistic stat, int amount){
        return false;
    }
    private boolean checkMultiplayerCreated(Statistic stat, int amount){
        return false;
    }
    private boolean checkMultiplayerWins(Statistic stat, int amount){
        return false;
    }
    private boolean checkSingleplayerWins(Statistic stat, int amount){
        return false;
    }

    public Achievement findByName(String achievementName) {
        return achievementRepository.findByName(achievementName);
    }

}
