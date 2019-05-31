package edu.xaut.service;

import java.util.List;

import edu.xaut.bean.User;

public interface UserService {
	public List<User> findAll();
	public int save(User us);
	public int delete(int id);
}
