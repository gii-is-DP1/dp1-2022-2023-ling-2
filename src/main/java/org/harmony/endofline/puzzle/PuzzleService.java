package org.harmony.endofline.puzzle;

import org.harmony.endofline.puzzleCards.PuzzleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PuzzleService {
    @Autowired
    private PuzzleRepository puzzleRepository;
    private Random random = new Random();

    public List<PuzzleCards> getPuzzleCards(Integer id){
        return puzzleRepository.findCardsOfPuzzle(id);
    }

    public Puzzle randomByDifficulty(Difficulty difficulty){
        var all = puzzleRepository.findByDifficulty(difficulty);
        return all.get(random.nextInt(all.size()));
    }

}
