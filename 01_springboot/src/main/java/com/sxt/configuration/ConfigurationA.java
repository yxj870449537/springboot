package com.sxt.configuration;


import com.sxt.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationA {
    @Bean("student1")
    public Student getStudent(){
        return new Student();
    }
    @Bean("student2")
    public Student getStudent1(){
        return new Student("315130126","zhanasan",12);
    }
}
