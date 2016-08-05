package com.threadblocked.experiment.module.spring.controller;

import com.threadblocked.experiment.module.spring.service.AspectTestSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ArthurTsang on 7/31/16.
 */
@RequestMapping(value = "/aspect")
@RestController
public class AspectTestController {

    @Autowired
    private AspectTestSerivce aspectTestSerivce;

    @RequestMapping(value = "test1")
    public void testAspect1(){
        aspectTestSerivce.testAspect();
    }

    @RequestMapping(value = "test2")
    public void testAspect2(){
        aspectTestSerivce.testAround();
    }
    @RequestMapping(value = "test3")
    public void testAspect3(){
        aspectTestSerivce.testXmlAspect();
    }
    @RequestMapping(value = "test4")
    public void testAspect4(){
        aspectTestSerivce.testXmlAround();
    }

}
