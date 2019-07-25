<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<title>添加用户</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath() %>/css/style2.css" />
	</head>

	<body>

		<div id="wrap">
			<div id="content">
			<div class="head0">
					<h1 class="head">
						添加员工:
					</h1>
				</div>	
					<form class="tabl" action="add.action" method="get">
						<table cellpadding="0" cellspacing="0" border="0"
							>
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="text" name="user.id" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" name="user.username"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" name="user.name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									<input type="text" name="user.gender" />
								</td>
							</tr>
								<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="text" name="user.password" />
								</td>
							</tr>
							</tr>
													
						</table>
						<p>
							<input type="submit" class="button" value="保存" />
							<input type="reset" class="button" value="重置" class="button"/><br/>
							<span style="color:red;"><s:property value="message"/></span>
						</p>
					</form>
				
			
			<div class="foot">
					<p class="foot_son">bbc@gog.cpm</p>
				</div>
			</div>
		</div>
	</body>
</html>
