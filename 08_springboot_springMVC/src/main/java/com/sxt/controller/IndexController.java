package com.sxt.controller;

import com.sxt.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("list")
    public String list(){
        return "list";
    }
    /**
     * 格式化
     */
    @RequestMapping("addUser1")
    @ResponseBody
    public Map<String,Object> addUser1(@DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")Date birth) {
        Map<String,Object> map = new HashMap<>();
        System.out.println(birth.toLocaleString());
        map.put("msg","success");
        return map;
    }

    @RequestMapping("addUser2")
    @ResponseBody
    public Map<String,Object> addUser2(Date birth){
        Map<String,Object> map = new HashMap<>();
        System.out.println(birth.toLocaleString());
        map.put("msg","success");
        return map;
    }

    /*@RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        return new User(1,"xiaoming","wuahan",new Date());
    }*/
}
