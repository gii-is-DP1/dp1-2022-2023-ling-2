package org.harmony.endofline.statistic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatisticRepository extends CrudRepository<Statistic, Integer> {

    @Query("SELECT stat FROM Statistic stat WHERE stat.user.id =:userId")
    Statistic findByUserId(@Param("userId") int userId);

    @Query("SELECT stat FROM Statistic stat")
    List<Statistic> findAll();

}
