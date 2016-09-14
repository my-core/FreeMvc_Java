package com.myspringmvc.controller;

import com.myspringmvc.contract.request.GetUserListRequest;
import com.myspringmvc.contract.request.UserLoginRequest;
import com.myspringmvc.contract.response.BaseResponse;
import com.myspringmvc.contract.response.GetUserListResponse;
import com.myspringmvc.model.UserModel;
import com.myspringmvc.ui.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yangliangbin on 2016/9/12.
 * 采用注解的方式，可以明确地定义该类为处理请求的Controller类
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        LoginUser.setCurrentUser(request, null);
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    /**
     * 用户登录
     *
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest httpRequest, HttpServletResponse httpResponse, UserLoginRequest loginRequest) throws IOException {
        BaseResponse<UserModel> logResponse = getUserService().userLogin(loginRequest);
        ModelAndView mv = null;
        if (logResponse.isOk()) {
            LoginUser.setCurrentUser(httpRequest, logResponse.getReturnData());
            httpResponse.sendRedirect("/");
        } else {
            mv = new ModelAndView("login");
            mv.addObject("msg", logResponse.getMsgContent());
        }
        return mv;
    }

    /**
     * 用户列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(GetUserListRequest request) {
        BaseResponse<List<GetUserListResponse>> response = getUserService().getUserList(request);
        ModelAndView mv = new ModelAndView("userlist");
        mv.addObject("userList", response.getReturnData());
        return mv;
    }

    /**
     * 用户添加
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    public ModelAndView userAdd(String id) {

        ModelAndView mv = new ModelAndView("userAdd");
        mv.addObject("user", null);
        return mv;
    }
    /**
     * 用户添加
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public ModelAndView userAdd(UserModel model) {
        ModelAndView mv = new ModelAndView("userList");
        return mv;
    }

}
