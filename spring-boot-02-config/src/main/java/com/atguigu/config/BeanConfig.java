package com.atguigu.config;

import com.atguigu.service.BayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

/**
 * @ImportResource(locations = {"classpath:bean.xml"})用来注入spring配置文件中的bean（不推荐）
 * 使用@Configuration和@Bean注入
 * 默认生成都是单例
 */
@ImportResource(locations = {"classpath:bean.xml"})
@Configuration
public class BeanConfig {

    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public BayService bayService(){
        return new BayService();
    }
}
