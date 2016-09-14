package com.myspringmvc.controller;

import com.myspringmvc.common.Log4jHelper;
import com.myspringmvc.model.UserModel;
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
public class HomeController extends BaseController {


    /*用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {


        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
