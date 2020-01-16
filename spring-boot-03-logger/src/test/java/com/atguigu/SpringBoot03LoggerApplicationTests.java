package com.atguigu;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringBoot03LoggerApplicationTests {

	/**
	 * 通过调整logback-spring.xml日志输出级别可调整输出日志
	 * 也可以通过修改全局配置文件调整日志输出日志级别
	 * logback.xml加上-spring可增加一些特殊功能如springProfile
	 * logback.xml：直接就被日志框架识别了；
	 * logback-spring.xml：日志框架就不直接加载日志的配置项，由SpringBoot解析日志配置，可以使用SpringBoot的高级Profile功能
	 * @Slf4j使用lombok引入
	 */
	@Test
	void contextLoads() {
		log.trace("this level is trace");
		log.debug("this level is debug");
		log.info("this level is info");
		log.warn("this level is warn");
		log.error("this level is error");
	}

}
