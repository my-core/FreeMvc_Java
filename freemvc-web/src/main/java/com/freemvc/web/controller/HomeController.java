package com.freemvc.web.controller;

import com.freemvc.common.Log4jHelper;
import com.freemvc.model.*;
import com.freemvc.iservice.IUserService;
import com.freemvc.web.common.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangliangbin on 2016/9/2.
 * 采用注解的方式，可以明确地定义该类为处理请求的Controller类
 */
@Controller
public class HomeController extends BaseController {


    /*用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {

        List<PermissionModel> list = null;
        UserModel userModel = LoginUser.getCurrentUser(request);
        StringBuffer sb = new StringBuffer();
        if (userModel != null) {
            //admin最高权限
            if (userModel.getUserName().equals("admin")) {
                list = getUserService().getList(PermissionModel.class);
            } else {
                list = getUserService().getUserPermission(userModel.getId());
            }
            //构造菜单
            for (PermissionModel p1 : getPermissionByType(list, 1)) {
                sb.append(String.format("<li><a><i class=\"fa fa-%s\"></i><span class=\"nav-label\">%s</span><span class=\"fa arrow\"></span></a>", p1.getIcon(), p1.getName()));
                sb.append("<ul class=\"nav nav-second-level\">");
                for (PermissionModel p2 : getPermissionByPid(list, p1.getId())) {
                    sb.append(String.format("<li><a class=\"J_menuItem\" href=\"%s\" data-index=\"0\">%s</a></li>", p2.getUrl(), p2.getName()));
                }
                sb.append("</ul>");
                sb.append("</li>");
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissin", sb.toString());
        mv.setViewName("index");
        return mv;
    }
    /*用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；*/
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {


        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }

    private  List<PermissionModel> getPermissionByType(List<PermissionModel> list, int type) {
        List<PermissionModel> temp = new ArrayList<PermissionModel>();
        for (PermissionModel p1 : list) {
            if (p1.getType()== type) {
                temp.add(p1);
            }
        }
        return temp;
    }
    private  List<PermissionModel> getPermissionByPid(List<PermissionModel> list, String pid) {
        List<PermissionModel> temp = new ArrayList<PermissionModel>();
        for (PermissionModel p1 : list) {
            if (p1.getParentID().equals(pid)) {
                temp.add(p1);
            }
        }
        return temp;
    }

}
