package com.threadblocked.experiment.spring.support;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ArthurTsang on 7/24/16.
 */
@Component
public class LiftCircleCallbackTestBean implements InitializingBean, DisposableBean {

    private String name;

    /**
     * 注解实现初始化实例后的回调，推荐使用
     */
    @PostConstruct
    private void aaa(){
        name = "Hello";
        System.out.println(name);
    }


    /**
     * 实现接口来标明初始化实例后的回调，不推荐使用（耦合代码）
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        name = "world";
        System.out.println(name);
    }

    /**
     * 需要手动开启，配置default-init-method 或者 init-method
     */
    public void init(){
        name = "haha";
        System.out.println(name);
    }


    /**
     * 注解实现销毁实例前的回调，推荐使用
     */
    @PreDestroy
    public void bbb(){
        System.out.println("destroy 111111111111");
    }

    /**
     * 实现接口来标明销毁实例前的回调，不推荐使用（耦合代码）
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy 22222222222");
    }
    /**
     * 需要手动开启，配置default-destroy-method 或者 destroy-method
     */
    public void dddd(){
        System.out.println("destroy 3333333333");
    }
}
