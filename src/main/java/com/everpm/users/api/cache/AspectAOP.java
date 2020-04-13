package com.everpm.users.api.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAOP {

    @Around("@annotation(customCache)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, CustomCache customCache) throws Throwable {
        System.out.println("===executing the apo method ");

//        System.out.println(Arrays.toString(joinPoint.getArgs()));

        UserParam userParam = (UserParam) joinPoint.getArgs()[0];
        System.out.println(userParam);

        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("[ manager  " + customCache.cacheManager());
        System.out.println("[ is enabled ]" + customCache.isCacheEnabled());

        System.out.printf("%s executed in %sms %s",
                joinPoint.getSignature(), executionTime, System.lineSeparator());

        return proceed;
    }
}