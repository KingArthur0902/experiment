package com.threadblocked.experiment.module.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by ArthurTsang on 7/31/16.
 */
public class AspectXmlTest {

    public void xmlBeforeTest(){
        System.out.println("xml before bbbbbbbb");
    }

    public void xmlAfterReturning(){
        System.out.println("xml after returning");
    }

    public void xmlAfter(){
        System.out.println("xml after");
    }

    public void xmlThrowNpe(NullPointerException npe){
        System.out.println("npe: " + npe.getMessage());
    }

    public Object xmlAround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("xml before pjp");
        Object rtv = pjp.proceed();
        System.out.println("xml after pjp");
        return rtv;
    }
}
