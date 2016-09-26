package com.freemvc.web.common;

import com.freemvc.model.UserModel;
import com.sun.deploy.net.HttpRequest;
import com.sun.net.httpserver.HttpContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yangliangbin on 2016/9/13.
 */
public class LoginUser {

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    public static UserModel getCurrentUser() {
        Object obj = WebUtils.getSession("LoginUser");
        if (obj != null)
            return (UserModel) obj;
        return null;
    }

    /**
     * 设置当前登录用户信息
     *
     * @param model
     */
    public static void setCurrentUser( UserModel model) {
        if (model == null)
            WebUtils.delSession("LoginUser");
        else
            WebUtils.setSession("LoginUser", model);
    }
}
