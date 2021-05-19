package com.ask.qa_service.common;

import com.ask.qa_service.constant.Constant;
import com.ask.qa_service.dao.AskUserDao;
import com.ask.qa_service.entity.po.AskUserPo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
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
        String currentUserId = null;
        HttpServletRequest request = getRequest();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (Constant.COOKIE_USER_ID.equals(cookie.getName())) {
                currentUserId = cookie.getValue();
            }
        }
        return currentUserId;
    }

    public static String getCurrentUserRole() {
        String currentUserId = getCurrentUserId();
        if (StringUtils.isEmpty(currentUserId)) {
            return null;
        }
        AskUserPo userPo = userDao.queryByUserId(currentUserId);
        if (userPo == null || StringUtils.isEmpty(userPo.getRole())) {
            return null;
        }
        return userPo.getRole();
    }
}
