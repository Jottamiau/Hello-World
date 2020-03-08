package com.startdima.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wuqh
 * @date 2020年3月8日 下午9:15:50
 * @Description
 * @version 1.0
 */
@Component
//rabbitmq事件监听器
@RabbitListener(bindings = @QueueBinding(
		// @QueueBinding-value:配置绑定的队列
		// @Queue-value:配置队列的名称
		// @Queue-autoDelete:是否是临时队列
		value = @Queue(value = "${rabbitmq.config.log.queue-name.info}", autoDelete = "true"),
		// @QueueBinding-exchange:配置绑定的交换器
		// @Exchange-value:配置交换器的名称
		// Exchange-type:配置交换器的类型
		exchange = @Exchange(value = "${rabbitmq.config.log.exchange-name.info}", type = ExchangeTypes.DIRECT),
		// @QueueBinding-key:配置队列和交换绑定的{路由键名称}
		key = "${rabbitmq.config.log.routing-key-name.info}"))
public class InfoReceiver {

	@RabbitHandler
	public void proccess(String message) {
		System.out.println("info....." + message);
	}

}
