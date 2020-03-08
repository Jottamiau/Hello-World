#RabbitMq入门案例
##1.搭建RabbitMq环境
###1.1使用Docker搜索带有后端管理的镜像
**命令：docker search rabbitmq:management**
###1.2拉取镜像
**命令：docker pull rabbitmq:management**
###1.3创建容器
**命令：docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=123456 -p 15672:15672 -p 5672:5672 rabbitmq:management**
###1.4访问后端管理界面
**地址：安装Docker的Linux主机地址:15672**
##2.创建springboot项目
###2.1在application.yaml配置RabbitMq连接参数
**基本参数：
spring:
  rabbitmq:
    host: 192.168.2.225
    username: root
    password: 123456
    port: 5672**
###2.1编码实现
**创建RabbitMq配置类并配置Bean、
创建Sender类用于向队列发送消息、
创建Receive类用于接收队列中的消息、
测试类中测试发送消息能否正常接收**