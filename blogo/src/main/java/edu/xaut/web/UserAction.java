package edu.xaut.web;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.*;
import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.User;
import edu.xaut.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{
	
	@SuppressWarnings("restriction")
	@Resource
	private UserService userService;
	private List<User> us;
	private User user;
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUs() {
		return us;
	}

	public void setUs(List<User> us) {
		this.us = us;
	}

	public String findAll() {
		us = userService.findAll();
		return SUCCESS;
	}
	public String add() {
		
		
		if(user==null) {
			return "reload";
		}else {
		System.out.print(user.toString());
		int succ=userService.save(user);
		if(succ==1) {
			return SUCCESS;
		}else {
			return "reload";
		}
		
		}
	}
	public String delete() {
		System.out.println("-----1"+id+"----");
		userService.delete(id);
		return SUCCESS;
	}

}
