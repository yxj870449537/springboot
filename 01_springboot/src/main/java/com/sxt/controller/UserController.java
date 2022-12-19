package com.sxt.controller;

import com.sxt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private User user;

    @RequestMapping("hello")
    @ResponseBody
    public String helloUser(){
        return "hello world";
    }

    @RequestMapping("user")
    @ResponseBody
    public User userInfo(){
        System.out.println(user.toString());
        return user;
    }
}
