package com.threadblocked.experiment.module.spring.dao;

import com.threadblocked.experiment.module.spring.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ArthurTsang on 8/6/16.
 */
@Repository
public class JdbcTestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getSysUserRowCount(){
        return this.jdbcTemplate.queryForObject("select count(*) from sys_user",Integer.class);
    }

    public Integer getAAARowCount(){
        return this.jdbcTemplate.queryForObject("select count(*) from sys_user where  user_name = ?",Integer.class,"aaa");
    }

    public String getName(){
        return this.jdbcTemplate.queryForObject("select user_name from sys_user where sys_user_id = ?",new Object[]{2},String.class);
    }

    public SysUser getUserById(Integer id){
        return this.jdbcTemplate.queryForObject("select * from sys_user where sys_user_id = ?",new Object[]{id},new SysUserMapper());
    }

    public List<SysUser> getUsers(){
        return this.jdbcTemplate.query("select * from sys_user",new SysUserMapper());
    }

    public void addUser(){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO sys_user (user_name, password) VALUES (?,?)",new String[]{"sys_user_id"});
                ps.setString(1,"eee");
                ps.setString(2,"eee");
                return ps;
            }
        });
    }

    private static final class SysUserMapper implements RowMapper<SysUser>{

        @Override
        public SysUser mapRow(ResultSet resultSet, int i) throws SQLException {
            SysUser user = new SysUser();
            user.setSysUserId(resultSet.getInt("sys_user_id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
}
