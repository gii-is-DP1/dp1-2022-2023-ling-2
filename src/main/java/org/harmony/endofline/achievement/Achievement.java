package org.harmony.endofline.achievement;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


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

    @ManyToMany(mappedBy = "achievements")
    List<User> users;

    public enum condits{
        MULTIPLAYER_WINS,
        SINGLEPLAYER_WINS,
        MULTIPLAYER_AMOUNT,
        SINGLEPLAYER_AMOUNT,
        MULTIPLAYER_CREATED,

    }
}

