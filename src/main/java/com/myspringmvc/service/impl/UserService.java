package com.myspringmvc.service.impl;

import com.myspringmvc.common.Log4jHelper;
import com.myspringmvc.common.Utils;
import com.myspringmvc.contract.request.GetUserListRequest;
import com.myspringmvc.contract.request.UserLoginRequest;
import com.myspringmvc.contract.response.BaseResponse;
import com.myspringmvc.contract.response.GetUserListResponse;
import com.myspringmvc.dao.IUserDao;
import com.myspringmvc.dao.impl.UserDao;
import com.myspringmvc.model.PermissionModel;
import com.myspringmvc.model.UserModel;
import com.myspringmvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 * 用户服务类
 */
public class UserService extends BaseService implements IUserService {

    /**
     * 数据访问层对象
     */
    @Resource()
    private IUserDao userDao;

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    public BaseResponse<UserModel> userLogin(UserLoginRequest request) {
        BaseResponse<UserModel> response = new BaseResponse<UserModel>();
        try {
            UserModel info = getModel(UserModel.class, "UserName", request.getUserName());
            //用户名不存在
            if (info == null) {
                response.setMsgCode("10001");
                return response;
            }
            //密码错误
            if (!info.getPassword().equals(Utils.md5(request.getPassword()))) {
                response.setMsgCode("10002");
                return response;
            }
            response.setOk(true);
            response.setMsgCode("10000");
            response.setReturnData(info);
        } catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(), "userLogin", "", ex);
        }
        return response;
    }

    /**
     * 用户列表
     *
     * @param request
     * @return
     */
    public BaseResponse<List<GetUserListResponse>> getUserList(GetUserListRequest request) {
        BaseResponse<List<GetUserListResponse>> response = new BaseResponse<List<GetUserListResponse>>();
        try {
            List<GetUserListResponse> list = userDao.getUserList(request);
            response.setOk(true);
            response.setMsgCode("10000");
            response.setReturnData(list);
            return response;
        }
        catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(), "", "", ex);
            return response;
        }
    }

    /**
     * 获取权限
     * @return
     */
    public  List<PermissionModel> getPermissionList(){
        return userDao.getPermissionList();
    }

    /**
     * 获取用户权限
     * @param userID 用户ID
     * @return
     */
    public  List<PermissionModel> getUserPermission(String userID){
        return userDao.getUserPermission(userID);
    }
}
