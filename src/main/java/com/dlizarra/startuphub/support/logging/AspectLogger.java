package com.dlizarra.startuphub.support.logging;

import com.google.common.base.Joiner;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AspectLogger {

    private static final Logger log = LoggerFactory.getLogger(AspectLogger.class);
    private final Joiner commaJoiner = Joiner.on(",");

    @Before("allServiceMethodsPointcut()")
    public void logServiceBefore (JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder();
        message.append("--> ");
        message.append(joinPoint.getTarget().getClass().getSimpleName());
        message.append(".");
        message.append(joinPoint.getSignature().getName());
        message.append("(");
        message.append(commaJoiner.join(joinPoint.getArgs()));
        message.append(")");

        //log.debug(message.toString());
    }


    @Around("allServiceMethodsPointcut()")
    public Object logServiceAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object retVal = joinPoint.proceed();

        stopWatch.stop();

        StringBuilder message = new StringBuilder();
        message.append("<-- ");
        message.append(joinPoint.getTarget().getClass().getSimpleName());
        message.append(".");
        message.append(joinPoint.getSignature().getName());
        message.append("(");
        message.append(commaJoiner.join(joinPoint.getArgs()));
        message.append(")");
        message.append(" executed in ");
        message.append(stopWatch.getTotalTimeMillis());
        message.append(" ms");

        //log.debug(message.toString());

        return retVal;
    }

    @Pointcut("execution(* com.dlizarra..*Service.*(..))")
    public void allServiceMethodsPointcut () {}


}
