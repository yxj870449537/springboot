package com.sxt.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueDirect(){
        return new Queue("direct");
    }

    @Bean
    public Queue queueObject(){
        return new Queue("object");
    }

    @Bean
    public  Queue common(){
        return new Queue("common");
    }

    @Bean
    public Queue vip(){
        return new Queue("vip");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingTopicExchangeB(Queue common, TopicExchange topicExchange){
        return BindingBuilder.bind(common).to(topicExchange).with("user.common");//#代表匹配0或者多个,*代表匹配1个
    }

    @Bean
    public Binding bindingTopicExchangeC(Queue vip, TopicExchange topicExchange){
        return BindingBuilder.bind(vip).to(topicExchange).with("user.*");//#代表匹配0或者多个,*代表匹配1个
    }

    @Bean
    public Queue queueB(){
        return new Queue("queue.B");
    }

    @Bean
    public Queue queueC(){
        return new Queue("queue.C");
    }

    @Bean
    public Queue queueD(){
        return new Queue("queue.D");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingFanoutExchangeB(){
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutExchangeC(){
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutExchangeD(){
        return BindingBuilder.bind(queueD()).to(fanoutExchange());
    }
}
