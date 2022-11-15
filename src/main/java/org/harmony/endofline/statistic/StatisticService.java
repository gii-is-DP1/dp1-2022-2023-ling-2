package org.harmony.endofline.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;

    @Transactional
    public Statistic updateStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    @Transactional
    public void deleteStatistic(Statistic statistic) {
        statisticRepository.delete(statistic);
    }

    public Optional<Statistic> getStatistic(int id) {
        return statisticRepository.findById(id);
    }

    public List<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    public Statistic getStatisticByUserId(int userId) {
        return statisticRepository.findByUserId(userId);
    }

    public List<Statistic> getLeaderBoardSingleWins() {
        List<Statistic> allStatistics = getAllStatistics();
        allStatistics.sort((s1, s2) -> s2.getNumberSinglePlayerWins() - s1.getNumberSinglePlayerWins());
        return allStatistics;
    }

    public List<Statistic> getLeaderBoardMultiWins() {
        List<Statistic> allStatistics = getAllStatistics();
        allStatistics.sort((s1, s2) -> s2.getNumberMultiPlayerWins() - s1.getNumberMultiPlayerWins());
        return allStatistics;
    }
}
