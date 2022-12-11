package com.example.demo.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
//tn.esprit.kaddem.service.ContatServiceImpl.*(..))
    @Before(" execution(* com.example.demo.Service.*.*(..)) ")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");

    }
    //tn.esprit.kaddem.service.ContatServiceImpl.*(..))
    @After(" execution(* com.example.demo.Service.*.*(..))  ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info(" Out of method " + name + " : ");
    }
/*
    @Around("execution(* com.example.demo.Service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime
                +"milliseconds.");
        return obj;
    }*/
}
