# 1.rabbitmq生产者入门案例

###1.1RabbitMq连接参数配置

```yaml
#连接基础配置
spring:
  rabbitmq:
    host: 192.168.2.225
    username: root
    password: 123456
    port: 5672
    
#日志mq消息配置
rabbitmq:
  config: 
    log:
      #交换器名称
      exchange-name: log.exchange.error
      #路由键名称
      routing-key-name: log.routing-key.error
            
```

### 1.2消息生产类

```java
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
```

### 1.3流程说明

​	一、生产者向Rabbit MQ服务器发送一条消息：其中消息包含消息头：{交换器名称、路由键名称}和消息体。

​	二、消费者监听事件触发、根据消息头中的交换器名称找到交换器、接着通过路由键找到绑定的队列名称、从队列里获取到消息体。