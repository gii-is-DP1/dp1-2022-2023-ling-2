package org.harmony.endofline.gameInvite;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.user.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name="game_invite")
public class GameInvite extends BaseEntity {

    @CreationTimestamp
    private LocalDateTime timeSent;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToOne
    private Multiplayer game;


    private String message;
}
