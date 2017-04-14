package com.huoli.checkin.design.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: Alec
 * Date: 13-3-15
 * Time: 下午2:21
 * To change this template use File | Settings | File Templates.
 */
public class RenderInterceptor implements HandlerInterceptor {

//    @Autowired
//    private CategoryService categoryService;
//
//    @Autowired
//    private TagService tagService;
//
//    @Autowired
//    private MenuQueryService menuQueryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object target = handlerMethod.getBean();

            Token token= handlerMethod.getMethodAnnotation(Token.class);
            if(token != null ){
                this.generateFormToken(request);
            }

            CheckFormToken checkFormToken = handlerMethod.getMethodAnnotation(CheckFormToken.class);
            if (checkFormToken != null) {
                if (!checkFormToken(request)) {
                    throw new DuplicateSubmitFormException("表单重复提交!");
                } else {
                    generateFormToken(request);
                }
            }

            if (target.getClass().isAnnotationPresent(RSidebar.class)) {
                pageAddRightSidebar(request);
            }

        }
        return true;
    }

    @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


    private boolean checkFormToken(HttpServletRequest request) {
        String token = request.getParameter(SessionConstants.TOKEN);
        HttpSession session = request.getSession();
        String oldToken = (String) session.getAttribute(SessionConstants.TOKEN);
        return token.equals(oldToken);
    }

    private void generateFormToken(HttpServletRequest request) {
//        String sessionId = request.getSession().getId();
//        String hashString = MD5.getHashString(System.currentTimeMillis() + sessionId);
//        request.getSession().setAttribute(SessionConstants.TOKEN, hashString);
    }


    /**
     * 页面右侧栏
     *
     * @return
     */
    private void pageAddRightSidebar(HttpServletRequest request) {
//        //加入顶级类目
//        List<Category> categoryBanner = categoryService.querySubCategories(0);
//        request.setAttribute("categoryBanner", categoryBanner);
//
//        //加入标签
//        List<Tag> tags = tagService.queryAllTag();
//        request.setAttribute("tags", tags);
//
//        //加入一周推荐
//        List<Menu> menuRecommend = menuQueryService.queryMenuRecommendList();
//        request.setAttribute("menuRecommend", getMenuListWithMainPicture(menuRecommend));
    }

}