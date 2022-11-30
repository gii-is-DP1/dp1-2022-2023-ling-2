package org.harmony.endofline.gameCard;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.card.Side;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class GameCard extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer gameID;

    private Boolean isMultiplayer;

    @Min(0)
    private Integer x;

    @Min(0)
    private Integer y;

    @Min(0)
    @Max(3)
    private Integer rotation;

    private Boolean inHand;


    public List<List<Integer>> getExitPositions(Integer boardDimensions) {
        List<List<Integer>> res = new ArrayList<>();
        List<Side> sidesRotated = getRotatedSides();
        for(int i=0; i<sidesRotated.size(); i++){
            Side side = sidesRotated.get(i);
            if(side.equals(Side.EXIT)){
                switch (i){
                    case 0 -> res.add(List.of(x, (y-1)%boardDimensions));
                    case 1 -> res.add(List.of((x+1)%boardDimensions, y));
                    case 2 -> res.add(List.of(x, (y+1)%boardDimensions));
                    case 3 -> res.add(List.of((x-1)%boardDimensions, y));
                }
            }
        }
        return res;
    }

    private List<Side> getRotatedSides() {
        List<Side> sidesRotated = null;
        switch (rotation){
            case 0 -> sidesRotated = List.of(this.card.getUp(), this.card.getRight(), this.card.getDown(), this.card.getLeft());
            case 1 -> sidesRotated = List.of(this.card.getLeft(), this.card.getUp(), this.card.getRight(), this.card.getDown());
            case 2 -> sidesRotated = List.of(this.card.getDown(), this.card.getLeft(), this.card.getUp(), this.card.getRight());
            case 3 -> sidesRotated = List.of(this.card.getRight(), this.card.getDown(), this.card.getLeft(), this.card.getUp());
        }
        return sidesRotated;
    }
}
