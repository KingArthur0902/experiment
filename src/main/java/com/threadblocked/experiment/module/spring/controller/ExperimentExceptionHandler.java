package com.threadblocked.experiment.module.spring.controller;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by ArthurTsang on 7/19/16.
 */
@ControllerAdvice
public class ExperimentExceptionHandler {
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
