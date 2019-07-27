package edu.xaut.web;

import javax.servlet.http.HttpServletRequest;

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


public class AfterLoginAction extends ActionSupport{
	
	public String loginAccess() throws QQConnectException {
		
			System.out.println("回调地址被执行    https://www.443chhsjl.cn/blog/login2.action");
		

			HttpServletRequest request = ServletActionContext.getRequest();
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			String accessToken = null,
			openID = null;
			long tokenExpireIn = 0L;
			
			if (accessTokenObj.getAccessToken().equals("")) {
			
			System.out.print("没有获取到响应参数");
			
			}else{
			
			accessToken = accessTokenObj.getAccessToken();
			
			tokenExpireIn = accessTokenObj.getExpireIn();
			
			OpenID openIDObj = new OpenID(accessToken);
			
			openID = openIDObj.getUserOpenID();
			
			UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
			
			UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
			 
			ActionContext.getContext().getSession().put("name", userInfoBean.getNickname());
			ActionContext.getContext().getSession().put("avatar", userInfoBean.getAvatar().getAvatarURL30());	
			
			return SUCCESS;
			}
			return SUCCESS;
}
}
