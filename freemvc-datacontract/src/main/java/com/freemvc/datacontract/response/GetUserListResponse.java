package com.freemvc.datacontract.response;

import com.freemvc.model.UserModel;

/**
 * Created by yangliangbin on 2016/9/12.
 */
public class GetUserListResponse extends UserModel {

    /**
     * 角色名称
     */
    private  String roleName;
    /**
     * 创建人
     */
    private String createUser;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }





}
