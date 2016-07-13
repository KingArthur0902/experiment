package com.threadblocked.experiment.spring.controller;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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

    @ExceptionHandler({ ConversionNotSupportedException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleServiceException(HttpServletRequest request, Exception ex) {
        ModelAndView mv = new ModelAndView("error/error");
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorCode","aaa");
        map.put("errorMsg","bbb");
        mv.addAllObjects(map);
        return mv;
    }

}
