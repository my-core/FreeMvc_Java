package com.freemvc.iservice;

import com.freemvc.datacontract.request.*;
import com.freemvc.datacontract.response.*;
import com.freemvc.model.*;

import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 * 用户服务类接口
 */
public interface IUserService extends IBaseService {
    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    BaseResponse<UserModel> userLogin(UserLoginRequest request);

    /**
     * 用户列表
     *
     * @param request
     * @return
     */
    BaseResponse<List<GetUserListResponse>> getUserList(GetUserListRequest request);

    /**
     * 获取权限
     * @return
     */
    List<PermissionModel> getPermissionList();

    /**
     * 获取用户权限
     * @param userID 用户ID
     * @return
     */
    List<PermissionModel> getUserPermission(String userID);
}
