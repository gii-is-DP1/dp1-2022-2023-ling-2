package org.harmony.endofline.board;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import org.harmony.endofline.model.BaseEntity;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BoardCard extends BaseEntity {
    String type;
    String color;
    @Range(min=0,max=6)
    int xPosition;
    @Range(min=0,max=6)
    int yPosition;

    @ManyToOne
    Board board;


    public Integer getPositionXInPixels(Integer size) {
        return (xPosition)*size;
    }

    public Integer getPositionYInPixels(Integer size) {
        return (yPosition)*size;
    }


}
