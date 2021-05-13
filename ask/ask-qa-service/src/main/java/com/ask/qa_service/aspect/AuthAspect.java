package com.ask.qa_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/13 12:24 AM
 */
@Component
@Aspect
@Slf4j
public class AuthAspect {

    @Pointcut("@annotation(com.ask.qa_service.common.Auth)")
    public void authCut() {
    }

    @Around("authCut()")
    public Object before(ProceedingJoinPoint point) {
        boolean checkResult = checkRole();
        log.info("权限校验结果: {}", checkResult);
        return null;
    }

    private boolean checkRole() {
        return true;
    }
}
