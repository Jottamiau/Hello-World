package com.startdima.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wuqh
 * @date 2020年3月8日 下午9:03:54
 * @Description
 * @version 1.0
 */
@Component
public class Sender {

	@Autowired
	AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.config.log.exchange-name}")
	private String exchangeName;

	@Value("${rabbitmq.config.log.routing-key-name}")
	private String routingKeyName;

	/**
	 * 生产者发送消息
	 * 
	 * @param message
	 */
	public void send(String message) {
		// 参数一:交换器名称
		// 参数二:路由键名称
		// 参数三:发送的消息
		amqpTemplate.convertAndSend(exchangeName, routingKeyName, message);
	}

}
