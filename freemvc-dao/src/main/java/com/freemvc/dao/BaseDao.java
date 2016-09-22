package com.freemvc.dao;

import com.freemvc.common.Log4jHelper;
import com.freemvc.common.ObjectHelper;
import com.freemvc.common.TableMapping;
import com.freemvc.idao.IBaseDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterBatchUpdateUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangliangbin on 2016/9/9.
 * 基础数据访问类
 */
public class BaseDao extends JdbcDaoSupport implements IBaseDao {

    /**
     * 数据访问对象
     */
    @Resource
    public JdbcTemplate jdbcTemplate;

    /**
     * 构造函数
     */
    public BaseDao() {}

    /**
     * 插入表记录
     * @param t 实体映射对象
     * @param <T>
     * @return
     */
    public <T> boolean insert(T t) {
        try {
            //插入sql语句
            String sql = "insert into %s (%s) values (%s);";
            //实体TableMapping注解
            TableMapping tableMapping = getTableMapping(t.getClass());
            if (tableMapping == null)
                return false;
            //表名
            String tableName = tableMapping.tableName();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            //sql列名、列表值部分
            StringBuilder sbFiled = new StringBuilder();
            StringBuilder sbValue = new StringBuilder();
            //获取对象字段集
            String[] arrFieldName = ObjectHelper.getFiledName(t);
            //构造sql
            for (String field : arrFieldName) {
                if (sbFiled.length() > 0) {
                    sbFiled.append(",");
                    sbValue.append(",");
                }
                sbFiled.append(field);
                sbValue.append("?");
                params.add(ObjectHelper.getFieldValueByName(field, t));
            }
            sql = String.format(sql, tableName, sbFiled, sbValue);
            return jdbcTemplate.update(sql, params.toArray()) > 0;
        } catch (Exception ex) {
            //to log something
            return false;
        }
    }

    /**
     * 更新表记录
     * @param t 实体映射对象
     * @param <T>
     * @return
     */
    public <T> boolean update(T t) {
        try {
            //插入sql语句
            String sql = "update %s set %s where (%s);";
            //实体TableMapping注解
            TableMapping tableMapping = getTableMapping(t.getClass());
            if (tableMapping == null)
                return false;
            //表名、主键
            String tableName = tableMapping.tableName();
            String primaryKey = tableMapping.primaryKey();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            //sql列名、列表值部分
            StringBuilder sbSet = new StringBuilder();
            StringBuilder sbWhere = new StringBuilder();
            //获取对象字段集
            String[] arrFieldName = ObjectHelper.getFiledName(t);
            //构造sql
            for (String field : arrFieldName) {
                if (sbSet.length() > 0) {
                    sbSet.append(",");
                }
                Object value = ObjectHelper.getFieldValueByName(field, t);
                //为null则不更新
                if (value == null || field.toLowerCase().equals("createtime") || field.toLowerCase().equals("createby")) {
                    continue;
                }
                //主键作为更新条件
                if (field.toLowerCase().equals(primaryKey.toLowerCase())) {
                    primaryKey = field;
                    sbWhere.append(String.format("%s=?", field));
                } else {
                    sbSet.append(String.format("%s=?", field));
                    params.add(value);
                }
            }
            params.add(ObjectHelper.getFieldValueByName(primaryKey, t));
            sql = String.format(sql, tableName, sbSet, sbWhere);
            return jdbcTemplate.update(sql, params.toArray()) > 0;
        } catch (Exception ex) {
            //to log something
            return false;
        }
    }

    /**
     * 删除表所有记录
     * @param t 实体映射类型
     * @param <T>
     * @return
     */
    public <T> boolean delete(Class<T> t) {
        return this.delete(t,"","");
    }

