package org.harmony.endofline.user;

import org.harmony.endofline.achievement.Achievement;
import org.harmony.endofline.achievement.AchievementRepository;
import org.harmony.endofline.friendRequest.FriendRequest;
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
import java.util.Set;
import java.util.stream.Collectors;

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

    @Transactional
    public void updateUser(User olduser, User newuser) {
        if (newuser.getEmail() != null && !newuser.getEmail().equals(olduser.getEmail())) {
            olduser.setEmail(newuser.getEmail());
        }
        if (newuser.getPassword() != null && !newuser.getPassword().equals(olduser.getPassword())) {
            olduser.setPassword(newuser.getPassword());
        }
        userRepository.save(olduser);
    }

    public Set<User> getFriends(User user) {
        return user.getFriends();
    }

    public List<FriendRequest> getPendingReveivedRequests(User user) {
        return user.getReceivedRequests().stream().filter(e -> e.getPending()).collect(Collectors.toList());
    }

    public Object getPendingSentRequests(User user) {
        return user.getSentRequests().stream().filter(e -> e.getPending()).collect(Collectors.toList());
    }
}
