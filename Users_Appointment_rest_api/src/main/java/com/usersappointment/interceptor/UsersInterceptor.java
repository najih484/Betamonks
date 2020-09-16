package com.usersappointment.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UsersInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UsersInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        logger.info("pre-handle");

        boolean flag = true;

        String method = httpServletRequest.getMethod();

        if(method.equalsIgnoreCase("post")||method.equalsIgnoreCase("put")) {
            if (StringUtils.isEmpty(httpServletRequest.getHeader("authentication"))) {
                flag = false;
            }
        }

        if(!flag){
            httpServletResponse.sendRedirect("/api/invalid");
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("post-handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("after-completion");
    }
}


