package org.harmony.endofline.singleplayerHand;


import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.puzzleCards.PuzzleCards;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "singleplayer_hand")
public class SingleplayerHand extends BaseEntity {

    @OneToMany(mappedBy = "singleplayerHand")
    List<PuzzleCards> puzzleCards;
}
