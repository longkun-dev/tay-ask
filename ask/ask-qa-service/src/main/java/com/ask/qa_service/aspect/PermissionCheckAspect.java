package com.ask.qa_service.aspect;

import com.ask.qa_service.common.PermissionCheck;
import com.ask.qa_service.common.RequestUtils;
import com.ask.qa_service.constant.RoleEnum;
import com.ask.qa_service.exception.AskException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/13 12:24 AM
 */
@Component
@Aspect
@Slf4j
public class PermissionCheckAspect {

    @Pointcut("@annotation(com.ask.qa_service.common.PermissionCheck)")
    public void permissionCheckCut() {
    }

    @Around("permissionCheckCut()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        // 1.记录日志信息
        Signature signature = point.getSignature();
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = signature.getName();
        log.info("className: {}, methodName: {}", className, methodName);

        // 2.权限校验
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        if (!targetMethod.isAnnotationPresent(PermissionCheck.class)) {
            throw new AskException("接口未配置访问权限");
        }

        PermissionCheck permissionCheck = targetMethod.getAnnotation(PermissionCheck.class);
        RoleEnum[] rolesEnum = permissionCheck.roles();
        String[] roles = new String[rolesEnum.length];

        for (int i = 0; i < rolesEnum.length; i++) {
            roles[i] = rolesEnum[i].getRoleCode();
        }

        if (ArrayUtils.isEmpty(roles)) {
            throw new AskException("接口访问角色不能配置为空");
        }

        List<String> roleList = Arrays.asList(roles);
        HttpServletRequest request = RequestUtils.getRequest();
        String userRoles = request.getHeader("roles");
        List<String> userRoleList = new ArrayList<>();
        // 访问接口所需权限和用户权限的交集
        List<String> interRoles = ListUtils.retainAll(roleList, userRoleList);
//        if (CollectionUtils.isEmpty(interRoles)) {
//            throw new AskException("无接口访问权限");
//        }

        return point.proceed();
    }
}
