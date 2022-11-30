package org.harmony.endofline.singleplayer;

import lombok.Getter;
import lombok.Setter;

import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.puzzle.Puzzle;
import org.harmony.endofline.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "singleplayer_game")
public class Singleplayer extends Game {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "puzzle_id")
    private Puzzle puzzle;


    @OneToMany
    private List<GameCard> gameCards;

    public Singleplayer(User user) {
        super(LocalDateTime.now());
        this.user = user;
    }

    public Singleplayer() {
        super(LocalDateTime.now());
    }

    // TODO many to many relation with line cards (Association class)
    // TODO one to many relation with Users (User foreign key here)

}
