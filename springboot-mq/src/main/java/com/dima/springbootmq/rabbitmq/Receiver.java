package com.dima.springbootmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 */
@Component
public class Receiver {


    /**
     * 队列事件监听器-指定队列名称为hello-queue
     */
    @RabbitListener(queues = "hello-queue")
    public void process(String message) {
        System.out.println("receiver:" + message);
    }
}
