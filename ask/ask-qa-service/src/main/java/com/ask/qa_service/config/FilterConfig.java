package com.ask.qa_service.config;

import com.ask.qa_service.common.RequestUtils;
import lombok.extern.slf4j.Slf4j;
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
public class FilterConfig implements Filter {
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
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        HttpServletRequest request = RequestUtils.getRequest();
        String requestURI = request.getRequestURI();
        log.info("请求 {} 耗时 {} 秒", requestURI, (endTime - startTime) / 1000.0);
    }
}
