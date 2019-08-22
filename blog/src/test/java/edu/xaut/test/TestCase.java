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
		
		for(User us1: list) {
			System.out.println(us1.toString());
		}
		
		//创建对象阶段
		User user=new User();
		user.setOpenid("D331837A57E94DB1538A7D1630B06EF2");
		
		
		String openID="D331837A57E94DB1538A7D1630B06EF2";
		boolean hasUser=us.findUserByOpenID(openID);
		 System.out.println("2111111111");
		 if(hasUser==false) {
			 System.out.println("3111111111");
			 user.setLevel("1");
			 us.save(user);
			 System.out.println("4111111111");
		 }
		 
		 
		/*
		 * if(hasUser==false) { System.out.println("3111111111"); user.setLevel("1");
		 * System.out.println("4111111111"); //先保存后，就有id的 //再次查询，就有将id导入到user
		 * us.save(user); System.out.println("1111111111"); }
		 */
		
		user=us.findUserByOpenID2(openID);
		System.out.println(user.toString());
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
