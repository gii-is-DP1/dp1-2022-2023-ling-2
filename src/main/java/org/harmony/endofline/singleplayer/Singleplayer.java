package org.harmony.endofline.singleplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.Game;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "singleplayer_game")
public class Singleplayer extends Game {

    // TODO many to many relation with line cards (Association class)
    // TODO one to many relation with Users (User foreign key here)

}
