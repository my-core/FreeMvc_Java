package com.freemvc.webapi.interceptor;

import com.freemvc.common.Log4jHelper;
import com.freemvc.config.GlobalConfig;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangliangbin on 2016/9/7.
 * 全局请求拦截器
 */
public class AllInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (GlobalConfig.isOpenLog)
            Log4jHelper.info(request.getClass().toString(), request.getMethod(), JSONObject.valueToString(request.getParameterMap()));
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (GlobalConfig.isOpenLog)
            Log4jHelper.info(request.getClass().toString(), request.getMethod(), JSONObject.valueToString(request.getParameterMap()));
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (GlobalConfig.isOpenLog)
            Log4jHelper.info(request.getClass().toString(), request.getMethod(), JSONObject.valueToString(response.getOutputStream()));
        super.afterCompletion(request, response, handler, ex);
    }
}
