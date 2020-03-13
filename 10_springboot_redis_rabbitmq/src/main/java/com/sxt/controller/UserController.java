package com.sxt.controller;

import com.sxt.domain.User;
import com.sxt.sender.Sender;
import com.sxt.sender.SenderBCD;
import com.sxt.sender.SenderObject;
import com.sxt.sender.SenderTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Sender sender;

    @Autowired
    private SenderObject senderObject;

    @Autowired
    private SenderTopic senderTopic;

    @Autowired
    private SenderBCD senderBCD;

    @GetMapping("saveToRedis")
    @ResponseBody
    public String saveToRedis(String key,String value){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set(key,value);
        return "success";
    }

    @GetMapping("sendToRabbit")
    @ResponseBody
    public String sendToRabbit(String message) {
        sender.senderMessage(message);
        return "success";
    }

    @RequestMapping("sendToRabbitObject")
    @ResponseBody
    public String sendToRabbitObject(User user){
        senderObject.senderObject(user);
        return "success";
    }

    @RequestMapping("sendToRabbitTopic")
    @ResponseBody
    public String sendToRabbitTopic(String message1,String message2){
        senderTopic.senderTopic1(message1);
        senderTopic.senderTopic2(message2);
        return "seccuss";
    }

    @GetMapping("sendToRabbitFanoutExchange")
    @ResponseBody
    public String sendToRabbitFanoutExchange(String message){
        senderBCD.senderBCD(message);
        return "success";
    }
}
