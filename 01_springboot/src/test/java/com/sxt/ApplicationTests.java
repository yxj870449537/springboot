package com.sxt;


import com.sxt.Entity.Student;
import com.sxt.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"com.sxt.config"})//@ComponentScan("com.sxt")配置扫描
class ApplicationTests {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("student1")//qualifier的意思是合格者,bean的没有定义名字，无法确定哪个，加上名字并选择哪个为合格者
    private Student student;

    @Test
    void contextLoads() {
//        System.out.println(user);
//        System.out.println(student);
    }
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ParentConfig.class);

    }
}
