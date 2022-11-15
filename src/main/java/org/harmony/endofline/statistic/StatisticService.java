package org.harmony.endofline.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;

    @Transactional
    public Statistic createStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

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

    public Iterable<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    public Statistic getStatisticByUserId(int userId) {
        return statisticRepository.findByUserId(userId);
    }

}
