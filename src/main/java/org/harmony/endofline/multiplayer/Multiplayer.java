package org.harmony.endofline.multiplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.userGame.UserGame;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "game")
    @NotNull
    private Set<UserGame> users;

    public Multiplayer() {
        super(LocalDateTime.now());
        this.priorityList = new ArrayList<Integer>();
        this.p1EnergyLeft = 3;
        this.p2EnergyLeft = 3;
        this.users = new HashSet<UserGame>();
    }

    public void addUser(UserGame userGame) {
        this.users.add(userGame);
    }

    // TODO many to many relation with line cards (Association class)
    // TODO many to many relation with Users

}
