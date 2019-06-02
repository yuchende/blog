package edu.xaut.dao;

import java.util.List;

import edu.xaut.bean.Article;

public interface ArticleDao {
	public boolean save(Article art); 
	public List<Article> findAll(int userID);
	public Article findArtiByID(int id,int userID);
}
