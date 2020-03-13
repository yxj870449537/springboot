package com.sxt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

//    @JSONField(name= "userid")   fastJson
    @JsonProperty(value="userid")  //Json
    private Integer id;
    private String name;
    private String address;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss") fastJson
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//Json
    private Date birth;
}
