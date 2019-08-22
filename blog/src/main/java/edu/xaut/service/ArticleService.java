package edu.xaut.service;

import java.util.List;

import edu.xaut.bean.Article;

public interface ArticleService {
	public boolean save(Article art); 
	public List<Article> findAll(int userID);
	public Article findArtiByID(int id,int userID);
	public List<Article> findAllWithOutUserID();
}
