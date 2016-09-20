package com.freemvc.dao;

import com.freemvc.common.Log4jHelper;
import com.freemvc.datacontract.request.*;
import com.freemvc.datacontract.response.*;
import com.freemvc.idao.IUserDao;
import com.freemvc.model.PermissionModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangliangbin on 2016/9/9.
 * 用户模块数据访问类
 */
public class UserDao extends BaseDao implements IUserDao {
    /**
     * 用户列表
     *
     * @param request
     * @return
     */
    public List<GetUserListResponse> getUserList(GetUserListRequest request) {
        try {
            //sql语句
            StringBuffer sb = new StringBuffer();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            sb.append("select a.*,b.Name as RoleName,c.Name as CreateUser from T_User a ");
            sb.append("left join T_Role b on b.ID=a.RoleID ");
            sb.append("left join T_User c on c.ID=a.CreateBy ");
            sb.append("where 1=1 ");
            String userName = request.getUserName();
            if (userName != null && userName.length() != 0) {
                sb.append("UserName=? ");
                params.add(userName);
            }
            sb.append("order by a.CreateTime desc ");
            RowMapper<GetUserListResponse> rowMapper = BeanPropertyRowMapper.newInstance(GetUserListResponse.class);
            List<GetUserListResponse> list = (List<GetUserListResponse>) jdbcTemplate.query(sb.toString(), params.toArray(), rowMapper);
            return list;
        } catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(), "getUserList", "", ex);
            return null;
        }
    }

    /**
     * 获取权限
     * @return
     */
    public  List<PermissionModel> getPermissionList() {
        try {
            //sql语句
            StringBuffer sb = new StringBuffer();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            sb.append("select * from T_Permission order by Type, Sort ");
            RowMapper<PermissionModel> rowMapper = BeanPropertyRowMapper.newInstance(PermissionModel.class);
            List<PermissionModel> list = (List<PermissionModel>) jdbcTemplate.query(sb.toString(), params.toArray(), rowMapper);
            return list;
        } catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(), "getPermissionList", "", ex);
            return null;
        }
    }

    /**
     * 获取用户权限
     * @param userID 用户ID
     * @return
     */
    public  List<PermissionModel> getUserPermission(String userID) {
        try {
            //sql语句
            StringBuffer sb = new StringBuffer();
            //sql参数
            List<Object> params = new ArrayList<Object>();
            sb.append("select c.* from T_RolePermission a ");
            sb.append("inner join T_User b on b.RoleID=a.RoleID ");
            sb.append("inner join T_Permission c on c.ID=a.PermissionID ");
            sb.append("where b.ID=? ");
            params.add(userID);
            RowMapper<PermissionModel> rowMapper = BeanPropertyRowMapper.newInstance(PermissionModel.class);
            List<PermissionModel> list = (List<PermissionModel>) jdbcTemplate.query(sb.toString(), params.toArray(), rowMapper);
            return list;
        } catch (Exception ex) {
            Log4jHelper.error(this.getClass().getName(), "getUserPermission", "", ex);
            return null;
        }
    }
}

