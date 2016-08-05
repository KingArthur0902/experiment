package com.threadblocked.experiment.module.spring.service;

import com.threadblocked.experiment.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ArthurTsang on 8/3/16.
 */
public class SpringTestServiceTest extends BaseTest {

    @Autowired
    private SpringTestService testService;

    @Test
    public void test11(){
        testService.test1("aaaaaaaa");
    }
}
