package org.harmony.endofline.userGame;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.user.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@Table(name = "usergames")
public class UserGame extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Multiplayer game;

    @Max(value=2)
    @Min(value=1)
    private Integer player;

    private String role; // player or spectator

    public UserGame(User user, Multiplayer game, Integer player, String role) {
        this.user = user;
        this.game = game;
        this.player = player;
        this.role = role;
    }

    public UserGame() {
    }
}
