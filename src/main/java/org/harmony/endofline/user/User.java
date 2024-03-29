package org.harmony.endofline.user;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.achievement.Achievement;
import org.harmony.endofline.friendRequest.FriendRequest;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.gameInvite.GameInvite;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.statistic.Statistic;
import org.harmony.endofline.userGame.UserGame;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotEmpty
    @Size(min = 3, max = 15)
    String username;
    @NotEmpty
    @Size(min = 3, max = 128)
    String password;
    @NotEmpty
    @Email
    String email;
    @Column(name = "is_admin")
    Boolean isAdmin;
    Boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private Set<UserGame> multiplayerGames;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private Set<Singleplayer> singleplayerGames;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GameCard> gameCard;

    @ManyToMany
    @JoinTable(name = "achievement_user",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private List<Achievement> achievements;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "statistics_id", referencedColumnName = "id")
    private Statistic statistic;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private List<FriendRequest> sentRequests;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private List<FriendRequest> receivedRequests;

    @ManyToMany
    private Set<User> friends;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private List<GameInvite> receivedInvitations;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    private List<GameInvite> sentInvitations;

    public User(){
        this.isAdmin = Boolean.FALSE;
        this.enabled = Boolean.TRUE;
        this.multiplayerGames = new HashSet<UserGame>();
        this.singleplayerGames = new HashSet<Singleplayer>();
        this.sentRequests = new ArrayList<FriendRequest>();
        this.receivedRequests = new ArrayList<FriendRequest>();
        this.friends = new HashSet<User>();
        this.achievements = new ArrayList<Achievement>();
        this.statistic = new Statistic();
        this.receivedInvitations = new ArrayList<GameInvite>();
        this.sentInvitations = new ArrayList<GameInvite>();
    }

    public void addMultiplayerGame(UserGame userGame) {
        this.multiplayerGames.add(userGame);
    }

    public void addSingleplayerGame(Singleplayer game) {
        this.singleplayerGames.add(game);
    }

    public void addAchievement(Achievement achievement){
        this.achievements.add(achievement);
    }

    public void addFriend(User user) {
        this.friends.add(user);
    }

    public void removeFriend(User friend) {
        this.friends.remove(friend);
    }
}
