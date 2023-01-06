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

    public Card getInitialCard() throws DataAccessException {
        return cardRepository.findById(1);
    }

}
