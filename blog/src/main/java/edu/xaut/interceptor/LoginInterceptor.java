package edu.xaut.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.xaut.bean.User;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user=(User)ActionContext.getContext().getSession().get("user");
		
		if(user!=null) {
			System.out.println("-------------user is not null--------------------");
			//如果权限等级足够，设顶权限等级
			int level=Integer.parseInt(user.getLevel());	
			switch(level) {
				case 1: 
					ActionContext.getContext().getSession().put("level", "canDiscuss");  //canDiscuss  canWriteArt canDoEverything
					break;
				case 2:
					ActionContext.getContext().getSession().put("level", "canWriteArt");
					break;
				case 10:
					ActionContext.getContext().getSession().put("level", "canDoEverything");
					break;
			}
			System.out.println("-----------interceptor---------level--"+level+",="+ActionContext.getContext().getSession().get("level"));
			return invocation.invoke();
		}else {
			System.out.println("---------------------------------");
			System.out.println("-----------interceptor-----------");
			ActionContext.getContext().getSession().put("loginStatus", "false");
			return "redirectAction";
		}	
	}

}
