package com.atguigu.service;

/**
 * 使用@ImportResource(locations = {"classpath:beans.xml"})注入bean，要标注在配置类上
 * 推荐使用@Configuration和@Bean往组件中注入bean
 */
public class HelloService {

    public String getHello(){
        return "helloService.getHello()";
    }
}
