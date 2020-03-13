package com.sxt;


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
    private Integer studenId;
    private String studentName;

    @Override
    public String toString() {
        return "Student{" +
                "studenId=" + studenId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
