package com.atguigu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBoot06JdbcApplicationTests {

	/**
	 * 配置好数据源参数后会自动注入到DataSource并配置JdbcTemplate
	 */
	@Autowired
	DataSource dataSource;


	@Test
	void contextLoads() throws SQLException {
		//获取数据源加载类
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
