package com.freemvc.web.controller;

import com.freemvc.common.Log4jHelper;
import com.freemvc.iservice.IUserService;
import com.freemvc.web.common.AjaxResult;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    /**
     * 输出Ajax响应
     * @param httpResponse
     * @param result
     * @throws IOException
     */
    public  void reponseWrite(HttpServletResponse httpResponse, AjaxResult result)throws IOException {
        JSONObject json=new JSONObject();
        json.put("isOk",result.getIsOk());
        json.put("msg",result.getMsg());
        json.put("data",result.getData());
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.getWriter().print(json.toString());
    }
}
