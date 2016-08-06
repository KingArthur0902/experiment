package com.threadblocked.experiment.module.spring.service.impl;

import com.threadblocked.experiment.module.spring.dao.JdbcTestDao;
import com.threadblocked.experiment.module.spring.domain.SysUser;
import com.threadblocked.experiment.module.spring.service.JdbcTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ArthurTsang on 8/6/16.
 */
@Service
public class JdbcTestServiceImpl implements JdbcTestService {

    @Autowired
    private JdbcTestDao jdbcTestDao;


    @Override
    public void getRowCount() {
        System.out.println("row count: " + jdbcTestDao.getSysUserRowCount());
    }

    @Override
    public void getAAACount(){
        System.out.println("aaa count: " + jdbcTestDao.getAAARowCount());
    }

    @Override
    public void getName(){
        System.out.println("id 2 name : " + jdbcTestDao.getName());
    }

    @Override
    public void getUser(Integer id){
        SysUser user = jdbcTestDao.getUserById(id);
        System.out.println("id:" + user.getSysUserId() + " name: " + user.getUserName() + " password: " + user.getPassword() );
    }

    @Override
    public void getUsers(){
        List<SysUser> users = jdbcTestDao.getUsers();
        System.out.println("size: " + users == null ? "null" : users.size());
    }
}
