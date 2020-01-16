package com.atguigu;

import com.atguigu.entity.Person;
import com.atguigu.entity.Pig;
import com.atguigu.entity.People;
import com.atguigu.service.BayService;
import com.atguigu.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	People people;

	@Autowired
	Pig pig;

	@Autowired
	HelloService helloService;
	@Autowired
	HelloService helloService1;

	@Autowired
	BayService bayService;

	@Autowired
	BayService bayService1;

	@Test
	void contextLoads() {
		//读取全局配置文件application.yml使用@component和@ConfigurationProperties
		System.out.println(person);
		//读取自定义配置文件people.properties使用@Component和ConfigurationProperties和@PropertiesResource
		System.out.println(people);
		//指定注入值@Value和@Component
		System.out.println(pig);
		//通过bean.xml配置文件和@ImportResource注入的bean
		System.out.println(helloService.getHello());
		//通过@Configuration和@Bean注入的对象
		System.out.println(bayService.getBay());
		//看看注入的bean是单例还是多例 都是true说明默认是单例
		System.out.println(helloService==helloService1);
		System.out.println(bayService==bayService1);
	}

}
