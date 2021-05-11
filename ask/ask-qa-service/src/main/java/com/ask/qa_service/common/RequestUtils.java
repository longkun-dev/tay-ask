package com.ask.qa_service.common;

import com.ask.qa_service.dao.AskUserDao;
import com.ask.qa_service.entity.po.AskUserPo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/1 12:00 AM
 */
@Service
public class RequestUtils {

    @Autowired
    private static AskUserDao userDao;

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        return servletRequestAttributes.getResponse();
    }

    public static String getCurrentUserId() {
        HttpServletRequest request = getRequest();
        return request.getHeader("userId");
    }

    public static String getCurrentUserRole() {
        String userId = getCurrentUserId();
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        AskUserPo userPo = userDao.queryByUserId(userId);
        if (userPo == null) {
            return null;
        }
        return userPo.getRole();
    }
}
