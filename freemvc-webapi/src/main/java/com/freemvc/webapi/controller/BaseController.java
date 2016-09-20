package com.freemvc.webapi.controller;

import com.freemvc.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by yangliangbin on 2016/9/22.
 * 基础控制器
 */
@Controller
public class BaseController {

    @Autowired
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
