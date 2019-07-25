package edu.xaut.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xaut.bean.Article;
import edu.xaut.bean.User;
import edu.xaut.dao.ArticleDao;
import edu.xaut.dao.ArticleDaoImpl;
import edu.xaut.dao.UserDaoImpl;
import edu.xaut.service.UserService;
import edu.xaut.service.UserServiceImpl;

public class TestCase {

	public static void main(String[] args) {
	   
	   
	}
	//��ѯ��������
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
	
	//ģ����ѯ
	@Test
	public void test2() {

/*		UserDaoImpl ud = new UserDaoImpl();
		
		List<User> list = ud.queryUser("s");
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
		
		System.out.println("124");
		ArticleDaoImpl ar=new ArticleDaoImpl();
		System.out.println("123");
		//Article art=ar.findArtiByID(1, 1);
		System.out.println("122");
		//System.out.println(art.toString());
		List<Article> list=ar.findAll(1);
		for(Article art:list) {
			System.out.println(art.toString());
		}
	}
	
}
