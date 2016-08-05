package com.threadblocked.experiment.module.spring.service.impl;

import com.threadblocked.experiment.module.spring.service.AspectTestSerivce;
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

    @Override
    public void testXmlAspect(){
        System.out.println("now, this is business logic: xml xml xml");
    }

    @Override
    public void testXmlAround(){
        System.out.println("now, this is business logic: xml around around");
    }
}
