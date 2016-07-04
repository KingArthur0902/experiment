package com.threadblocked.experiment.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ArthurTsang on 7/4/16.
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/helloworld")
    public void helloWorld(Model model){
        System.out.println("aaaaaaaaaaaaaaaa");
    }
}
