package com.sxt.config;

import com.sxt.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {
    @Bean
    public Student getStudent(){
        return new Student();
    }
}
