package org.harmony.endofline.user;

import org.harmony.endofline.achievement.Achievement;
import org.harmony.endofline.achievement.AchievementRepository;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.statistic.Statistic;
import org.harmony.endofline.statistic.StatisticService;
import org.harmony.endofline.userGame.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AchievementRepository achievementRepository;
    @Autowired
    public UserService(UserRepository userRepository,AchievementRepository achievementRepository) {
        this.userRepository = userRepository;
        this.achievementRepository = achievementRepository;
    }

    public Optional<User> getUser(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(User user) {
        userRepository.deleteByUsername(user.getUsername());
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Transactional
    public void addUserGame(User user, UserGame userGame) {
        user.getStatistic().increaseNumberOfGames();
        user.addMultiplayerGame(userGame);
    }

    @Transactional
    public void addSingleplayerGame(User user, Singleplayer game) {
        user.getStatistic().increaseNumberOfGames();
        user.addSingleplayerGame(game);
    }

    public List<Multiplayer> getMultiplayerGames(String username) {
        return userRepository.findUserMultiplayerGames(username);
    }

    public List<Singleplayer> getSingleplayerGames(String username) {
        return userRepository.findUserSingleplayerGames(username);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<Achievement> getAllAchievementsOfUser(String username){
        return userRepository.findAchievementsByUsername(username);
    }
}
