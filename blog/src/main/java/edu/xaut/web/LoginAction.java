package edu.xaut.web;
import javax.annotation.*;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;

import antlr.collections.List;
import edu.xaut.bean.User;
import edu.xaut.service.UserService;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	String username;
	String password;
	String qqloginurl;
	private HttpServletRequest request;
    private HttpServletResponse response;
    private User user1;
    private String level;
    private String levelContent;
	  @SuppressWarnings("restriction")
	  @Resource
	  private UserService userService;
	 
	  
    
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLevelContent() {
		return levelContent;
	}
	public void setLevelContent(String levelContent) {
		this.levelContent = levelContent;
	}
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
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
	public String findUserInfo() {
		User user=(User)ActionContext.getContext().getSession().get("user");
		user1=user;
		if("1".equals(user.getLevel())) {
			  level="A";
			  levelContent="您是初级用户，只能进行查看文章，评论文章，点赞等";
		}
		if("2".equals(user.getLevel())) {
			level="B";
			levelContent="您是中级用户，能进行查看文章，评论文章，点赞等，发表文章，删除与修改文章等";
		}
		if("10".equals(user.getLevel())) {
			level="Z";
			levelContent="您是管理员，可以想干嘛干嘛！";
		}
		return SUCCESS;
	}
	//回调action
	public String loginAccess() {
		if(username!=null&&password!=null) {
			User user=userService.findUserByName(username); 
			if(user!=null) {
			if(username.equals(user.getUsername())&&password.equals(user.getPassword())) {
				
		/*	if(username.equals("tom")&&password.equals("123")) {*/
				
				ActionContext.getContext().getSession().put("user",user);
				ActionContext.getContext().getSession().put("loginStatus", "true");
				ActionContext.getContext().getSession().put("loginMsg", "isRight");
				System.out.println(user.toString());
				
				
					}else {
								ActionContext.getContext().getSession().put("loginMsg", "isErr");
					}
			}else {
				ActionContext.getContext().getSession().put("loginMsg", "isErr");
			}
			
		}else {
				ActionContext.getContext().getSession().put("loginMsg", "isErr");
		}
		return SUCCESS;	
	}
	
	//QQ登陆
	public String login2Access() throws QQConnectException, IOException {

		System.out.println("qq登qq登陆qq登陆qq登陆qq登陆qq登陆陆");
		/* HttpServletRequest request = ServletActionContext.getRequest(); */
		//https://graph.qq.com/oauth2.0/authorize?client_id=101592111&redirect_uri=https://www.443chhsjl.cn/blog/login.action&response_type=code&state=04291a1603760dd06e13c351323d49ca&scope=get_user_info
		System.out.println(new Oauth().getAuthorizeURL(request));
		System.out.println("qq登qq登陆qq登陆qq登陆qq登陆qq登陆陆");
		/* response.sendRedirect(new Oauth().getAuthorizeURL(request)); */
		qqloginurl=new Oauth().getAuthorizeURL(request);
		 return "success2";
	}
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
		
	}
	public String getQqloginurl() {
		return qqloginurl;
	}
	public void setQqloginurl(String qqloginurl) {
		this.qqloginurl = qqloginurl;
	}
	
	
}
