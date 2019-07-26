package edu.xaut.dao;

import java.util.List;
import javax.annotation.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.xaut.bean.Article;
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
	public int deleteArticle(int articleID) {
		Article article=new Article();
		article.setId(articleID);
		hibernateTemplate.delete(article);
		return 1;
	}
	public Article findArtiByID(int id, int userID) {
		// TODO Auto-generated method stub
		String hql="from Article ar where ar.id="+id+"and ar.userID="+userID;
		List<Article> list=hibernateTemplate.find(hql);
		Article ar=null;
		for(Article art:list) {
			ar=art;
		}
		return ar;
	}
}
