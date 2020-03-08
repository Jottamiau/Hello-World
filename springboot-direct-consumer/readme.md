# 1.rabbitmq消费者入门案例

###1.1RabbitMq连接参数配置

```yaml
#连接基础配置
spring:
  rabbitmq:
    host: 192.168.2.225
    username: root
    password: 123456
    port: 5672
    
#mq消费者配置
rabbitmq:
  config:
    log:
    #队列名称
      queue-name: 
        info: log.queue.info
        error: log.queue.error
    #交换器名称
      exchange-name:
        info: log.exchange.info
        error: log.exchange.error
    #路由键名称
      routing-key-name:
        info: log.routing-key.info
        error: log.routing-key.error
      
```

### 1.2消息消费类

```java
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
```

### 1.3流程说明

​	一、生产者向Rabbit MQ服务器发送一条消息：其中消息包含消息头：{交换器名称、路由键名称}和消息体。

​	二、消费者监听事件触发、根据消息头中的交换器名称找到交换器、接着通过路由键找到绑定的队列名称、从队列里获取到消息体。