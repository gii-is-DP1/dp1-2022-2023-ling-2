package org.harmony.endofline.deck;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.deckCard.DeckCard;
import org.harmony.endofline.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Deck extends BaseEntity {
    @OneToMany(cascade=CascadeType.ALL, mappedBy="deck")
    private List<DeckCard> deckCards;
}
