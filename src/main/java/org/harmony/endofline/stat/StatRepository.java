package org.harmony.endofline.stat;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StatRepository extends CrudRepository<Stat, Integer> {

    @Query("SELECT stat FROM Stat stat WHERE stat.user.id =:userId")
    Stat findByUserId(@Param("userId") int userId);

}
