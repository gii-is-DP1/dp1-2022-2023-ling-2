package org.harmony.endofline.card;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Spring Data JPA CardRepository interface
 *
 * @author Juan Pedro Gálvez
 */
public interface CardRepository extends Repository<Card, Integer> {

    Collection<Card> findAll() throws DataAccessException;


    /**
     * Retrieve a <code>Card</code> from the data store by id.
     * @param id the id to search for
     * @return the <code>Card</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    @Query("SELECT card FROM Card card WHERE card.id =:id")
    Card findById(@Param("id") int id);
}
