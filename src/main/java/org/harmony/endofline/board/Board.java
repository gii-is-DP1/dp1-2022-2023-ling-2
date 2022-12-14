package org.harmony.endofline.board;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.gameCard.GameCard;
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
    @Positive
    int width;
    @Positive
    int height;

    public Board(){
        this.width=5;
        this.height=5;
    }

}
