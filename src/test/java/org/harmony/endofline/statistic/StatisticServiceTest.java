package org.harmony.endofline.statistic;

import org.harmony.endofline.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class StatisticServiceTest {

    @Autowired
    private StatisticService statisticService;


    @Test
    void deleteStatistic() {
        List<Statistic> statistics = statisticService.getAllStatistics();
        Statistic statisticToDelete = statistics.get(0);
        int id = statisticToDelete.getId();
        statisticService.deleteStatistic(statisticToDelete);
        assertFalse(statisticService.getStatistic(id).isPresent());
    }

    @Test
    void getAllStatistics() {
        assertEquals(2, statisticService.getAllStatistics().size());
    }

    @Test
    void getStatisticByUserId() {
        int userId = 1;
        Statistic statistic = statisticService.getStatisticByUserId(userId);
        assertEquals(userId, statistic.getUser().getId());
    }

    @Test
    void getLeaderBoardSingleWins() {
        List<Statistic> stats = statisticService.getLeaderBoardSingleWins();
        assertTrue(stats.get(0).getNumberSinglePlayerWins() >= stats.get(1).getNumberSinglePlayerWins());
    }

    @Test
    void getLeaderBoardMultiWins() {
        List<Statistic> stats = statisticService.getLeaderBoardSingleWins();
        assertTrue(stats.get(0).getNumberMultiPlayerWins()>= stats.get(1).getNumberMultiPlayerWins());
    }
}
