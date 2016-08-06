package com.threadblocked.experiment.module.spring.controller;

import com.threadblocked.experiment.module.spring.service.JdbcTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ArthurTsang on 8/6/16.
 */
@RestController
@RequestMapping(value = "/jdbc")
public class JdbcTestController {

    @Autowired
    private JdbcTestService jdbcTestService;

    @RequestMapping(value = "/row-count")
    public void getRowCount() {
        jdbcTestService.getRowCount();
    }

    @RequestMapping(value = "/aaa-count")
    public void getAAACount(){
        jdbcTestService.getAAACount();
    }

    @RequestMapping(value = "/name")
    public void getName(){
        jdbcTestService.getName();
    }

    @RequestMapping("/user/{id}")
    public void getUser(@PathVariable Integer id){
        jdbcTestService.getUser(id);
    }

    @RequestMapping(value = "/users")
    public void getUsers(){
        jdbcTestService.getUsers();
    }
}
