package org.harmony.endofline.puzzle;

import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PuzzleRepository extends CrudRepository<Puzzle, Integer> {

    @Query("SELECT pz FROM PuzzleCards pz JOIN pz.puzzle p WHERE p.id=:id")
    List<PuzzleCards> findCardsOfPuzzle(Integer id);

}
