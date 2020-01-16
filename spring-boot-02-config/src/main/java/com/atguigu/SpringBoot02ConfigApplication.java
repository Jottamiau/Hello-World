package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1、在配置文件中指定:
//		spring.profiles.active=dev
//2、命令行：
//		java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；
//		可以直接在测试的时候，配置传入命令行参数
//3、虚拟机参数；
//		-Dspring.profiles.active=dev
//4、springboot 启动会扫描以下位置的application.properties或者application.yml文件作为Spring boot的默认配置文件
//		–file:./config/
//		–file:./
//		–classpath:/config/
//		–classpath:/
//		优先级由高到底，高优先级的配置会覆盖低优先级的配置；
//		SpringBoot会从这四个位置全部加载主配置文件；**互补配置**；

@SpringBootApplication
public class SpringBoot02ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02ConfigApplication.class, args);
	}

}
