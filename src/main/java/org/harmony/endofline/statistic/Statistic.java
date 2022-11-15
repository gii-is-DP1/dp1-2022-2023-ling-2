package org.harmony.endofline.statistic;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Statistic extends BaseEntity {

    @OneToOne(mappedBy = "statistic")
    private User user;

    @Column(name = "number_games")
    private int numberGames;

    @Column(name = "number_single_player_wins")
    private int numberSinglePlayerWins;

    @Column(name = "number_single_player_losses")
    private int numberSinglePlayerLosses;

    @Column(name = "number_multi_player_wins")
    private int numberMultiPlayerWins;

    @Column(name = "number_multi_player_losses")
    private int numberMultiPlayerLosses;

    public void increaseNumberOfGames() {
        this.numberGames+=1;
    }
}
