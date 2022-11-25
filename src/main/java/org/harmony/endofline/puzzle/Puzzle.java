package org.harmony.endofline.puzzle;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.singleplayer.Singleplayer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "puzzles")
public class Puzzle extends BaseEntity {

    @NotNull
    private Difficulty difficulty;

    @OneToOne(mappedBy = "puzzle")
    private Singleplayer singleplayer;


}
