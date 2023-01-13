package org.harmony.endofline.gameInvite;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.multiplayer.Multiplayer;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "game_invite")
public class GameInvite extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    User sender;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    User receiver;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @NotNull
    Multiplayer game;

    @NotNull
    GameInviteStatus status;

    @NotNull
    InviteType type;

    public GameInvite(Multiplayer game, User sender, User receiver, InviteType type){
        this.game = game;
        this.sender = sender;
        this.receiver = receiver;
        this.status = GameInviteStatus.PENDING;
        this.type = type;
    }

    public GameInvite() {

    }

    public enum GameInviteStatus {
        PENDING,
        ACCEPTED,
        REJECTED;
    }
}
