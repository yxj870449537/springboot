package com.sxt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String ano;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "ano='" + ano + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
