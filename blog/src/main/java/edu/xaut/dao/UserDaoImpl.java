package edu.xaut.dao;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.xaut.bean.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{
	@SuppressWarnings("restriction")
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<User> findAll() {
		String hql ="from User";
		return hibernateTemplate.find(hql);
	}
	public int save(User us) {
		hibernateTemplate.saveOrUpdate(us);
		return 1;
	}
	public int delete(int id) {
		hibernateTemplate.delete(hibernateTemplate.get(User.class, id));
		return 1;
	}
	
	 public boolean findUserByOpenID(String openID) {
		 String hql="from User us where us.openid='"+openID+"'";
		 List<User> list= hibernateTemplate.find(hql);
		 if(list.size()==1) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 public User findUserByOpenID2(String openID) {
		 String hql="from User us where us.openid='"+openID+"'";
		 List<User> list= hibernateTemplate.find(hql);
		 if(list.size()==1) {
			 User user=new User();
			 for(User uss:list) {
				 user=uss;
			 }
			 return user;
		 }else {
			 return null;
		 }
	 }
	  public User findUserByName(String name) { 
	  User user=new User();
		/*
		 * user.setUsername(name); List<User>
		 * list=hibernateTemplate.findByExample(user); for(User uss:list) { user=uss; }
		 */
	  String hql ="from User us where us.username='"+name+"'";
	  List<User> list= hibernateTemplate.find(hql);
	  for(User uss:list) { user=uss; }
	  return  user;
	  }
	 
}
