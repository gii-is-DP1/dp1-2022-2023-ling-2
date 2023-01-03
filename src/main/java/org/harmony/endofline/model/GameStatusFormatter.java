package org.harmony.endofline.model;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

@Component
public abstract class GameStatusFormatter implements Formatter<GameStatus> {

    @Override
    public String print(GameStatus gameStatus, Locale locale) {
        switch (gameStatus){
            case CREATED -> {
                return "Created";
            }
            case STARTED -> {
                return "Started";
            }
            case FINISHED -> {
                return "Finished";
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public GameStatus parse(String text, Locale locale) throws ParseException {
        Collection<GameStatus> findPetTypes = Arrays.stream(GameStatus.values()).toList();
        for (GameStatus status : findPetTypes) {
            if (status.toString().equals(text)) {
                return status;
            }
        }
        throw new ParseException("status not found: " + text, 0);
    }

}
