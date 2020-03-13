package com.sxt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -19170220772803917L;

    @NotNull(message = "用户id不能为空")
    private Integer id;

    @NotBlank(message = "用户姓名不能为空")
    @Length(min = 16, max = 20, message = "长度必须在16到20之间")
    private String username;

    private String sex;

    @Size(min = 1, max = 120, message = "年龄应该在0~120之间")
    private Integer age;

    private Integer address;

    @Past(message = "出生日期必须是一个过去的日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    private String password;
}
