package com.freemvc.idao;

import org.springframework.jdbc.core.JdbcOperations;
import java.util.*;

/**
 * Created by yangliangbin on 2016/9/9.
 * 基础数据访问类接口
 */
public interface IBaseDao {

    /**
     * 插入表记录
     * @param t   实体映射对象
     * @param <T> 泛型
     * @return
     */
    <T> boolean insert(T t);

    /**
     * 更新表记录
     * @param t   实体映射对象
     * @param <T>
     * @return
     */
    <T> boolean update(T t);

    /**
     * 删除表所有记录
     *@param t 实体映射类型
     * @param <T>
     * @return
     */
    <T> boolean delete(Class<T> t);

    /**
     * 删除指定条件的表记录
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value      列值
     * @param <T>
     * @return
     */
    <T> boolean delete(Class<T> t, String columnName, Object value);

    /**
     * 获取指定条件的一条表记录
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value      列值
     * @param <T>
     * @return
     */
    <T> T getModel(Class<T> t, String columnName, Object value);

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param <T>
     * @return
     */
    <T> List<T> getList(Class<T> t);

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value      列值
     * @param <T>
     * @return
     */
    <T> List<T> getList(Class<T> t, String columnName, Object value);

    /**
     * 分布获取数据
     * @param t
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @param <T>
     * @return
     */
    <T> List<T> getPageList(Class<T> t, int pageIndex, int pageSize, String orderBy);

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param hs  查询条件
     * @param <T>
     * @return
     */
    <T> List<T> getList(Class<T> t, HashMap hs);
}
