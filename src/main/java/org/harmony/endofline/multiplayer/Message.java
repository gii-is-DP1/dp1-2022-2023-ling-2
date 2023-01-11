package org.harmony.endofline.multiplayer;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "messages")
public class Message extends BaseEntity {

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Multiplayer game;

    @NotNull
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @NotNull
    @Size(min = 1)
    private String content;

}
