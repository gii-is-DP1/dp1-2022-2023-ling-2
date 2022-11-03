package org.harmony.endofline.user;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.usersGames.UsersGames;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    String username;
    String password;
    String email;
    Boolean isAdmin;
    Boolean enabled;

    @OneToMany(mappedBy = "user")
    @NotNull
    private Set<UsersGames> games;

    public User(){
        this.isAdmin = Boolean.FALSE;
        this.enabled = Boolean.TRUE;
        this.games = new HashSet<UsersGames>();
    }

    public void addMultiplayerGame(UsersGames userGame) {
        this.games.add(userGame);
    }
}
