package com.startdima.mq.recever;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wuqh
 * @date 2020年3月13日 下午4:17:17
 * @Description
 * @version 1.0
 */
@Component
@RabbitListener(bindings = @QueueBinding(
		// 绑定队列名称
		value = @Queue(value = "${mq.info-queue}", autoDelete = "true"),
		// 绑定的交换器名称及类型
		exchange = @Exchange(name = "${mq.exchange-name}", type = ExchangeTypes.TOPIC),
		// 路由键名称
		key = "${mq.info-routing-key}"))
public class InfoRecever {

	@RabbitHandler
	public void process(String message) {
		System.out.println("info-receve:" + message);
	}
}
