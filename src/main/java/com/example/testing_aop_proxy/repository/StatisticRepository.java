package com.example.testing_aop_proxy.repository;

import com.example.testing_aop_proxy.entity.Statistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
}
