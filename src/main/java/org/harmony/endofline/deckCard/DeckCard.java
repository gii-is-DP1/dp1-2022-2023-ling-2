package org.harmony.endofline.deckCard;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.card.Card;
import org.harmony.endofline.deck.Deck;
import org.harmony.endofline.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.stream.Stream;

@Entity
@Getter
@Setter
@Table(name = "deck_card")
public class DeckCard extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "deck_id")
    private Deck deck;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    private Integer quantity;

    public Stream<Card> getCards() {
        return Stream.generate(() -> card).limit(quantity);
    }
}
