package com.sxt;

import com.sxt.entity.Man;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Man man;
    @Test
    void contextLoads() {
//        man.eat();
//        String sleep = man.sleep("小明");
//        System.out.println(sleep);
        List<String> list1 = new ArrayList<>();
        list1.add("8");
        list1.add("9");
        list1.add("7");
        list1.add("5");
        list1.add("7");
        System.out.println(list1);
        Set list2 = new HashSet<String>();

        for (int i=0 ; i< list1.size();i++){
            list2.add(list1.get(i));
        }
        System.out.println(list2);
    }

}
