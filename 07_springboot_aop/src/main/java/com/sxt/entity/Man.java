package com.sxt.entity;

import org.springframework.stereotype.Component;

@Component
public class Man {
    public void eat(){
        System.out.println("人吃饭");
//        int a=10/0;
    }
    public String sleep(String arg){
        System.out.println("睡觉");
        return "sleep";
    }

}
