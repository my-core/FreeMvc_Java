package com.myspringmvc.dao;

import com.myspringmvc.contract.request.GetUserListRequest;
import com.myspringmvc.contract.response.BaseResponse;
import com.myspringmvc.contract.response.GetUserListResponse;
import com.myspringmvc.model.PermissionModel;

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
