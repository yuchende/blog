package edu.xaut.service;

import java.util.List;
import javax.annotation.*;
import org.springframework.stereotype.Service;

import edu.xaut.bean.Collec;
import edu.xaut.dao.CollecDao;

@Service("CollecService")
public class CollecServiceImpl implements CollecService {
	@SuppressWarnings("restriction")
	@Resource
	private CollecDao collecDao;
	
	public List<Collec> findCollecByID(int userID) {
		
		return collecDao.findCollecByID(userID);
	}

	public int deleteArticle(int articleID) {
		return collecDao.deleteArticle(articleID);
	}
}
