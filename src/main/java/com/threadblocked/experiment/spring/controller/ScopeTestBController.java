package com.threadblocked.experiment.spring.controller;

import com.threadblocked.experiment.spring.support.ScopeProtoTypeTestBean;
import com.threadblocked.experiment.spring.support.ScopeRequestTestBean;
import com.threadblocked.experiment.spring.support.ScopeSessiionTestBean;
import com.threadblocked.experiment.spring.support.ScopeSingletonTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ArthurTsang on 7/24/16.
 */
@RestController
@RequestMapping(value = "/scope/b")
public class ScopeTestBController {

    @Autowired
    private ScopeSingletonTestBean scopeSingletonTestBean;
    @Autowired
    private ScopeProtoTypeTestBean scopeProtoTypeTestBean;
    @Autowired
    private ScopeRequestTestBean scopeRequestTestBean;
    @Autowired
    private ScopeSessiionTestBean scopeSessiionTestBean;

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "singleton",method = RequestMethod.GET)
    public void testSingleton(){
        System.out.println(scopeSingletonTestBean.getCount());
        scopeSingletonTestBean.setCount(20);
    }

    @RequestMapping(value = "prototype",method = RequestMethod.GET)
    public void testPrototype(){
        System.out.println(scopeProtoTypeTestBean.getCount());
        scopeProtoTypeTestBean.setCount(21);
        System.out.println( context.isPrototype("scopeProtoTypeTestBean"));
    }

    @RequestMapping(value = "session")
    public void testSession(){
        System.out.println(scopeSessiionTestBean.getCount());
        scopeSessiionTestBean.setCount(23);
    }

}
