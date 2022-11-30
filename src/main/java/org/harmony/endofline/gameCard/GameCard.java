package org.harmony.endofline.gameCard;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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




}
