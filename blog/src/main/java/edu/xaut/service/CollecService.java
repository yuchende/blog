package edu.xaut.service;

import java.util.List;

import edu.xaut.bean.Article;
import edu.xaut.bean.Collec;

public interface CollecService {

	List<Collec> findCollecByID(int userID);
	int deleteArticle(int articleID);
	Article findArtiByID(int id, int userID);
}
