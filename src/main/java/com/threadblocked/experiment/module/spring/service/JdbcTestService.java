package com.threadblocked.experiment.module.spring.service;

/**
 * Created by ArthurTsang on 8/6/16.
 */
public interface JdbcTestService {
    void getRowCount();

    void getAAACount();

    void getName();

    void getUser(Integer id);

    void getUsers();
}
