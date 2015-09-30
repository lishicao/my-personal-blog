package com.blog.web.interceptor;

import com.blog.common.util.WebConfigure;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * user: lishicao
 * date 15/9/27
 * time 下午11:06
 */
public class loginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        HttpSession session = request.getSession();
        if( session.getAttribute("username") == null ) {
            String url = WebConfigure.webSite ;
            response.sendRedirect( url+"/toLogin" );
            return false;
        }
        else return true;
    }

    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception{

    }

    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception{

    }
}
