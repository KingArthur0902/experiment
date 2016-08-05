package com.threadblocked.experiment.module.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by ArthurTsang on 7/30/16.
 */
@Component
@Aspect
public class AspectJAnotationTest {


    /**
     * pointcut : 指的是目标业务逻辑，可以理解为目标类的方法，可以用*号匹配多个方法
     * 定义公用pointcut 来给其他advice共用和combine
     */
    @Pointcut("execution(* com.threadblocked.experiment.module.spring.service.impl.AspectTestServiceImpl.testAspect(..))")
    public void servicePointCut(){}

    /**
     * advice : 关联上对应的pointcut，需要在目标业务逻辑上的增强逻辑，如日志，事务等
     */
    //在方法之前执行增强逻辑
    @Before("servicePointCut()")
    public void beforeService(){
        System.out.println("before service: hello");
    }

    //在方法返回之后执行逻辑
    @AfterReturning("servicePointCut()")
    public void afterReturnningService(){
        System.out.println("after return : world");
    }

    //方法抛出对应异常后，执行增强逻辑
    @AfterThrowing(pointcut = "servicePointCut()" ,throwing = "npe")
    public void afterThrowingService(NullPointerException npe){
        System.out.println(npe.getMessage());
    }

    //相当于finally
    @After("servicePointCut()")
    public void finallyService(){
        System.out.println("finally");
    }

    //joinpoint 包含了目标业务逻辑的所有信息，所以可以在调用proceed(执行目标业务逻辑方法)前后进行增强逻辑
    //可以直接传pointcut
    @Around("execution(* com.threadblocked.experiment.module.spring.service.impl.AspectTestServiceImpl.testAround(..))")
    public Object aroundService(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("pjp  start ---------------");
        Object rtv = pjp.proceed();
        System.out.println("pjp  end ---------------");
        return rtv;
    }

}
