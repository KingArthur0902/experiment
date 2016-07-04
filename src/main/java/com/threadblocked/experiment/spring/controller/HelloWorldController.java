package com.threadblocked.experiment.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ArthurTsang on 7/4/16.
 */
@RequestMapping(value = "/hello")
@Controller
public class HelloWorldController {

    /**
     * hello world
     * @param model
     */
    @RequestMapping(value = "/world")
    public void helloWorld(Model model){
        System.out.println("aaaaaaaaaaaaaaaa");
    }

    /**
     * uri 模板
     * @param id
     */
    @RequestMapping(value = "/{id}")
    public void hello(@PathVariable String id){
        System.out.println("id : " + id);
    }
}
