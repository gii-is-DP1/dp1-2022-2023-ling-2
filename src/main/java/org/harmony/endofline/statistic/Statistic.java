package org.harmony.endofline.statistic;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "stats")
public class Statistic extends BaseEntity {

    @OneToOne
    @NotNull
    private User user;

    private int numberGames;

    private int numberSinglePlayerWins;

    private int numberSinglePlayerLosses;

    private int numberMultiPlayerWins;

    private int numberMultiPlayerLosses;
}
