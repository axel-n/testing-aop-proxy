package com.example.testing_aop_proxy.service

import com.example.testing_aop_proxy.entity.Statistic
import com.example.testing_aop_proxy.repository.StatisticRepository

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Service

@Aspect
@Service
class StatisticService(private val statisticRepository: StatisticRepository) {
    @Pointcut("execution(public * com.example.testing_aop_proxy.controller.UserController.*(..))")
    fun monitor() {
    }

    @Around("monitor()")
    fun around(jp: ProceedingJoinPoint): Any {
        val timeStart = System.currentTimeMillis()
        return try {
            jp.proceed()
        } finally {
            val packageName = jp.signature.declaringTypeName
            val methodName = jp.signature.name
            statisticRepository.save(getStatistic(packageName, methodName, timeStart))
        }
    }

    private fun getStatistic(packageName: String, method: String, start: Long): Statistic =
            Statistic(
                    packageName = packageName,
                    method = method,
                    duration = System.currentTimeMillis() - start,
                    created = System.currentTimeMillis(),
            )
}