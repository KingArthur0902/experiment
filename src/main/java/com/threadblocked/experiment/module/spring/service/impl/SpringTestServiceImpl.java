package com.threadblocked.experiment.module.spring.service.impl;

import com.threadblocked.experiment.module.spring.service.SpringTestService;
import org.springframework.stereotype.Service;

/**
 * Created by ArthurTsang on 8/3/16.
 */
@Service
public class SpringTestServiceImpl implements SpringTestService {

    @Override
    public void test1(String name){
        System.out.println("name: " + name);
    }

}
