package org.harmony.endofline.multiplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.user.User;
import org.harmony.endofline.userGame.UserGame;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "multiplayer_games")
public class Multiplayer extends Game {

    @OneToMany(mappedBy = "game")
    @NotNull
    private List<UserGame> users;

    @OneToOne
    private User activePlayer;

    @NotNull
    private Boolean isPublic;


    public Multiplayer(boolean isPublic) {
        super(LocalDateTime.now());
        this.isPublic = isPublic;
        this.users = new ArrayList<UserGame>();
    }

    public Multiplayer() {
        super(LocalDateTime.now());
        this.isPublic = true;
        this.users = new ArrayList<UserGame>();
    }

    public void addUser(UserGame userGame) {
        this.users.add(userGame);
    }

}
