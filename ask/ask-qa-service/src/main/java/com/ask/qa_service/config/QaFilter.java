package com.ask.qa_service.config;

import com.ask.qa_service.common.RequestUtils;
import com.ask.qa_service.exception.AskException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/13 12:04 AM
 */
@Component
@Slf4j
public class QaFilter implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {

    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) {
        logRequestTime(servletRequest, servletResponse, filterChain);
    }

    @Override
    public void destroy() {

    }

    /**
     * 记录每次请求的处理时间
     *
     * @param servletRequest  request
     * @param servletResponse response
     * @param filterChain     chain
     * @throws IOException      IO异常
     * @throws ServletException Servlet异常
     */
    private void logRequestTime(ServletRequest servletRequest, ServletResponse servletResponse,
                                FilterChain filterChain) throws IOException, ServletException, AskException {
        long startTime = System.currentTimeMillis();

        // 鉴权
        HttpServletRequest request = RequestUtils.getRequest();
        String cookie = request.getHeader("Cookie");
        if (StringUtils.isNotEmpty(cookie) || "/auth/login".equals(request.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            long endTime = System.currentTimeMillis();
            String requestURI = request.getRequestURI();
            log.info("请求 {} 耗时 {} 秒", requestURI, (endTime - startTime) / 1000.0);
        } else {
            throw new AskException("登录信息已过期，请重新登录");
        }
    }
}
