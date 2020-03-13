package com.sxt.config;

import com.sxt.WebThreeComponents.AppFilter;
import com.sxt.WebThreeComponents.AppListener;
import com.sxt.WebThreeComponents.UserServlet;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "web")
@Data
public class WebConfig {
    private Boolean applistenerEnable=true;
    /**
     * 创建UserServlet
     */
    @Bean("userServlet")
    @ConditionalOnClass(value = UserServlet.class)
    public UserServlet userServlet(){
        return new UserServlet();
    }

    /**
     * 注册UserServlet
     */
    @Bean
    @ConditionalOnBean(value={UserServlet.class})
    public ServletRegistrationBean<UserServlet> servletServletRegistrationBean(UserServlet userServlet){
//    public ServletRegistrationBean<UserServlet> servletRegistrationUserBean(){
//        UserServlet userServlet = new UserServlet();
        //创建注册器对象
        ServletRegistrationBean<UserServlet> registrationBean = new ServletRegistrationBean<>();
        //注入Servlet
        registrationBean.setServlet(userServlet);
        //设置参数
        registrationBean.addInitParameter("env","UTF-8");
        registrationBean.addInitParameter("hello","你好");
        //设置映射
        registrationBean.addUrlMappings("/user1.action","/user2.action");
        return registrationBean;
    }

    /**
     * 创建Filter
     */
    @Bean("appFilter")
    @ConditionalOnClass(value = {AppFilter.class})
    public AppFilter appFilter(){
        return new AppFilter();
    }

   /**
     * 注册Filter
     */
    @Bean
    @ConditionalOnBean(value = {AppFilter.class})
    public FilterRegistrationBean<AppFilter> filterFilterRegistrationBeanAppFilter(AppFilter appFilter){
        //创建注册器
        FilterRegistrationBean<AppFilter> registrationBean = new FilterRegistrationBean<>();
        //注入filter
        registrationBean.setFilter(appFilter);
        //设置参数
        registrationBean.addInitParameter("env","filter-UTF-8");
        registrationBean.addInitParameter("hello","filter-你好");
        //设置映射
//        registrationBean.addUrlPatterns("/*");
        registrationBean.addServletNames("userServlet");
        return registrationBean;
    }

    /**
     * 创建Listener
     */
    @Bean
    @ConditionalOnClass(value={AppListener.class})
    public AppListener appListener(){
        return new AppListener();
    }
    @Bean
    @ConditionalOnBean(value = {AppListener.class})
    public ServletListenerRegistrationBean<AppListener> servletListenerRegistrationBeanAppListener(AppListener appListener){
        //创建注册器
        ServletListenerRegistrationBean<AppListener> bean = new ServletListenerRegistrationBean<AppListener>();
        //注入listener
        bean.setListener(appListener);
        bean.setEnabled(applistenerEnable);
        return bean;
    }
}
