package edu.xaut.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
/*import com.qq.connect.oauth.Oauth*/
import com.qq.connect.oauth.Oauth;

import edu.xaut.bean.User;
import edu.xaut.service.UserService;
import javax.annotation.*;

public class AfterLoginAction extends ActionSupport{
	@SuppressWarnings("restriction")
	@Resource
	private UserService userService;
	
	private User user1;
	private String level;
	private String levelContent;
	
	
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


	public String loginAccess() throws QQConnectException {
		
			System.out.println("回调地址被执行    https://www.443chhsjl.cn/blog/login2.action");
		

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			//利用request获取AccessToken
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			String accessToken = null,
			openID = null;
			long tokenExpireIn = 0L;
			
			if (accessTokenObj.getAccessToken().equals("")) {
			
			System.out.print("没有获取到响应参数");
			
			}else{
			
			//利用accessTokenObj对象获取  accessToken值
			accessToken = accessTokenObj.getAccessToken();
			tokenExpireIn = accessTokenObj.getExpireIn();
			
			//利用accessToken值获取openID
			OpenID openIDObj = new OpenID(accessToken);
			openID = openIDObj.getUserOpenID();
			
			//利用accessToken和openID   获取用户信息对象
			UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
			UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
			 
			ActionContext.getContext().getSession().put("name", userInfoBean.getNickname());
			ActionContext.getContext().getSession().put("avatar", userInfoBean.getAvatar().getAvatarURL30());	
			ActionContext.getContext().getSession().put("openID", openID);
			ActionContext.getContext().getSession().put("gender", userInfoBean.getGender());
			
			//
			//Cookie[] ck=request.getCookies();
			//存入或更行数据库
			
			  User user=new User(); user.setNickname(userInfoBean.getNickname());
			  user.setFace(userInfoBean.getAvatar().getAvatarURL30());
			  user.setOpenid(openID); user.setGender(userInfoBean.getGender());
			  //如果数据库中没有当前用户，那么设置当前用户的level为1
			  boolean hasUser=userService.findUserByOpenID(openID);
			  if(hasUser==false) {
				  user.setLevel("1"); 
				  //先保存后，就有id的
				  //再次查询，就有将id导入到user
				  userService.save(user);
				  level="A";
				  levelContent="您是初级用户，只能进行查看文章，评论文章，点赞等";
			  }	  
			  user=userService.findUserByOpenID2(openID);
			  user1=user;
			  //这里是没有id的
			 ActionContext.getContext().getSession().put("user",user);
			if("2".equals(user.getLevel())) {
				level="B";
				levelContent="您是中级用户，能进行查看文章，评论文章，点赞等，发表文章，删除与修改文章等";
			}
			if("10".equals(user.getLevel())) {
				level="Z";
				levelContent="您是管理员，可以想干嘛干嘛！";
			}
			/*
			 * //存入cookie中 Cookie cok=new Cookie("nickname",userInfoBean.getNickname());
			 * Cookie cok2=new Cookie("password",openID); cok.setMaxAge(-1);
			 * cok2.setMaxAge(-1); response.addCookie(cok); response.addCookie(cok2);
			 */
			
			return SUCCESS;
			}
			return SUCCESS;
}
}
