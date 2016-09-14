package com.myspringmvc.service;

import com.myspringmvc.contract.request.GetUserListRequest;
import com.myspringmvc.contract.request.UserLoginRequest;
import com.myspringmvc.contract.response.BaseResponse;
import com.myspringmvc.contract.response.GetUserListResponse;
import com.myspringmvc.model.UserModel;

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
}
