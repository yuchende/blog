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
		hibernateTemplate.save(us);
		return 1;
	}
	public int delete(int id) {
		hibernateTemplate.delete(hibernateTemplate.get(User.class, id));
		return 1;
	}
	
	
}
