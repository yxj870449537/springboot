package com.sxt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ConfigA.class,ConfigB.class})//@Import注解 在创建配置文件之后可以引入其它的配置文件
public class ConfigAB {
}
