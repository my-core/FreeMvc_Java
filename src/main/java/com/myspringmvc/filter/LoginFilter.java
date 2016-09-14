package com.myspringmvc.filter;

import com.myspringmvc.model.UserModel;
import com.myspringmvc.ui.LoginUser;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yangliangbin on 2016/9/13.
 */
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        UserModel userModel= LoginUser.getCurrentUser(httpRequest);
        if(userModel==null){
            httpResponse.sendRedirect("/user/login");
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
