package com.myboot.cmms.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);
    @Value("${filter.sessionFilter}")
    private String exUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        logger.info("sessionFilter  uri:{}", uri);
        if (isNotSessionFilter(uri)) {//不需要session检查
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (session != null) {//需要session检查
                logger.info("sessionId为:{}", session.getId());        // 获取用户信息，如果没有用户信息直接返回提示信息
                Object userInfo = session.getAttribute("userInfo");
                if (userInfo == null) {
                    logger.info("登录过期");
                    response.setStatus(401);
                    return;
                } else {
                    //只要有请求，就重新设置过期时间
                    session.setMaxInactiveInterval(30 * 60);//设置过期时间，以秒为单位
                    logger.info("已经登录过啦，用户信息为:{}", session.getAttribute("userInfo"));
                    filterChain.doFilter(request, response);
                }
            } else {
                response.setStatus(401);
                return;
            }
        }
    }


    @Override
    public void destroy() {

    }

    /**
     * 判断是否不需要此检查session过滤
     *
     * @param uri
     * @return
     */
    private boolean isNotSessionFilter(String uri) {
        String[] excludUrls = exUrls.split(",");
        for (String excludUrl : excludUrls) {
            if (excludUrl.equals(uri)) {
                return true;
            }
        }
        return false;
    }


}
