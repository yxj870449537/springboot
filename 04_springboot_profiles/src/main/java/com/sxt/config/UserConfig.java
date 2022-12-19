package com.sxt.config;

import com.sxt.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UserConfig {
    @Bean
    @Profile("dev")
    public User getUser1(){
        return new User(1,"jsx");
    }
    @Bean
    @Profile("pro")
    public User getUser2(){
        return new User(2,"jsx");
    }

}
