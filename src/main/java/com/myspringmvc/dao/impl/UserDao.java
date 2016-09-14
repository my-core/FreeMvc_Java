package com.myspringmvc.dao.impl;

import com.myspringmvc.contract.request.GetUserListRequest;
import com.myspringmvc.contract.response.BaseResponse;
import com.myspringmvc.contract.response.GetUserListResponse;
import com.myspringmvc.dao.IUserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.resource.spi.RetryableUnavailableException;
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
                sb.append("UserName=?");
                params.add(userName);
            }
            RowMapper<GetUserListResponse> rowMapper = BeanPropertyRowMapper.newInstance(GetUserListResponse.class);
            List<GetUserListResponse> list = (List<GetUserListResponse>) jdbcTemplate.query(sb.toString(), params.toArray(), rowMapper);
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
}

