package org.harmony.endofline.achievement;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.NamedEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Table(name = "achievements")
@Entity
public class Achievement extends NamedEntity {



    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;


    @NotNull
    @Column(name = "condition")
    private condits conditions;

    @NotNull
    @Column(name = "condition_amount")
    @Min(value=1)
    private Integer conditionAmounts;

    @JoinTable(name = "achievement_user",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    @ManyToMany
    List<User> users;

    public enum condits{
        MUlTIPLAYER_WINS,
        SINGLEPLAYER_WINS,
        MULTIPLAYER_AMOUNT,
        SINGLEPLAYER_AMOUNT,
        MULTIPLAYER_CREATED,
        SINGLEPLAYER_CREATED
    }
}

