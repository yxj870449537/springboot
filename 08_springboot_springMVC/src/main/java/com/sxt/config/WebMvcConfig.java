package com.sxt.config;

import com.sxt.inteceptor.MyInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //index/hello --->IndexController --->template/hello.html
//        registry.addRedirectViewController();
        //请求转发
//        registry.addViewController("/index/hello").setViewName("hello");
        //请求重定向
//        registry.addRedirectViewController("/index/hello","/userlist.html");

        //请求转发
        registry.addViewController("/index/list").setViewName("list");

    }

    /**格式转化器
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<Date>() {
            @Override
            public Date parse(String text, Locale locale) throws ParseException {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.parse(text);
            }
            @Override
            public String print(Date date, Locale locale) {
                return null;
            }
        });
    }

    /**
     * 自定义扩展消息转化器【平时不配，因为jaskson的转化器】
     */
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fc=new FastJsonHttpMessageConverter();
        FastJsonConfig config=new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fc.setFastJsonConfig(config);
        converters.add(fc);
    }*/

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInteceptor myInteceptor = new MyInteceptor();//bean
        registry.addInterceptor(myInteceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("index/addUser1");
    }*/

}
