package com.threadblocked.experiment.spring.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void hello0(Model model){
        System.out.println("aaaaaaaaaaaaaaaa");
    }

    /**
     * uri 模板
     * @param id
     */
    @RequestMapping(value = "/{id}")
    public void hello1(@PathVariable String id){
        System.out.println("id : " + id);
    }

    /**
     * 传参数
     * @param name
     */
    @RequestMapping(value = "/something0")
    public void hello2(@RequestParam String name){
        System.out.println(name);
    }

    /**
     * 请求body
     * @param body
     * @param writer
     * @throws IOException
     */
    @RequestMapping(value = "/something1",method = RequestMethod.PUT)
    public void hello3(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }


    /**
     * 返回body
     * @return
     */
    @RequestMapping(value = "/something2",method = RequestMethod.GET)
    public String hello4(){
        return "helloWorld";
    }
    /**
     * 使用@ModelAttribute注解的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
     */
    @ModelAttribute
    public void init(ModelMap model){
        model.put("aaa",123);
    }

    /**
     * 使用ModelAttribute 获得数据
     * @param model
     */
    @RequestMapping(value = "/something3")
    public void hello5(ModelMap model){
        System.out.println(model.get("aaa"));
    }

    /**
     * 获取请求头部书记胡
     * @param encoding
     * @param host
     */
    @RequestMapping(value = "/something4")
    public void hello6(@RequestHeader("Accept-Encoding") String encoding,
                                  @RequestHeader("Host") String host) {
        System.out.println(encoding);
        System.out.println(host);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
