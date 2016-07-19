package com.threadblocked.experiment.spring.controller;

import com.threadblocked.experiment.spring.vo.ConversionVo;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ArthurTsang on 7/17/16.
 */
@Controller
@RequestMapping(value = "/conversion")
public class ConversionServiceTestController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //用以支持接收date参数，不知道为何@DateTimeFormat注解不生效
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public void testConversionService1(ConversionVo vo){
        System.out.println(vo.getA());
    }
}
