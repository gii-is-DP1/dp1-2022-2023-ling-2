package org.harmony.endofline.user;

import lombok.Getter;
import lombok.Setter;
import org.harmony.endofline.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    String username;
    String password;
    String email;
    Boolean isAdmin;
    String image;
    Boolean enabled;
}