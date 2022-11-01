package org.harmony.endofline.multiplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.model.Game;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "multiplayer_games")
public class Multiplayer extends Game {

    @ElementCollection
    @Column(name = "priority_list")
    private List<Integer> priorityList;

    @NotNull
    private Integer p1EnergyLeft;

    @NotNull
    private Integer p2EnergyLeft;

    // TODO many to many relation with line cards (Association class)
    // TODO many to many relation with Users

}
