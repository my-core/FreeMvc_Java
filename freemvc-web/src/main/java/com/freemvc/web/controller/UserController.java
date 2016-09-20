package com.freemvc.web.controller;

import com.freemvc.common.Utils;
import com.freemvc.datacontract.request.*;
import com.freemvc.datacontract.response.*;
import com.freemvc.model.PermissionModel;
import com.freemvc.model.RoleModel;
import com.freemvc.model.UserModel;
import com.freemvc.web.common.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by yangliangbin on 2016/9/12.
 * 采用注解的方式，可以明确地定义该类为处理请求的Controller类
 */
@Controller
@RequestMapping("/user")
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
        ModelAndView mv = new ModelAndView("userList");
        mv.addObject("userList", response.getReturnData());
        return mv;
    }

    /**
     * 用户添加
     *
     * @param id
     * @return
     */
    @RequestMapping(value = {"/userAdd/{id}"}, method = RequestMethod.GET)
    public ModelAndView userAdd(@PathVariable("id") String id) {
        UserModel model = getUserService().getModel(UserModel.class, "ID", id);
        ModelAndView mv = new ModelAndView("userAdd");
        mv.addObject("user", model);
        return mv;
    }
    /**
     * 用户添加
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public void userAdd(HttpServletRequest httpRequest, HttpServletResponse httpResponse,UserModel model) throws IOException {
        if(model.getId()==null || model.getId().equals("")) {
            model.setId(Utils.getUUID());
            model.setCreateBy(LoginUser.getCurrentUser(httpRequest).getId());
            model.setCreateTime(new Date());
            getUserService().insert(model);
        }
        else {
            getUserService().update(model);
        }
        httpResponse.sendRedirect("/user/userList");
    }

    /**
     * 权限列表
     *
     * @return
     */
    @RequestMapping(value = "/permissionList", method = RequestMethod.GET)
    public ModelAndView permissionList() {
        List<PermissionModel> list = getUserService().getPermissionList();
        for(PermissionModel item : list) {
            if (item.getType() == 2) {
                item.setName("|----" + item.getName());
            } else if (item.getType() == 2) {
                item.setName("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----" + item.getName());
            }
        }
        ModelAndView mv = new ModelAndView("permissionList");
        mv.addObject("permissionList", list);
        return mv;
    }

    /**
     * 角色列表
     *
     * @return
     */
    @RequestMapping(value = "/roleList", method = RequestMethod.GET)
    public ModelAndView roleList() {
        List<RoleModel> list = getUserService().getList(RoleModel.class);
        ModelAndView mv = new ModelAndView("roleList");
        mv.addObject("roleList", list);
        return mv;
    }
    /**
     * 角色添加
     *
     * @param id
     * @return
     */
    @RequestMapping(value = {"/roleAdd/{id}"}, method = RequestMethod.GET)
    public ModelAndView roleAdd(@PathVariable("id") String id) {
        RoleModel model = getUserService().getModel(RoleModel.class, "ID", id);
        ModelAndView mv = new ModelAndView("roleAdd");
        mv.addObject("role", model);
        return mv;
    }
    /**
     * 角色添加
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/roleAdd", method = RequestMethod.POST)
    public void roleAdd(HttpServletRequest httpRequest, HttpServletResponse httpResponse,RoleModel model) throws IOException {
        if(model.getId()==null || model.getId().equals("")) {
            model.setId(Utils.getUUID());
            getUserService().insert(model);
        }
        else {
            getUserService().update(model);
        }
        httpResponse.sendRedirect("/user/roleList");
    }
}
