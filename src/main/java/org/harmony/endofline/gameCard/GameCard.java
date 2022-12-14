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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Status status;

    @Min(0)
    private Integer x;

    @Min(0)
    private Integer y;

    @Min(0)
    @Max(3)
    private Integer rotation;

    public GameCard(Card card, User user, Status status, Integer x, Integer y, Integer rotation) {
        this.card = card;
        this.user = user;
        this.status = status;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public GameCard() {
    }

    public Map<String, List<Integer>> getExitPositions(Integer boardDimensions) {
        // Calculates the necessary entry position and coordinates for the next card based on the card's exits
        Map<String, List<Integer>> res = new HashMap<>();
        List<Side> sidesRotated = getRotatedSides(rotation);
        for(int i=0; i<sidesRotated.size(); i++){
            Side side = sidesRotated.get(i);
            if(side.equals(Side.EXIT)){
                switch (i){
                    case 0 -> res.put("down", List.of(x, (y-1+5)%boardDimensions));
                    case 1 -> res.put("left", List.of((x+1+5)%boardDimensions, y));
                    case 2 -> res.put("up", List.of(x, (y+1+5)%boardDimensions));
                    case 3 -> res.put("right", List.of((x-1+5)%boardDimensions, y));
                }
            }
        }
        return res;
    }

    public List<Side> getRotatedSides(Integer rotation) {
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
