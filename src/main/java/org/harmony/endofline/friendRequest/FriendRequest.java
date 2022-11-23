package org.harmony.endofline.friendRequest;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;
import org.harmony.endofline.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "friend_requests")
public class FriendRequest extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    User sender;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    User receiver;

    @NotNull
    Boolean pending;

    @NotNull
    Boolean accepted;

    public FriendRequest(User sender, User receiver){
        this.sender = sender;
        this.receiver = receiver;
        this.pending = true;
        this.accepted = false;
    }

}
