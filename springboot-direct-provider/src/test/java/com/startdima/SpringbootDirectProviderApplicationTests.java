package com.startdima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.startdima.mq.Sender;

@SpringBootTest
class SpringbootDirectProviderApplicationTests {

	@Autowired
	Sender sender;

	@Test
	void contextLoads() throws Exception {
		while (Boolean.TRUE) {
			Thread.sleep(1000);
			sender.send("hello rabbitmq!");
		}
	}

}
