package com.freemvc.web.controller;

import com.freemvc.common.Utils;
import com.freemvc.datacontract.request.*;
import com.freemvc.datacontract.response.*;
import com.freemvc.model.*;
import com.freemvc.web.common.AjaxResult;
import com.freemvc.web.common.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    //region ==============登录相关==================
    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        LoginUser.setCurrentUser( null);
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse httpResponse, UserLoginRequest loginRequest) throws IOException {
        BaseResponse<UserModel> logResponse = getUserService().userLogin(loginRequest);
        ModelAndView mv = null;
        if (logResponse.isOk()) {
            LoginUser.setCurrentUser(logResponse.getReturnData());
            httpResponse.sendRedirect("/");
        } else {
            mv = new ModelAndView("login");
            mv.addObject("msg", logResponse.getMsgContent());
        }
        return mv;
    }
    //endregion

    //region ========用户查询、添加、删除、修改========
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
    public void userAdd( HttpServletResponse httpResponse,UserModel model) throws IOException {
        AjaxResult result = new AjaxResult();
        if(model.getId()==null || model.getId().equals("")) {
            model.setId(Utils.getUUID());
            model.setCreateBy(LoginUser.getCurrentUser().getId());
            model.setCreateTime(new Date());
            getUserService().insert(model);
            result.setMsg("添加成功");
        }
        else {
            UserModel userModel = getUserService().getModel(UserModel.class, "ID", model.getId());
            if(model.getPassword().equals("")){
                model.setPassword(userModel.getPassword());
            }
            getUserService().update(model);
            result.setMsg("更新成功");
        }
        result.setIsOk(true);
        result.setData("/user/userList");
        reponseWrite(httpResponse,result);
    }
    /**
     * 用户删除
     *
     * @return
     */
    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.POST)
    public void userDelete(HttpServletResponse httpResponse, @PathVariable("id") String id) throws IOException {
        AjaxResult result = new AjaxResult();
        if(getUserService().delete(UserModel.class,"ID",id)) {
            result.setIsOk(true);
            result.setMsg("删除成功");
        }
        else {
            result.setIsOk(false);
            result.setMsg("删除失败");
        }
        result.setData("/user/userList");
        reponseWrite(httpResponse, result);
    }
    //endregion==

    //region ========权限查询、添加、删除、修改========
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
     * 权限添加
     *
     * @param id
     * @return
     */
    @RequestMapping(value = {"/permissionAdd/{id}"}, method = RequestMethod.GET)
    public ModelAndView permissionAdd(@PathVariable("id") String id) {
        PermissionModel model = getUserService().getModel(PermissionModel.class, "ID", id);
        ModelAndView mv = new ModelAndView("permissionAdd");
        mv.addObject("permission", model);
        return mv;
    }
    /**
     * 权限添加
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/permissionAdd", method = RequestMethod.POST)
    public void permissionAdd( HttpServletResponse httpResponse,PermissionModel model) throws IOException {
        AjaxResult result = new AjaxResult();
        if(model.getId()==null || model.getId().equals("")) {
            model.setId(Utils.getUUID());
            getUserService().insert(model);
            result.setMsg("添加成功");
        }
        else {
            getUserService().update(model);
            result.setMsg("更新成功");
        }
        result.setIsOk(true);
        result.setData("/user/userList");
        reponseWrite(httpResponse,result);
    }
    //endregion

    //region ========角色查询、添加、删除、修改========
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
    public void roleAdd(HttpServletResponse httpResponse, RoleModel model) throws IOException {
        AjaxResult result = new AjaxResult();
        if (model.getId() == null || model.getId().equals("")) {
            model.setId(Utils.getUUID());
            getUserService().insert(model);
            result.setMsg("添加成功");

        } else {
            getUserService().update(model);
            result.setMsg("更新成功");
        }
        result.setIsOk(true);
        result.setData("/user/roleList");
        reponseWrite(httpResponse,result);
    }
    /**
     * 角色删除
     *
     * @return
     */
    @RequestMapping(value = "/roleDelete/{id}", method = RequestMethod.POST)
    public void roleDelete(HttpServletResponse httpResponse, @PathVariable("id") String id) throws IOException {
        AjaxResult result = new AjaxResult();
        if(getUserService().delete(RoleModel.class,"ID",id)) {
            result.setIsOk(true);
            result.setMsg("删除成功");
        }
        else {
            result.setIsOk(false);
            result.setMsg("删除失败");
        }
        result.setData("/user/roleList");
        reponseWrite(httpResponse, result);
    }
    //endregion
}


