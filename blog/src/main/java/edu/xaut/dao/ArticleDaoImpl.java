package edu.xaut.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.xaut.bean.Article;

import javax.annotation.*;

@Repository("Article")
public class ArticleDaoImpl implements ArticleDao {
	@SuppressWarnings("restriction")
	@Resource
	private HibernateTemplate hibernateTemplate;

	public boolean save(Article art) {
		System.out.println("执行中");
		hibernateTemplate.save(art);
		System.out.println("执行完");
		return true;
	}
	
	
}
