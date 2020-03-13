package com.startdima.mq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wuqh
 * @date 2020年3月13日 下午4:01:09
 * @Description
 * @version 1.0
 */
@Component
public class ProductProvider {

	private static final String PRODUCT_NAME = "PRODUCT_MESSAGE:";

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
		amqpTemplate.convertAndSend(exchangeName, "product.log.track", PRODUCT_NAME + "track-" + message);
		amqpTemplate.convertAndSend(exchangeName, "product.log.debug", PRODUCT_NAME + "debug-" + message);
		amqpTemplate.convertAndSend(exchangeName, "product.log.info", PRODUCT_NAME + "info-" + message);
		amqpTemplate.convertAndSend(exchangeName, "product.log.warn", PRODUCT_NAME + "warn-" + message);
		amqpTemplate.convertAndSend(exchangeName, "product.log.error", PRODUCT_NAME + "error-" + message);
	}

}
