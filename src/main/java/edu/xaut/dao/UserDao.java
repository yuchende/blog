package edu.xaut.dao;

import java.util.List;

import edu.xaut.bean.User;

public interface UserDao {
	public List<User> findAll();
	public int save(User us);
	public int delete(int id);
	
}
