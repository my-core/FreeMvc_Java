package com.freemvc.web.common;

import org.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
    public static void setSession( String key, Object obj) {
        getRequest().getSession().setAttribute(key, obj);
    }

    /**
     * 获取Session
     *
     * @param key
     * @return
     */
    public static Object getSession( String key) {
        return getRequest().getSession().getAttribute(key);
    }

    /**
     * 删除Session
     *
     * @param key
     */
    public static void delSession( String key) {
        getRequest().getSession().removeAttribute(key);
    }

    /**
     * 设置cookie
     *
     * @param key
     * @param obj
     */
    public static void setCookie(HttpServletResponse response, String key, Object obj) {
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
    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = getRequest().getCookies();
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
    public static void delCookie( String key) {
        Cookie[] cookies = getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName() == key)
                cookie.setMaxAge(-1);
        }
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
}
