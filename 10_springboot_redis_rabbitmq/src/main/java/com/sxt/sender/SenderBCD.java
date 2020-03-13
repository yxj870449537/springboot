package com.sxt.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderBCD {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送信息
     * @param message
     */
    public void senderBCD(String message){
        System.out.println("发送消息："+message);
        amqpTemplate.convertAndSend("fanoutExchange","", message);
    }
}
