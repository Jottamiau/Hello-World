package com.startdima.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wuqh
 * @date 2020年3月13日 下午4:07:32
 * @Description
 * @version 1.0
 */
@Component
public class OrderProvider {

	private static final String ORDER_NAME = "ORDER_MESSAGE:";

	@Value("${mq.exchange-name}")
	private String exchangeName;

	@Autowired
	AmqpTemplate amqpTemplate;

	/**
	 * 发送消息
	 * 
	 * @param message 消息
	 */
	public void send(String message) {
		amqpTemplate.convertAndSend(exchangeName, "order.log.track", ORDER_NAME + "track-" + message);
		amqpTemplate.convertAndSend(exchangeName, "order.log.debug", ORDER_NAME + "debug-" + message);
		amqpTemplate.convertAndSend(exchangeName, "order.log.info", ORDER_NAME + "info-" + message);
		amqpTemplate.convertAndSend(exchangeName, "order.log.warn", ORDER_NAME + "warn-" + message);
		amqpTemplate.convertAndSend(exchangeName, "order.log.error", ORDER_NAME + "error-" + message);
	}

}
