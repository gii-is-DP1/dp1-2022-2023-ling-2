package org.harmony.endofline.stat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StatService {
    @Autowired
    private StatRepository statRepository;

    @Transactional
    public Stat createStat(Stat stat) {
        return statRepository.save(stat);
    }

    @Transactional
    public Stat updateStat(Stat stat) {
        return statRepository.save(stat);
    }

    @Transactional
    public void deleteStat(Stat stat) {
        statRepository.delete(stat);
    }

    public Optional<Stat> getStat(int id) {
        return statRepository.findById(id);
    }

    public Iterable<Stat> getAllStats() {
        return statRepository.findAll();
    }

    public Stat getStatByUserId(int userId) {
        return statRepository.findByUserId(userId);
    }


}
