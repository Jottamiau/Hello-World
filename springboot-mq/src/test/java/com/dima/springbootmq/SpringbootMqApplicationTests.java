package com.dima.springbootmq;

import com.dima.springbootmq.rabbitmq.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMqApplicationTests {

	@Autowired
	Sender sender;
	/**
	 * 测试消息发送与接收
	 */
	@Test
	void contextLoads() {
		sender.send("hello rabbitmq!");
	}

}
