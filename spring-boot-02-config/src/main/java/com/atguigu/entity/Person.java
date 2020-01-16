package com.atguigu.entity;



import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 注意点：
 * @Component
 * @ConfigurationProperties(prefix = "person")
 * 读取的是全局配置文件
 * 1.要通过配置文件注入值，需要是容器中的组件
 * 2.要通过配置文件注入值，需要提供set方法
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {

    private String lastName;
    private Integer age;
    private Boolean boss;

    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

}
