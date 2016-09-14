package com.myspringmvc.controller;

import com.myspringmvc.common.Log4jHelper;
import com.myspringmvc.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by yangliangbin on 2016/9/2.
 * 采用注解的方式，可以明确地定义该类为处理请求的Controller类
 */
@Controller
public class BaseController {

    /**
     * 用户业务服务对象
     */
    @Resource
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
