package org.springframework.samples.endofline.card;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.endofline.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Simple JavaBean domain object representing an card.
 *
 * @author Juan Pedro Gálvez
 */
@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    @Column(name = "inititative")
    @NotEmpty
    private Integer initiative;

    @Column(name = "up")
    @NotEmpty
    private Side up;

    @Column(name = "down")
    @NotEmpty
    private Side down;

    @Column(name = "left")
    @NotEmpty
    private Side left;

    @Column(name = "right")
    @NotEmpty
    private Side right;

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("new", this.isNew())
                .append("initiative", this.initiative)
                .append("up", this.up)
                .append("down", this.down)
                .append("left", this.left)
                .append("right", this.right)
                .toString();
    }
}
