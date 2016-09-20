package com.freemvc.web.controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangliangbin on 2016/9/6.
 */

/* 通过实现org.springframework.web.servlet.mvc.Controller接口或其实现来定义我们的处理器类 */
public class InheritController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "通过实现org.springframework.web.servlet.mvc.Controller接口或其实现来定义的处理器类!");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面(index.jsp)
        mv.setViewName("index");
        return mv;
    }
}
