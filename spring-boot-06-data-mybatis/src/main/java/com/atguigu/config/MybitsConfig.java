package com.atguigu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//开启扫描指定包下的mapper
@Configuration
@MapperScan(value = "com.atguigu.mapper")
public class MybitsConfig {

    //配置mybits自定义规则，给容器中添加一个ConfigurationCustomizer
    //这里设置开启驼峰映射规则
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {

        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启字段驼峰映射规则
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }

}
