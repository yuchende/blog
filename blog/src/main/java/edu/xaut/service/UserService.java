package edu.xaut.service;

import java.util.List;

import edu.xaut.bean.User;

public interface UserService {
	public List<User> findAll();
	public int save(User us);
	public int delete(int id);
	 public User findUserByName(String name); 
	 public boolean findUserByOpenID(String openID);
	 public User findUserByOpenID2(String openID);
	 public User findUserByID(int userID);
}
