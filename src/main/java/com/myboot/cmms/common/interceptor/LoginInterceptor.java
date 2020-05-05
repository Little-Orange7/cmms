package com.myboot.cmms.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        logger.info("sessionId为：" + session.getId());        // 获取用户信息，如果没有用户信息直接返回提示信息
        Object userInfo = session.getAttribute("userInfo");
        /*if (userInfo == null) {
            logger.info("登录过期");
            response.setStatus(401);
            return false;
        } else {
            //只要有请求，就重新设置过期时间
            session.setMaxInactiveInterval(30*60);//设置过期时间，以秒为单位
            logger.info("已经登录过啦，用户信息为：" + session.getAttribute("userInfo"));
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
