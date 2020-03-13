package com.startdima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.startdima.mq.sender.OrderProvider;
import com.startdima.mq.sender.ProductProvider;
import com.startdima.mq.sender.UserProvider;

@SpringBootTest
class SpringbootTopicProviderApplicationTests {
	
	@Autowired
	UserProvider userProvider;
	
	@Autowired
	ProductProvider productProvider;
	
	@Autowired
	OrderProvider orderProvider;

	@Test
	void contextLoads() {
		userProvider.send("I am userProvider");
		productProvider.send("I am productProvider");
		orderProvider.send("I am orderProvider");
	}

}
