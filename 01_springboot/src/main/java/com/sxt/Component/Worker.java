package com.sxt.Component;

import com.sxt.Entity.Person;
import org.springframework.stereotype.Component;

@Component
public class Worker implements Person {
    @Override
    public void doWork() {
        System.out.println("工作");
    }
}
