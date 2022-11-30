package org.harmony.endofline.singleplayer;

import org.harmony.endofline.gameCard.GameCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SingleplayerService {

    @Autowired
    private SingleplayerRepository singleplayerRepository;

    @Transactional
    public void save(Singleplayer game) {
        singleplayerRepository.save(game);
    }

    public List<Singleplayer> getAllGamesWithUser() {
        return singleplayerRepository.findAll();
    }

    public Singleplayer findByID(Integer id) throws InvalidIDException {
        Optional<Singleplayer> opt =  singleplayerRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }else{
            throw new InvalidIDException();
        }
    }

    public List<GameCard> getAllCardsInGame(Integer id){
        return singleplayerRepository.FindAllGameCards(id).stream().filter(c -> !c.getInHand()).toList();
    }
    public List<GameCard> getAllCardsInHand(Integer id){
        var a = singleplayerRepository.FindAllGameCards(id).stream().filter(c -> c.getInHand()).toList();
        return a;
    }
}
