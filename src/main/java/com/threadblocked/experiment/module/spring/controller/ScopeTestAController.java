package com.threadblocked.experiment.module.spring.controller;

import com.threadblocked.experiment.module.spring.support.ScopeProtoTypeTestBean;
import com.threadblocked.experiment.module.spring.support.ScopeRequestTestBean;
import com.threadblocked.experiment.module.spring.support.ScopeSessiionTestBean;
import com.threadblocked.experiment.module.spring.support.ScopeSingletonTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ArthurTsang on 7/24/16.
 */
@RestController
@RequestMapping(value = "/scope/a")
public class ScopeTestAController {

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

    /**
     * 单例，每个ioc只有一个实例，这里更改count的值后，ScopeTestBController中的对应引用也会输出更改后的值
     */
    @RequestMapping(value = "singleton",method = RequestMethod.GET)
    public void testSingleton(){
        System.out.println(scopeSingletonTestBean.getCount());
        scopeSingletonTestBean.setCount(10);
    }

    /**
     * 原型，每个引用，ioc会新建一个实例，这里的实例与ScopeTestBController的引用没有关系
     */
    @RequestMapping(value = "prototype",method = RequestMethod.GET)
    public void testPrototype(){
        System.out.println(scopeProtoTypeTestBean.getCount());
        scopeProtoTypeTestBean.setCount(11);
        System.out.println( context.isPrototype("scopeProtoTypeTestBean"));
    }

    /**
     * 请求，每个请求ioc会创建一个新的实例
     */
    @RequestMapping(value = "request")
    public void testRequest(){
        System.out.println(scopeRequestTestBean.getCount());
        scopeRequestTestBean.setCount(12);
    }

    /**
     * 会话，每个会话ioc会创建一个新的实例
     */
    @RequestMapping(value = "session")
    public void testSession(){
        System.out.println(scopeSessiionTestBean.getCount());
        scopeSessiionTestBean.setCount(13);
    }

}
