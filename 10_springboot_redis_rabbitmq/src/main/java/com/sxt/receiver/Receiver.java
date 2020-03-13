package com.sxt.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct")
public class Receiver {
    /**
     * direct模式接收信息
     * @param message
     */
    @RabbitHandler
    public void receiverA(String message){
        System.out.println("direct接收到消息："+message);
    }
}


@Component
@RabbitListener(queues = "common")
class ReceiverTopic1{
    /**
     * topic模式接收信息
     * @param message
     */
    @RabbitHandler
    public void receiverTopic(String message){
        for (int i=1; i <=5; i++){
            System.out.println("user_common接收到信息:"+message+i);
        }
    }
}
@Component
@RabbitListener(queues = "vip")
class ReceiverTopic2{
    /**
     * topic模式接收信息
     * @param message
     */
    @RabbitHandler
    public void receiverTopic(String message){
        for(int i=1; i <=10; i++){
            System.out.println("user_vip接收到信息:"+message+i);
        }
    }
}

@Component
@RabbitListener(queues = "queue.B")
class ReceiverB{
    /**
     * fanout模式接收信息
     * @param message
     */
    @RabbitHandler
    public void receiverB(String message){
        System.out.println("B接收到消息："+message);
    }
}

@Component
@RabbitListener(queues = "queue.C")
class ReceiverC{
    /**
     * fanout模式接收信息
     * @param message
     */
    @RabbitHandler
    public void receiverC(String message){
        System.out.println("C接收到消息："+message);
    }
}

@Component
@RabbitListener(queues = "queue.D")
class ReceiverD{
    /**
     * fanout模式接收信息
     * @param message
     */
    @RabbitHandler
    public void receiverD(String message){
        System.out.println("D接收到消息："+message);
    }
}
