package com.atguigu.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 使用@PropertySource读取指定类路径下自定义配置文件（只能读取properties）
 * 还是需要搭配@Component和ConfigurationProperties
 */
@PropertySource(value = {"classpath:people.properties"})
@Component
@ConfigurationProperties(prefix = "people")
@Data
public class People {

    private String type;

    private Integer number;
}
