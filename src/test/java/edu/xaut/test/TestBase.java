package edu.xaut.test;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {

	protected ClassPathXmlApplicationContext ca;
	public TestBase() {
		super();
	}
	@Before
	public void init() {
		ca = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
	}
	@Test
	public void test() throws SQLException{
		System.out.println(ca);
	}

}