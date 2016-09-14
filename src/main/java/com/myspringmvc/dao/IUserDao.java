package com.myspringmvc.dao;

import com.myspringmvc.contract.request.GetUserListRequest;
import com.myspringmvc.contract.response.BaseResponse;
import com.myspringmvc.contract.response.GetUserListResponse;

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
}
