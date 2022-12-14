package org.harmony.endofline.gameCard;

import org.harmony.endofline.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GameCardService {

    @Autowired
    GameCardRepository gameCardRepository;

    public GameCard newCard(GameCard newCard){
        return gameCardRepository.save(newCard);
    }

    @Transactional
    public void moveCard(Integer id, Integer new_x, Integer new_y, Integer new_r){

        if (gameCardRepository.findById(id).isPresent()) {
            GameCard newCard = gameCardRepository.findById(id).get();
            newCard.setX(new_x);
            newCard.setY(new_y);
            newCard.setRotation(new_r);
            gameCardRepository.save(newCard);
        }
    }
}
