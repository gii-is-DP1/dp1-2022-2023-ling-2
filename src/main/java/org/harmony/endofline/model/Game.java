package org.harmony.endofline.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Game extends BaseEntity {

    @Column(name = "date_started")
    @NotNull
    private LocalDateTime dateStarted;

    @Column(name = "date_ended")
    private LocalDateTime dateEnded;

    private String result;

    public Game(LocalDateTime dateStarted){
        this.dateStarted = dateStarted;
        this.dateEnded = null;
        this.result = null;
    }

}
