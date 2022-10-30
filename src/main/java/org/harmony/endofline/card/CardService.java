package org.harmony.endofline.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @author Juan Pedro Gálvez
 */
@Service
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional
    public Collection<Card> findCards() throws DataAccessException {
        return cardRepository.findAll();
    }

    @Transactional
    public Card findCardById(int id) {
        return cardRepository.findById(id);
    }
}
