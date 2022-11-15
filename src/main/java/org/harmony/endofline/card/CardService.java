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

    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Collection<Card> findCards() throws DataAccessException {
        return cardRepository.findAll();
    }

    @Transactional
    public Card findCardById(int id) {
        return cardRepository.findById(id);
    }

    @Transactional
    public void saveCard(Card card) throws DataAccessException {
        cardRepository.save(card);
    }

    @Transactional
    public void deleteCard(Card card) throws DataAccessException {
        cardRepository.delete(card);
    }

    @Transactional
    public void deleteCardById(int id) throws DataAccessException {
        cardRepository.deleteById(id);
    }


}
