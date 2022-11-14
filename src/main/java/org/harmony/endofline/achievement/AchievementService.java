package org.harmony.endofline.achievement;

import org.harmony.endofline.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Transactional
    public Achievement addAchievement(Achievement achievement) throws InvalidAchievementNameExeption {
        if (!checkNameIsValid(achievement.getName())){
            throw new InvalidAchievementNameExeption();
        }
        return achievementRepository.save(achievement);
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
        if (!achievementRepository.getByName(name).equals(null)) {
            return false;
        }
        return true;
    }
    public List<Achievement> getAllAchievements(){
        return (List<Achievement>) achievementRepository.findAll();
    }

    public boolean checkUserAchievementValid(User user, Achievement achievement){
        boolean result = true;
            switch (achievement.getConditions()){
                case MULTIPLAYER_AMOUNT:
                    result = result && checkMultiplayerAmount(user,achievement.getConditionAmounts());
                    break;
                case MULTIPLAYER_CREATED:
                    result = result && checkMultiplayerCreated(user,achievement.getConditionAmounts());
                    break;
                case MUlTIPLAYER_WINS:
                    result = result && checkMultiplayerWins(user,achievement.getConditionAmounts());
                    break;
                case SINGLEPLAYER_AMOUNT:
                    result = result && checkSingleplayerAmount(user,achievement.getConditionAmounts());
                    break;
                case SINGLEPLAYER_CREATED:
                    result = result && checkSingleplayerCreated(user,achievement.getConditionAmounts());
                    break;
                case SINGLEPLAYER_WINS:
                    result = result && checkSingleplayerWins(user,achievement.getConditionAmounts());
                    break;
            }
        return result;
    }

    //Achievement checks for User
    private boolean checkMultiplayerAmount(User user, int amount){
        return false;
    }
    private boolean checkSingleplayerAmount(User user, int amount){
        return false;
    }
    private boolean checkMultiplayerCreated(User user, int amount){
        return false;
    }
    private boolean checkSingleplayerCreated(User user, int amount){
        return false;
    }
    private boolean checkMultiplayerWins(User user, int amount){
        return false;
    }
    private boolean checkSingleplayerWins(User user, int amount){
        return false;
    }

    public Achievement findByName(String achievementName) {
        return achievementRepository.findByName(achievementName);
    }
}
