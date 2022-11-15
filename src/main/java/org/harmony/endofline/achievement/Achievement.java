package org.harmony.endofline.achievement;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.model.NamedEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Table(name = "achievements")
@Entity
public class Achievement extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", unique = true)
    private String name;

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
        MULTIPLAYER_WINS,
        SINGLEPLAYER_WINS,
        MULTIPLAYER_AMOUNT,
        SINGLEPLAYER_AMOUNT,
        MULTIPLAYER_CREATED,
        SINGLEPLAYER_CREATED
    }
}

