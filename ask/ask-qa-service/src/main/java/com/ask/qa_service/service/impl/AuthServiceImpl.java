package com.ask.qa_service.service.impl;

import com.ask.qa_service.common.RequestUtils;
import com.ask.qa_service.dao.AskUserDao;
import com.ask.qa_service.entity.po.AskUserPo;
import com.ask.qa_service.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/9 4:27 PM
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Resource
    private AskUserDao userDao;

    @Override
    public String login(AskUserPo userPo) {
        String errorMsg = "登录失败，";
        if (Objects.isNull(userPo) || StringUtils.isEmpty(userPo.getUserId())
                || StringUtils.isEmpty(userPo.getPassword())) {
            return errorMsg + "用户名和密码不能为空";
        }

        String userId = userPo.getUserId();
        String password = userPo.getPassword();
        AskUserPo askUserPo = userDao.queryByUserId(userId);
        if (askUserPo == null || !StringUtils.equals(askUserPo.getPassword(), password)) {
            return errorMsg + "用户名或密码错误";
        }

        HttpServletRequest request = RequestUtils.getRequest();
        String cookieInfo = request.getHeader("Cookie");
        if (StringUtils.isEmpty(cookieInfo) || !cookieInfo.contains("askCookie")) {
            Cookie cookie = new Cookie("askCookie", "userId=" + userId
                    + "&role=" + askUserPo.getRole());
            cookie.setPath("/");
            HttpServletResponse response = RequestUtils.getResponse();
            response.addCookie(cookie);
        } else {
            // 更新cookie失效时间
            log.info("Cookie为: {}, 已更新cookie过期时间", cookieInfo);
        }

        return "登录成功";
    }
}
