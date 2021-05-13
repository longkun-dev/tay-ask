package com.ask.qa_service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/13 12:20 AM
 */
@Aspect
@Component
public class SystemLogAspect {

    @Pointcut("@annotation(com.ask.qa_service.common.SystemLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
//            saveLog(point, time);
        } catch (Exception e) {
        }
        return result;
    }
}
