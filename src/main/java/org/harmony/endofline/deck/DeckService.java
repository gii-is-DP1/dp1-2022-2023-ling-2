package org.harmony.endofline.deck;

import org.harmony.endofline.card.Card;
import org.harmony.endofline.deckCard.DeckCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckService {
    private final DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Deck findByID(Integer id) {
        return deckRepository.findById(id).orElse(null);
    }
    public List<Card> getDeckCards(Deck deck) {
        return deck.getDeckCards().stream().flatMap(DeckCard::getCards).toList();
    }
}
