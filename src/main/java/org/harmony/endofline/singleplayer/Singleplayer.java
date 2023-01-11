package org.harmony.endofline.singleplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.puzzle.Puzzle;
import org.harmony.endofline.user.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @ManyToOne
    @JoinColumn(name = "puzzle_id")
    private Puzzle puzzle;

    @OneToOne
    @JoinColumn(name = "last_placed_card_id")
    private GameCard lastPlacedCard;

    @Min(0)
    @Max(3)
    private Integer energy;

    public Singleplayer(User user, Puzzle puzzle) {
        super(LocalDateTime.now());
        this.user = user;
        this.puzzle = puzzle;
        this.energy = 3;
    }

    public Singleplayer() {
        super(LocalDateTime.now());
    }
}
