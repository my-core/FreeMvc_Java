package com.myspringmvc.interceptor;

import com.myspringmvc.common.Utils;
import com.mysql.cj.x.json.JsonArray;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangliangbin on 2016/9/7.
 * 全局请求拦截器
 */
public class AllInterceptor extends HandlerInterceptorAdapter {

    //不开启控制台日志输出
    private boolean IsOpenLog = false;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //控制台日志(方便验证拦截是否被执行)
        if (IsOpenLog)
            System.out.println(Utils.DateToString(new Date()) + ":LoginInterceptor preHandle");

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //控制台日志(方便验证拦截是否被执行)
        if (IsOpenLog)
            System.out.println(Utils.DateToString(new Date()) + ":LoginInterceptor postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //控制台日志(方便验证拦截是否被执行)
        if (IsOpenLog)
            System.out.println(Utils.DateToString(new Date()) + ":LoginInterceptor afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
