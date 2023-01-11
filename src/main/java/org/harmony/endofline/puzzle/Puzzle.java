package org.harmony.endofline.puzzle;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.singleplayer.Singleplayer;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "puzzles")
public class Puzzle extends BaseEntity {

    @NotNull
    private Difficulty difficulty;

    @OneToMany(mappedBy = "puzzle")
    private List<Singleplayer> singleplayers;


}
