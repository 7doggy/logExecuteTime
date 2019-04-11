package com.lichun.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LogTimeInterceptor {

    @Pointcut("@annotation(com.lichun.annotation.LogExecuteTime)")
    public void logTimeMethodPointcut() {

    }

    @Around("logTimeMethodPointcut()")
    public Object interceptor(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        log.info(pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName() + " spend "
                + (System.currentTimeMillis() - startTime) + "ms");
        return result;
    }
}
