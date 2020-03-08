package com.dima.springbootmq.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq配置类
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello-queue");
    }
}
