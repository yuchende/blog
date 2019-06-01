package edu.xaut.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class TestConnection {
	/**
	 * 测试数据库连接
	 */
	@SuppressWarnings("resource")
	@Test
	public void test() throws SQLException {
		ClassPathXmlApplicationContext ca;
		ca = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
		DataSource ds = ca.getBean("dataSource",DataSource.class);
		System.out.println(ds.getConnection());
	}
}
