package com.huoli.checkin.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.huoli.checkin.entity.QueryAccount;

public class QueryAccountDao extends JdbcDaoSupport {

    public int save(QueryAccount queryAccount) {
        if (isDuplicate(queryAccount.getType(), queryAccount.getUsername())) {
            return 0;
        }
        String sql = "INSERT INTO query_account (type, username, password, used, status,name, ext_data,updatetime,createtime) VALUES(?,?,?,0,0,?,?,NOW(),NOW())";
        int ret = getJdbcTemplate().update(sql,
            new Object[] { queryAccount.getType(), queryAccount.getUsername(), queryAccount.getPassword(), queryAccount.getName(), queryAccount.getExtData() },
            new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR });
        return ret;
    }

    /**
     * 判断是否有相同的数据
     *
     * @param type
     * @param username
     * @return
     */
    private boolean isDuplicate(String type, String username) {
        String sql = "SELECT * from query_account where type=? and username=?";
        List<Object> args = new ArrayList<Object>();
        args.add(type);
        args.add(username);
        return CollectionUtils.isNotEmpty(getJdbcTemplate().queryForList(sql, args.toArray()));
    }
}
