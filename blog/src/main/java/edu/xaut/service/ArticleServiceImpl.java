package edu.xaut.service;

import org.springframework.stereotype.Service;
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
	
}
