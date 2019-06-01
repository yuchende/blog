package edu.xaut.dao;

import java.util.List;
import javax.annotation.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.xaut.bean.Collec;

@Repository("CollecDao")
public class CollecDaoImpl implements CollecDao {

	@SuppressWarnings("restriction")
	@Resource
	private HibernateTemplate hibernateTemplate;
	public List<Collec> findCollecByID(int userID) {
		String hql="from Collec cl where cl.userID="+userID;
		return hibernateTemplate.find(hql);
	}
	
	
}
