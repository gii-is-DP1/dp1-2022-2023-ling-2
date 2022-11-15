package org.harmony.endofline.stat;

import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Stat extends BaseEntity {

    @OneToOne
    @NotNull
    private User user;

    private int numberSinglePlayerWins;

    private int numberSinglePlayerLosses;

    private int numberMultiPlayerWins;

    private int numberMultiPlayerLosses;
}
