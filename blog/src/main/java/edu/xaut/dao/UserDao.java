package edu.xaut.dao;

import java.util.List;

import edu.xaut.bean.User;

public interface UserDao {
	public List<User> findAll();

	public int save(User us);

	public int delete(int id);
	 public User findUserByName(String name); 
	 public boolean findUserByOpenID(String openID);
	 public User findUserByOpenID2(String openID);
}
