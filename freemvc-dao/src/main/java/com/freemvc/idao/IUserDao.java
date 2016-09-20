package com.freemvc.idao;

import com.freemvc.datacontract.request.*;
import com.freemvc.datacontract.response.*;
import com.freemvc.model.*;

import java.util.List;

/**
 * Created by yangliangbin on 2016/9/9.
 * 用户模块数据访问类接口
 */
public interface IUserDao extends IBaseDao {
    /**
     * 用户列表
     *
     * @param request
     * @return
     */
    List<GetUserListResponse> getUserList(GetUserListRequest request);

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
