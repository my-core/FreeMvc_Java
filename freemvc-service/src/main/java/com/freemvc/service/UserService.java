package com.freemvc.service;

import com.freemvc.common.*;
import com.freemvc.datacontract.request.*;
import com.freemvc.datacontract.response.*;
import com.freemvc.idao.IUserDao;
import com.freemvc.iservice.IUserService;
import com.freemvc.model.*;
import javax.annotation.Resource;
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
