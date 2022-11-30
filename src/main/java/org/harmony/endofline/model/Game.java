package org.harmony.endofline.model;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.gameCard.GameCard;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class Game extends BaseEntity {

    @Column(name = "date_started")
    @NotNull
    private LocalDateTime dateStarted;

    @Column(name = "date_ended")
    private LocalDateTime dateEnded;

    @OneToMany
    private List<GameCard> gameCards;

    private String result;

    public Game(LocalDateTime dateStarted){
        this.dateStarted = dateStarted;
        this.dateEnded = null;
        this.result = null;
    }

}
