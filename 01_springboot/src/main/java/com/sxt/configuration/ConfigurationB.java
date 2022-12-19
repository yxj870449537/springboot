package com.sxt.configuration;

import com.sxt.component.Teacher;
import com.sxt.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationB {

    @Bean("teacher")
    public Person getTeacher(){
        return new Teacher();
    }
}
