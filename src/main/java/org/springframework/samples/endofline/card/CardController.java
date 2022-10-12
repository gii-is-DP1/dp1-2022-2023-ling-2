package org.springframework.samples.endofline.card;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Map;

/**
 * @author Juan Pedro Gálvez
 */
@Controller
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = { "/cards" })
    public String showCardList(Map<String, Object> model) {
        model.put("cards", cardService.findCards());
        return "cards/cardList";
    }
}