    /**
     * 删除指定条件的表记录
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value      列值
     * @param <T>
     * @return
     */
    public <T> boolean delete(Class<T> t,String columnName, Object value) {
        try {
            //插入sql语句
            String sql = "delete from %s where (%s);";
            //实体TableMapping注解
            TableMapping tableMapping = getTableMapping(t);
            if (tableMapping == null) {
                Log4jHelper.error(this.getClass().getName(), "getModel", t.getName() + "未添加TableMapping注解", null);
                return false;
            }
            //表名
            String tableName = tableMapping.tableName();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            //sql列名、列表值部分
            StringBuilder sbWhere = new StringBuilder();
            if(columnName==null || columnName.length()==0) {
                sbWhere.append("1=1");
            }
            else {
                sbWhere.append(String.format("%s=?",columnName));
                params.add(value);
            }
            sql = String.format(sql, tableName, sbWhere);
            return jdbcTemplate.update(sql, params.toArray()) > 0;
        } catch (Exception ex) {
            //to log something
            return false;
        }
    }

    /**
     * 获取指定条件的一条表记录
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value      列值
     * @param <T>
     * @return
     */
    public <T> T getModel(Class<T> t, String columnName, Object value) {
        try {
            //插入sql语句
            String sql = "select * from %s where (%s);";
            //实体TableMapping注解
            TableMapping tableMapping = getTableMapping(t);
            if (tableMapping == null) {
                Log4jHelper.error(this.getClass().getName(), "getModel", t.getName() + "未添加TableMapping注解", null);
                return null;
            }
            //表名
            String tableName = tableMapping.tableName();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            //sql列名、列表值部分
            StringBuilder sbWhere = new StringBuilder();
            if (columnName == null || columnName.length() == 0) {
                sbWhere.append("1=1");
            } else {
                sbWhere.append(String.format("%s=?", columnName));
                params.add(value);
            }
            sql = String.format(sql, tableName, sbWhere);
            RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(t);
            List<T> list= (List<T>) jdbcTemplate.query(sql, params.toArray(), rowMapper);
            if(list.size()>0)
                return list.get(0);
            else
                return null;
        }
        catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(),"getList","",ex);
            return null;
        }
    }

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param <T>
     * @return
     */
    public <T> List<T> getList(Class<T> t) {
        return getList(t, "", "");
    }

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param columnName 列名
     * @param value      列值
     * @param <T>
     * @return
     */
    public <T> List<T> getList(Class<T> t,String columnName, Object value) {
        HashMap map = new HashMap();
        if (columnName != null && columnName.length() > 0) {
            map.put(columnName, value);
        }
        return getList(t, map);
    }

    /**
     * 获取指定条件的记录列表
     * @param t 实体映射类型
     * @param hs  查询条件
     * @param <T>
     * @return
     */
    public <T> List<T> getList(Class<T> t,HashMap hs) {
        try {
            //插入sql语句
            String sql = "select * from %s where (%s);";
            //实体TableMapping注解
            TableMapping tableMapping = getTableMapping(t);
            if (tableMapping == null) {
                Log4jHelper.error(this.getClass().getName(), "getModel", t.getName() + "未添加TableMapping注解", null);
                return null;
            }
            //表名
            String tableName = tableMapping.tableName();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            //sql列名、列表值部分
            StringBuilder sbWhere = new StringBuilder();

            if (hs == null || hs.size() == 0) {
                sbWhere.append("1=1");
            } else {
                for (Object key : hs.keySet()) {
                    sbWhere.append(String.format("%s=?", key.toString()));
                    params.add(hs.get(key));
                }
            }
            sql = String.format(sql, tableName, sbWhere);
            RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(t);
            return (List<T>) jdbcTemplate.query(sql, params.toArray(), rowMapper);
        } catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(), "getList", "", ex);
            return null;
        }
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
        return null;
    }

    /**
     * 获取实体类上的TableMapping注解
     * @param t 实体映射对象
     * @return
     * @throws Exception
     */
    private <T> TableMapping getTableMapping(Class<T> t)  {
        try {
            Annotation annotation = t.getAnnotation(TableMapping.class);
            if (annotation == null) {
                throw new Exception("类" + t.getName() + "必须添加'TableMapping'注解");
            }
            return (TableMapping) annotation;
        }
        catch (Exception ex) {
            return null;
        }
    }
}
