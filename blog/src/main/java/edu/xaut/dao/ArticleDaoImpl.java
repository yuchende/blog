package edu.xaut.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.xaut.bean.Article;

import java.util.List;

import javax.annotation.*;

@Repository("Article")
public class ArticleDaoImpl implements ArticleDao {
	@SuppressWarnings("restriction")
	@Resource
	private HibernateTemplate hibernateTemplate;

	public boolean save(Article art) {
		System.out.println("执行中");
		/* hibernateTemplate.save(art); */
		hibernateTemplate.saveOrUpdate(art);
		System.out.println("执行完");
		return true;
	}

	public List<Article> findAll(int userID) {
		// ;
		String hql="from Article art where art.userID="+userID;
		return hibernateTemplate.find(hql);
	}
	public List<Article> findAllWithOutUserID(){
		String hql="from Article";
		return hibernateTemplate.find(hql);
	}
	public Article findArtiByID(int id, int userID) {
		// TODO Auto-generated method stub
		String hql="from Article ar where ar.id="+id;/*+"and ar.userID="+userID;*/
		List<Article> list=hibernateTemplate.find(hql);
		Article ar=null;
		for(Article art:list) {
			ar=art;
		}
		return ar;
	}
	
	
}
