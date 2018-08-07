/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Administrator
 * @version $Id: HandlerInterceptor2.java, v 0.1 2017年3月14日 上午10:45:40 Administrator Exp $
 */
public class HandlerInterceptor1 extends HandlerInterceptorAdapter {

    //此处一般继承HandlerInterceptorAdapter适配器即可  
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("===========HandlerInterceptor1 preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========HandlerInterceptor1 postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("===========HandlerInterceptor1 afterCompletion");
    }

}
