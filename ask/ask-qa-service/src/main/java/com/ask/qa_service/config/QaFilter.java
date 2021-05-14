package com.ask.qa_service.config;

import com.ask.qa_service.common.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
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
                                FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        // 鉴权
        HttpServletRequest request = RequestUtils.getRequest();
        String cookie = request.getHeader("Cookie");
        if (!StringUtils.isEmpty(cookie)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = RequestUtils.getResponse();
            response.setStatus(302);
            response.sendRedirect("/login");
        }
        long endTime = System.currentTimeMillis();
        String requestURI = request.getRequestURI();
        log.info("请求 {} 耗时 {} 秒", requestURI, (endTime - startTime) / 1000.0);
    }
}
