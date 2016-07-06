package com.threadblocked.experiment.spring.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by ArthurTsang on 7/4/16.
 */
@Controller
@RequestMapping(value = "/hello")
@SessionAttributes("aaa")
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

    @ModelAttribute
    public int getAaa(){
        return 123;
    }
    /**
     * 使用@ModelAttribute注解的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
     */
    @ModelAttribute
    public void init(ModelMap model){
        model.put("aaa",getAaa());
    }

    /**
     * 使用ModelAttribute 获得数据
     * @param model
     */
    @RequestMapping(value = "/something3")
    public void hello5(ModelMap model){
        System.out.println(model.get("aaa"));
        model.addAttribute("aaa",222);
    }
    /**
     * 使用ModelAttribute 获得数据
     * @param aaa
     */
    @RequestMapping(value = "/something3/aaa")
    public void hello5(@ModelAttribute String aaa){
        System.out.println(aaa);
    }
    /**
     * 获取请求头部数据
     * @param encoding
     * @param host
     */
    @RequestMapping(value = "/something4")
    public void hello6(@RequestHeader("Accept-Encoding") String encoding,
                                  @RequestHeader("Host") String host) {
        System.out.println(encoding);
        System.out.println(host);
    }

    /**
     * 接收矩阵变量
     * @param vars
     * @param avars
     */
    @RequestMapping(value = "/something5/{sid}/anything/{aid}")
    public void hello7(@MatrixVariable Map<String,String> vars,@MatrixVariable(pathVar = "aid") Map<String,String> avars){
        System.out.println(vars);
        System.out.println(avars);
    }

    /**
     * 使用HttpEntity
     * @param requestEntity
     */
    @RequestMapping(value = "/something6")
    public ResponseEntity<String> hello8(HttpEntity<byte[]> requestEntity){
        String requestHeader = requestEntity.getHeaders().getFirst("myRequestHeader");
        byte[] requestBody = requestEntity.getBody();
        System.out.println(requestHeader);
        System.out.println(requestBody);

        HttpHeaders responeHeaders = new HttpHeaders();
        responeHeaders.set("myResponseHeader","bbbbbbbbbbb");
        return new ResponseEntity<String>("hello world",responeHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/something7")
    public void hello9(@CookieValue String JSESSIONID){
        System.out.println(JSESSIONID);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


}
