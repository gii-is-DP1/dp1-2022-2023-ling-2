package org.harmony.endofline.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT user FROM User user WHERE user.username=:username")
    User findByUsername(@Param("username") String username);
}
