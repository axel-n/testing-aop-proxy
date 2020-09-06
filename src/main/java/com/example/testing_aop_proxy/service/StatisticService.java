package com.example.testing_aop_proxy.service;

import com.example.testing_aop_proxy.entity.Statistic;
import com.example.testing_aop_proxy.repository.StatisticRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public void save(Statistic statistic) {
        statisticRepository.save(statistic);
    }
}
