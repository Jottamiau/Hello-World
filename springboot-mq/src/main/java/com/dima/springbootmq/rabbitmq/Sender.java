package com.dima.springbootmq.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void send(String message) {
        amqpTemplate.convertAndSend("hello-queue", message);
    }

}
