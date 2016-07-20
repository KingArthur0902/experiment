package com.threadblocked.experiment.spring.controller;

import com.threadblocked.experiment.spring.vo.ValidateVo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by ArthurTsang on 7/20/16.
 */
@Controller
@RequestMapping(value = "/validate")
public class ValidatorTestController {

    @RequestMapping(value = "/test1")
    public void testValidate1(@Valid ValidateVo vo, BindingResult result){
        if(result.hasErrors()){
            System.out.println("error");
            return;
        }
        System.out.println("normal");
    }
}
