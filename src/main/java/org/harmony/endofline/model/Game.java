package org.harmony.endofline.model;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.gameCard.GameCard;
import org.harmony.endofline.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class Game extends BaseEntity {

    @Column(name = "date_started")
    @NotNull
    private LocalDateTime dateCreated;

    @Column(name = "date_ended")
    private LocalDateTime dateEnded;

    @OneToMany
    public List<GameCard> gameCards;

    @NotNull
    private GameStatus gameStatus;

    private Integer round;

    @ManyToOne
    @JoinColumn(name = "winner_user_id")
    private User winner;

    public Game(LocalDateTime dateStarted){
        this.dateCreated = dateStarted;
        this.dateEnded = null;
        this.gameStatus = GameStatus.CREATED;
    }

}
