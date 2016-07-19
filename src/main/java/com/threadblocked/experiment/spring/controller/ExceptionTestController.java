package com.threadblocked.experiment.spring.controller;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ArthurTsang on 7/13/16.
 */
@Controller
@RequestMapping(value = "/exception")
public class ExceptionTestController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public void testException1() throws BindException {
        String s = "aaa";
        throw new ConversionNotSupportedException(s,Integer.class,new Throwable());
    }



}
