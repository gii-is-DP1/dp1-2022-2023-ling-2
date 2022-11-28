package org.harmony.endofline.board;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Getter
@Setter
public class Board extends BaseEntity {
    String background;
    @Positive
    int width;
    @Positive
    int height;

    public Board(){
        this.background="resources/images/tablero-ajedrez.jpg";
        this.width=800;
        this.height=800;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "board",fetch = FetchType.EAGER)
    List<BoardCard> cards;
}
