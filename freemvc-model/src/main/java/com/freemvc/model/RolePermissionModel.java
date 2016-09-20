package com.freemvc.model;

import com.freemvc.common.TableMapping;

/**
 * Created by yangliangbin on 2016/9/10.
 * 角色权限关联信息
 */
@TableMapping(tableName = "T_RolePermission",primaryKey = "ID")
public class RolePermissionModel {
    /**
     * 角色id
     */
    private String roleID;
    /**
     * 权限id
     */
    private String permissionID;

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(String permissionID) {
        this.permissionID = permissionID;
    }
}
