package com.startdima.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wuqh
 * @date 2020年3月13日 下午3:45:09
 * @Description
 * @version 1.0
 */
@Component
public class UserProvider {

	private static final String USER_NAME = "USER_MESSAGE:";

	@Value("${mq.exchange-name}")
	private String exchangeName;

	@Autowired
	AmqpTemplate amqpTemplate;

	/**
	 * 发送消息
	 * 
	 * @param message 消息体
	 */
	public void send(String message) {
		// 参数：交换器名称、路由键、消息体
		amqpTemplate.convertAndSend(exchangeName, "user.log.track", USER_NAME + "track-" + message);
		amqpTemplate.convertAndSend(exchangeName, "user.log.debug", USER_NAME + "debug-" + message);
		amqpTemplate.convertAndSend(exchangeName, "user.log.info", USER_NAME + "info-" + message);
		amqpTemplate.convertAndSend(exchangeName, "user.log.warn", USER_NAME + "warn-" + message);
		amqpTemplate.convertAndSend(exchangeName, "user.log.error", USER_NAME + "error-" + message);
	}

}
