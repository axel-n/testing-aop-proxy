package com.example.testing_aop_proxy.service;

import com.example.testing_aop_proxy.entity.Statistic;
import com.example.testing_aop_proxy.repository.StatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Slf4j
@Aspect
@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }


    @Pointcut("execution(public * com.example.testing_aop_proxy.controller.UserController.*(..))")
    public void monitor() {
    }

    @Around("monitor()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        long timeStart = System.currentTimeMillis();
        try {
            return jp.proceed();
        } finally {
            String packageName = jp.getSignature().getDeclaringTypeName();
            String methodName = jp.getSignature().getName();
            statisticRepository.save(getStatistic(packageName, methodName, timeStart));
        }

    }

    private Statistic getStatistic(String packageName, String method, long start) {
        return Statistic.builder()
                .packageName(packageName)
                .method(method)
                .duration(System.currentTimeMillis() - start)
                .created(System.currentTimeMillis())
                .build();
    }
}
