package com.threadblocked.experiment.spring.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 对ioc的拓展，对每个bean的实例都会调用下面的两个方法
 * 可以有多个实现，用order进行排序
 * Created by ArthurTsang on 7/24/16.
 */
public class BeanPostProcessorTestBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}
