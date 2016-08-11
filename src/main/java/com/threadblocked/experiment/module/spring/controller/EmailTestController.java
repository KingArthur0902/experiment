package com.threadblocked.experiment.module.spring.controller;

import com.threadblocked.experiment.module.spring.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ArthurTsang on 8/10/16.
 */
@RestController
@RequestMapping(value = "/email")
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/test1")
    public void test1(){
        emailService.testEmail();
    }


}
