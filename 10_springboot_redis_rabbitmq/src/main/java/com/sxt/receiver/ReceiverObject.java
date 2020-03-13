package com.sxt.receiver;

import com.sxt.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverObject {

    /**
     * 接收对象
     * @param user
     */
    @RabbitHandler
    @RabbitListener(queues = "object")
    public void receiverObject(User user){
        System.out.println("接收对象："+user);
    }
}
