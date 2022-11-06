package org.harmony.endofline.user;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.singleplayer.Singleplayer;
import org.harmony.endofline.userGame.UserGame;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
    Boolean isAdmin;
    Boolean enabled;

    @OneToMany(mappedBy = "user")
    @NotNull
    private Set<UserGame> multiplayerGames;

    @OneToMany(mappedBy = "user")
    @NotNull
    private Set<Singleplayer> singleplayerGames;

    public User(){
        this.isAdmin = Boolean.FALSE;
        this.enabled = Boolean.TRUE;
        this.multiplayerGames = new HashSet<UserGame>();
        this.singleplayerGames = new HashSet<Singleplayer>();
    }

    public void addMultiplayerGame(UserGame userGame) {
        this.multiplayerGames.add(userGame);
    }

    public void addSingleplayerGame(Singleplayer game) {
        this.singleplayerGames.add(game);
    }
}
