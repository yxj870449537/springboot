package com.sxt.Configuration;

import com.sxt.Component.Teacher;
import com.sxt.Entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationB {

    @Bean("teacher")
    public Person getTeacher(){
        return new Teacher();
    }
}
