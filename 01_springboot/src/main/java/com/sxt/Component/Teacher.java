package com.sxt.Component;

import com.sxt.Entity.Person;
import org.springframework.stereotype.Component;

@Component
public class Teacher implements Person {

    @Override
    public void doWork() {
        System.out.println("上课");
    }
}
