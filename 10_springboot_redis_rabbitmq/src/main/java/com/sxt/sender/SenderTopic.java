package com.sxt.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderTopic {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送信息
     * @param message
     */
    public void senderTopic1(String message){
        System.out.println("给common_user发送信息："+message);
        amqpTemplate.convertAndSend("topicExchange","user.common",message);
    }
    /**
     * 发送信息
     * @param message
     */
    public void senderTopic2(String message){
        System.out.println("给vip_user发送信息："+message);
        amqpTemplate.convertAndSend("topicExchange","user.vip",message);
    }
}
