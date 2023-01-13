package org.harmony.endofline.achievement;

import org.harmony.endofline.statistic.Statistic;
import org.harmony.endofline.statistic.StatisticService;
import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;
    @Autowired
    private UserService userService;

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
        return achievementRepository.getByName(name) == null;
    }
    public List<Achievement> getAllAchievements(){
        return (List<Achievement>) achievementRepository.findAll();
    }

    public void deleteAchievement(String achievementName) {
        int id = achievementRepository.getByName(achievementName).getId();
        achievementRepository.deleteById(id);
    }

    public Achievement findByName(String achievementName) {
        return achievementRepository.findByName(achievementName);
    }

    // Achievement checks for User
    private boolean checkMultiplayerCreated(User user, int amount){
        Integer playerOneGames = userService.getMultiplayerGames(user.getUsername()).size();
        return playerOneGames >= amount;
    }

    @Transactional
    public User calculateAchievementsForUser(User user, Statistic stats, List<Achievement> allAchievements) {
        for(Achievement achievement: allAchievements) if (!user.getAchievements().contains(achievement)){
            switch (achievement.getConditions()){
                case MULTIPLAYER_AMOUNT -> {
                    if (user.getMultiplayerGames().size() >= achievement.getConditionAmounts())
                        user.addAchievement(achievement);
                }
                case MULTIPLAYER_WINS -> {
                    if (stats.getNumberMultiPlayerWins() >= achievement.getConditionAmounts())
                        user.addAchievement(achievement);
                }
                case MULTIPLAYER_CREATED -> {
                    if (checkMultiplayerCreated(user, achievement.getConditionAmounts()))
                        user.addAchievement(achievement);
                }
                case SINGLEPLAYER_AMOUNT -> {
                    if (user.getSingleplayerGames().size() >= achievement.getConditionAmounts())
                        user.addAchievement(achievement);
                }
                case SINGLEPLAYER_WINS -> {
                    if (stats.getNumberSinglePlayerWins() >= achievement.getConditionAmounts())
                        user.addAchievement(achievement);
                }
                default -> {
                }
            }
        }
        return user;
    }
}
