package edu.xaut.dao;

import java.util.List;

import edu.xaut.bean.Article;
import edu.xaut.bean.Collec;

public interface CollecDao {
	List<Collec> findCollecByID(int userID);
	int deleteArticle(int articleID);
	Article findArtiByID(int id,int userID);
	
}
