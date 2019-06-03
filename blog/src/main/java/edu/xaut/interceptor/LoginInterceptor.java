package edu.xaut.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object user=ActionContext.getContext().getSession().get("user");
		if(user!=null) {
			System.out.println("-------------user is not null--------------------");
			return invocation.invoke();
		}else {
			System.out.println("---------------------------------");
			System.out.println("-----------interceptor-----------");
			ActionContext.getContext().getSession().put("loginStatus", "false");
			return "redirectAction";
		}	
	}

}
