package com.sxt.config;

import com.sxt.entity.Student;
import com.sxt.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//@Configuration作用于类上，相当于一个xml配置文件
public class ConfigA {

    //@Bean作用于方法上，相当于xml配置中的<bean>
    @Bean("user")  //<bean id="user1" class="">
    public User getUser(){
        return new User();
    }
    @Bean("student")
    public Student getStudent(){
        return new Student("315130126","zhanasan",12);
    }
}