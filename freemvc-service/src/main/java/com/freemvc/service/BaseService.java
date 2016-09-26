package com.freemvc.service;

import com.freemvc.idao.IBaseDao;
import com.freemvc.iservice.IBaseService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangliangbin on 2016/9/9.
 * 基础业务服务类
 */
public class BaseService implements  IBaseService {

    /**
     * 数据访问层对象
     */
    @Resource()
    private IBaseDao baseDao;


    /**
     * 构造函数
     */
    public BaseService() {
    }

    /**
     * 插入表记录
     * @param t 实体映射对象
     * @param <T>
     * @return
     */
    public <T> boolean insert(T t) {
        return baseDao.insert(t);
    }

    /**
     * 更新表记录
     * @param t 实体映射对象
     * @param <T>
     * @return
     */
    public <T> boolean update(T t) {
        return baseDao.update(t);
    }

    /**
     * 删除表所有记录
     * @param t 实体映射类型
     * @param <T>
     * @return
     */
    public <T> boolean delete(Class<T> t) {
        return baseDao.delete(t);
    }

    /**
     * 删除指定条件的表记录
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value 列值
     * @param <T>
     * @return
     */
    public <T> boolean delete(Class<T> t,String columnName, Object value) {
        return baseDao.delete(t, columnName, value);
    }

    /**
     * 获取指定条件的一条表记录
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value 列值
     * @param <T>
     * @return
     */
    public <T> T getModel(Class<T> t, String columnName, Object value) {
        return baseDao.getModel(t, columnName, value);
    }

    /**
     * 获取指定条件的记录列表
     * @param <T>
     * @return
     */
    public <T> List<T> getList(Class<T> t) {
        return baseDao.getList(t);
    }

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value 列值
     * @param <T>
     * @return
     */
    public <T> List<T> getList(Class<T> t,String columnName, Object value) {
        return baseDao.getList(t,columnName, value);
    }

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param hs 查询条件
     * @param <T>
     * @return
     */
    public <T> List<T> getList(Class<T> t, HashMap hs) {
        return baseDao.getList(t,hs);
    }

    /**
     * 分页取数据（未实现）
     * @param t
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(Class<T> t, int pageIndex, int pageSize, String orderBy) {
        return baseDao.getPageList(t, pageIndex, pageSize, orderBy);
    }
}
