package com.freemvc.model;

import com.freemvc.common.TableMapping;

import java.util.Date;

/**
 * Created by yangliangbin on 2016/9/10.
 * 角色信息
 */
@TableMapping(tableName = "T_Role",primaryKey = "ID")
public class RoleModel {
    /**
     * 主键id
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
