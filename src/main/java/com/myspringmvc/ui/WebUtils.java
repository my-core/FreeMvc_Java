package com.myspringmvc.ui;


import org.json.JSONObject;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangliangbin on 2016/9/13.
 */
public class WebUtils {
    /**
     * 设置Session
     *
     * @param key
     * @param obj
     */
    public static void setSession(HttpServletRequest request,String key, Object obj) {
        request.getSession().setAttribute(key, obj);
    }

    /**
     * 获取Session
     *
     * @param key
     * @return
     */
    public static Object getSession(HttpServletRequest request,String key) {
        return request.getSession().getAttribute(key);
    }

    /**
     * 删除Session
     *
     * @param key
     */
    public static void delSession(HttpServletRequest request,String key) {
        request.getSession().removeAttribute(key);
    }

    /**
     * 设置cookie
     *
     * @param key
     * @param obj
     */
    public static void setCookie(HttpServletResponse response,String key, Object obj) {
        Cookie cookie = new Cookie(key, JSONObject.valueToString(obj));
        cookie.setMaxAge(2 * 60 * 60);//设置为2小时
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     *
     * @param key
     * @return
     */
    public static String getCookie(HttpServletRequest request,String key) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName() == key)
                return cookie.getValue();
        }
        return null;
    }

    /**
     * 删除cookie
     *
     * @param key
     */
    public static void delCookie(HttpServletRequest request,String key) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName() == key)
                cookie.setMaxAge(-1);
        }
    }
}
