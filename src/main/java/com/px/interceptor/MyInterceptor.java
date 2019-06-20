package com.px.interceptor;/* *
 * @ Author: LJH
 * @ Date: 2019/6/16 18:51
 */

import com.px.entity.Horseman;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截  骑士是否登录
 *
 *   分析一下拦截器:   自定义拦截器 只需要实现 HandlerInterceptor 接口
 *       该接口提供三个方法:
 *            1、preHandle()    在我们自定义的 Handler处理器之前拦截
 *
 *            2、postHandle()   Handler处理后、视图渲染前进行拦截
 *
 *            3、afterCompletion()  在处理jsp渲染过后进行拦截
 *
 *
 *  有两个注意事项:
 *       1、 通过ajax请求的方法，在自定义的HandlerInterceptor中，请求重定向没有用!
 *                 我们可以通过查看 请求头信息中是否存在： x-requested-with  信息; 如果有，则是ajax请求
 *
 *       2、 通过自定义的HandlerInterceptor 拦截器，然后通过response返回的json数据，
 *
 *           如果是自己手写的json字符串的话，里面的属性，值都不必须使用双引号引起来，如果使用单引号，会跳转到前端error的回调函数中去
 *           如果使用双引号，就跳转到success的回调函数中去!
 *
 *
 *
 *
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        // request.getServletPath()  获取请求路径
        String url = httpServletRequest.getServletPath();
        System.out.println("post URL："+url);
        if(!url.equals("")) {
            //判断骑手是否登录
            String horsemanuname = (String) httpServletRequest.getSession().getAttribute("horsemanuname");
            if(horsemanuname==null){
                System.out.println("请骑手登录");
                httpServletResponse.setContentType("application/json;charset=utf8");
                /**
                 *  注意:
                 *    在前端使用  JSON.prase();  方法将  json字符串转换成json对象时，
                 *       json字符串中的属性不能使用  单引号
                 *
                 *
                 */
                String jsonMsg = "{\"msg\":\"请先登录\"}";

                PrintWriter writer = httpServletResponse.getWriter();
                writer.write(jsonMsg);
                writer.close();
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
