package org.harmony.endofline.multiplayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.model.Game;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "multiplayer_games")
public class Multiplayer extends Game {

    @ElementCollection
    @Column(name = "priority_list")
    @NotNull
    private List<Integer> priorityList;

    @NotNull
    private Integer p1EnergyLeft;

    @NotNull
    private Integer p2EnergyLeft;

    public Multiplayer() {
        super(LocalDateTime.now());
        this.priorityList = new ArrayList<Integer>();
        this.p1EnergyLeft = 3;
        this.p2EnergyLeft = 3;
    }

    // TODO many to many relation with line cards (Association class)
    // TODO many to many relation with Users

}
