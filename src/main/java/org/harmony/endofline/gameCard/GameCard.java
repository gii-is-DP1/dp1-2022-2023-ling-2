package org.harmony.endofline.gameCard;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    private Integer x;

    private Integer y;

    private Integer rotation;

    private Boolean inHand;




}
