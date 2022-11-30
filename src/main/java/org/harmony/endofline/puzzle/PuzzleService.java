package org.harmony.endofline.puzzle;

import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuzzleService {
    @Autowired
    private PuzzleRepository puzzleRepository;

    public List<PuzzleCards> getPuzzleCards(Integer id){
        return puzzleRepository.findCardsOfPuzzle(id);
    }

}
