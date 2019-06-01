package edu.xaut.service;

import java.util.List;
import javax.annotation.*;
import org.springframework.stereotype.Service;

import edu.xaut.bean.User;
import edu.xaut.dao.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@SuppressWarnings("restriction")
	@Resource
	private UserDao ud;
	public List<User> findAll() {
		
		return ud.findAll();
	}
	public int save(User us) {
		return ud.save(us);
	}
	public int delete(int id) {	
		return ud.delete(id);
	}
}
