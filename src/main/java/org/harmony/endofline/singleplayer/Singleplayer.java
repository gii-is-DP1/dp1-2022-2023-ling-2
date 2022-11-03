package org.harmony.endofline.singleplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "singleplayer_game")
public class Singleplayer extends Game {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public Singleplayer(User user) {
        super(LocalDateTime.now());
        this.user = user;
    }

    // TODO many to many relation with line cards (Association class)
    // TODO one to many relation with Users (User foreign key here)

}
