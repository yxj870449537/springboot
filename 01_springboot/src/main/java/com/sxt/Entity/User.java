package com.sxt.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String[] hobby;
    private List<String> lists;
    private Map<String,String> maps;
    private Set<String> sets;
    private Date birthday;
    @Email  //验证邮箱的格式
    private String email;

    @Override
    public String   toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", lists=" + lists +
                ", maps=" + maps +
                ", sets=" + sets +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
