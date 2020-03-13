package com.sxt.sender;

import com.sxt.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送信息
     * @param message
     */
    public void senderMessage(String message){
        System.out.println("发送消息："+message);
        amqpTemplate.convertAndSend("direct",message);//queue名称,发送信息
    }

}
