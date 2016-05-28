package com.dlizarra.startuphub.support.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {

    private static final Logger log = LoggerFactory.getLogger(AspectLogger.class);

    @Before("allServiceMethodsPointcut()")
    public void logServiceBefore (JoinPoint joinpoint) {
        log.debug("--> " + joinpoint.getSignature());
    }

    @AfterReturning("allServiceMethodsPointcut()")
    public void logServiceAfter (JoinPoint joinpoint) {
        log.debug("<-- " + joinpoint.getSignature());
    }

    @Pointcut("execution(* com.dlizarra..*Service.*(..))")
    public void allServiceMethodsPointcut () {}

}
