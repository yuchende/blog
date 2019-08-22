package edu.xaut.service;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.*;
import edu.xaut.bean.Article;
import edu.xaut.dao.ArticleDao;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
	@SuppressWarnings("restriction")
	@Resource
	private ArticleDao articleDao;
	
	public boolean save(Article art) {
		articleDao.save(art);
		return true;
	}

	public List<Article> findAll(int userID) {
		return articleDao.findAll(userID);
	}

	public Article findArtiByID(int id, int userID) {
		return articleDao.findArtiByID(id, userID);
	}

	public List<Article> findAllWithOutUserID() {
		// TODO Auto-generated method stub
		return articleDao.findAllWithOutUserID();
	}
	
}
