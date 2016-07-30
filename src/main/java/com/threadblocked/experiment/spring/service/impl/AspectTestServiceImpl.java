package com.threadblocked.experiment.spring.service.impl;

import com.threadblocked.experiment.spring.service.AspectTestSerivce;
import org.springframework.stereotype.Service;

/**
 * Created by ArthurTsang on 7/31/16.
 */
@Service
public class AspectTestServiceImpl implements AspectTestSerivce {

    @Override
    public void testAspect() {
        System.out.println("now, this is business logic: test test test");
        if(true){
            throw new NullPointerException("aaaaaaa");
        }
    }

    @Override
    public void testAround(){
        System.out.println("now, this is business logic: around around around");
    }
}
