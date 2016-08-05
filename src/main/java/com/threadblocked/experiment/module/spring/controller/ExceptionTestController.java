package com.threadblocked.experiment.module.spring.controller;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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


    @RequestMapping(value = "/test2")
    public ModelAndView testException2(ModelAndView view) throws ClassNotFoundException{
        view.setViewName("index");
        throw new ClassNotFoundException("class not found");
    }

    @RequestMapping(value = "/test3")
    public ModelAndView testException3(ModelAndView view){
        view.setViewName("index");
        String str = null;
        str.length();
        return view;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView error(RuntimeException error, HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        view.setViewName("error");
        view.addObject("param","Runtime error");
        return view;
    }

    @ExceptionHandler()
    public ModelAndView exception(Exception ex,HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        view.setViewName("error");
        view.addObject("param","exception");
        return view;
    }
}
