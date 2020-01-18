package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //注入Druid数据源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druid() {
        return new DruidDataSource();
    }

    //配置Druid后台
    //1.配置Druid后台Servlet处理
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //处理所有访问/druid/*下的请求
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        //后台登录用户名
        initParams.put("loginUsername", "root");
        //后台登录密码
        initParams.put("loginPassword", "123456");
        //白名单
        initParams.put("allow", "");
        //黑名单
        initParams.put("deny", "192.168.2.182");
        bean.setInitParameters(initParams);
        return bean;
    }

    //2.配置Druid后台filter处理
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setFilter(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
