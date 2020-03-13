package com.sxt.sender;

import com.sxt.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderObject {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送对象
     * @param user
     */
    public void senderObject(User user){
        System.out.println("发送消息："+user);
        amqpTemplate.convertAndSend("object",user);
    }
}
