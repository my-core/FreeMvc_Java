package com.freemvc.model;

import com.freemvc.common.*;

/**
 * Created by yangliangbin on 2016/9/10.
 * 权限信息
 */
@TableMapping(tableName = "T_Permission",primaryKey = "ID")
public class PermissionModel {
    /**
     * 主键id
     */
    private String id;
    /**
     * 父级id
     */
    private String parentID;
    /**
     * 权限类别
     */
    private int type;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限编码
     */
    private String code;
    /**
     * icon图标
     */
    private String icon;
    /**
     * 地址
     */
    private String url;
    /**
     * 排序
     */
    private int sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
