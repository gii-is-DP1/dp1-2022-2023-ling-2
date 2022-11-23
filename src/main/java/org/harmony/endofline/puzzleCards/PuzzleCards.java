package org.harmony.endofline.puzzleCards;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.puzzle.Puzzle;
import org.springframework.data.util.Pair;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@Table(name = "puzzle_cards")
public class PuzzleCards extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "puzzle_id")
    private Puzzle puzzle;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Min(0)
    @Max(4)
    @JoinColumn(name = "x")
    private Integer x;

    @Min(0)
    @Max(4)
    @JoinColumn(name = "y")
    private Integer y;

    @Min(0)
    @Max(3)
    @JoinColumn(name = "rotation")
    private Integer rotation;
}
