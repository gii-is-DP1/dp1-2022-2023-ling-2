package org.harmony.endofline.multiplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.Game;
import org.harmony.endofline.userGame.UserGame;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

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
    private List<UserGame> users;

    @NotNull
    private Boolean isPublic;

    @NotNull
    private LocalDateTime searchDate;

    @NotNull
    private Boolean inQueue;

    public Multiplayer(boolean isPublic) {
        super(LocalDateTime.now());
        this.searchDate = LocalDateTime.now();
        this.priorityList = new ArrayList<Integer>();
        this.p1EnergyLeft = 3;
        this.p2EnergyLeft = 3;
        this.isPublic = isPublic;
        this.inQueue = true;
        this.users = new ArrayList<UserGame>();
    }

    public Multiplayer(){
        super(LocalDateTime.now());
    }

    public void addUser(UserGame userGame) {
        this.users.add(userGame);
    }

    // TODO many to many relation with line cards (Association class)
    // TODO many to many relation with Users

}
