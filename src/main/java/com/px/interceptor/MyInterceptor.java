package com.px.interceptor;/* *
 * @ Author: LJH
 * @ Date: 2019/6/16 18:51
 */

import com.px.entity.Horseman;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getServletPath();
        System.out.println("post URL："+url);
        if(!url.equals("")) {
            //判断骑手是否登录
            Horseman horsemanuname = (Horseman) httpServletRequest.getSession().getAttribute("horsemanuname");
            if(horsemanuname==null){
                System.out.println("骑手请登录");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截响应");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("视图(jsp)被渲染完毕");
    }
}
