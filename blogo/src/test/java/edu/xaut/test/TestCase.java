package edu.xaut.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xaut.bean.User;
import edu.xaut.dao.UserDaoImpl;
import edu.xaut.service.UserService;
import edu.xaut.service.UserServiceImpl;

public class TestCase {

	public static void main(String[] args) {
	   
	   
	}
	//查询所有数据
	@Test
	public void test1() {

		ClassPathXmlApplicationContext ca;
		ca = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
		UserService us = ca.getBean("UserService",UserService.class);
		List<User> list = us.findAll();
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	//模糊查询
	@Test
	public void test2() {

/*		UserDaoImpl ud = new UserDaoImpl();
		
		List<User> list = ud.queryUser("s");
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
	}
	
}
