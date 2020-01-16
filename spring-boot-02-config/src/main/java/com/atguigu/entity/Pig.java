package com.atguigu.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
 * 专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；
 */
@Component
@Data
public class Pig {

    @Value("${pig.name:huahua}")
    private String name;

    @Value("${pig.age:3}")
    private Integer age;
}
