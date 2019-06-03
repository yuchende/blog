package edu.xaut.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.xaut.bean.User;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String loginAccess() {
		if(username!=null&&password!=null) {
			if(username.equals("tom")&&password.equals("123")) {
				ActionContext.getContext().getSession().put("user",new User());
				ActionContext.getContext().getSession().put("loginStatus", "true");
				ActionContext.getContext().getSession().put("loginMsg", "isRight");
			}else {
				ActionContext.getContext().getSession().put("loginMsg", "isErr");
			}
			
		}else {
				ActionContext.getContext().getSession().put("loginMsg", "isErr");
		}
		return SUCCESS;
		
	}
	
}
