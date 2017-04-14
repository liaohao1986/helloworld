package com.huoli.checkin.design.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 表单提交重复提交异常 页面
 * User: Alec
 * Date: 13-3-15
 * Time: 下午2:52
 */
public class SnsExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(SnsExceptionResolver.class);

    private String pagePath = "error/default";

    private boolean developModel = false;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("发生一个系统异常", ex);
        ModelAndView modelAndView = new ModelAndView();
        //这里是在发文章的时候
        if (ex instanceof DuplicateSubmitFormException) {
            modelAndView.setViewName("addArticle");
        } else {
//            modelAndView.addObject("msg", ExceptionUtils.getFullStackTrace(ex));
            modelAndView.addObject("developModel", developModel);
            modelAndView.setViewName(pagePath);
        }

        return modelAndView;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public boolean isDevelopModel() {
        return developModel;
    }

    public void setDevelopModel(boolean developModel) {
        this.developModel = developModel;
    }
}