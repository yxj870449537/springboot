package com.sxt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Validated
//@ConfigurationProperties(prefix = "user")
public class User {
    @Value("${user.id}")
    private Integer id;
    @Value("${user.name}")
    private String name;
    //    @Value("${user.hobby}")
    private String[] hobby;
    //    @Value("${user.lists}")
    private List<String> lists;
    //    @Value("${user.maps}")
    private Map<String, String> maps;
    //    @Value("${user.sets}")
    private Set<String> sets;
    @Value("${user.age}")
    private Integer age;
    @Value("${user.birth}")
    private Date birth;
    //    @Email  //验证邮箱格式
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", lists=" + lists +
                ", maps=" + maps +
                ", sets=" + sets +
                ", age=" + age +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }
}
