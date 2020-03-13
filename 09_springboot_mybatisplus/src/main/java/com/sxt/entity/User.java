package com.sxt.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-11 09:13:55
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@TableName(value = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -19170220772803917L;

    @TableId(value = "id")//代表是主键
    private Integer id;
    
    private String username;
    
    private String sex;

    private Integer age;

    private Object birthday;
    
    private String address;
    
    private String password;

    public User(String username, String sex, Integer age, Object birthday, String address, String password) {
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.password = password;
    }
}