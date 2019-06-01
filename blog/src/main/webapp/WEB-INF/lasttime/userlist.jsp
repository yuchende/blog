<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
 <link rel="stylesheet" type="text/css" href="css/style.css" />
<title>显示用户</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
		<script type="text/javascript">
			function deleteUser(id){
				window.confirm(id);
				var r = window.confirm("你确定要删除该员工吗？");
				if(r){
					window.location.href="deleteUser.action?id="+id;
				}
			}
		</script>
</head>
<body>
<div id="wrap">
	<div id="content">
	<form class="head0" action="QueryUserAction.action" method="post">
		<p class="head">Welcome!</p>
		UserName： <input type="text" name="queryText" value="${searchText }" />
		<input type="submit" value="查询" />
	</form>
					<table  class="tabl" border="1" cellspacing="0" >
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								UserName
							</td>
							<td>
								Name
							</td>
							<td>
								Sex
							</td>
							<td>
								Password
							</td>
							<td>
								Operations
							</td>
						</tr>
						<s:iterator value="us" status="st">
						<tr class="row1">
							<td>
								<s:property value = "id"/>
							</td>
							<td>
								<s:property value = "username"/>
							</td>
							<td>
								<s:property value = "name"/>
							</td>
							<td>
								<s:property value = "gender"/>
							</td>
							<td>
								<s:property value = "password"/>
							</td>
							<td>
								<a href="javascript:deleteUser(<s:property value="id"/>);">delete user</a>&nbsp;
								<a href="toUpdate?emp_id=<s:property value="id"/>">update user</a>
							</td>
						</tr>
						</s:iterator>
					</table>
					<div class="butto">
						<input type="button" class="button" value="Add user" onclick="location.href='add.action'"/>
					</div>
					<!-- 分页 -->
					<div id="pages">
                	<c:if test="${page==1}">
                		<a href="#">上一页</a>
                	</c:if>
                	<c:if test="${page!=1}">
	        	        <a href="findByPage.action?page=${page-1 }">上一页</a>
                	</c:if>
        	        <!-- 循环输出页码 -->
        	        <c:forEach begin="1" end="${totalPage}" var="i">
        	        	<c:if test="${i==page}">
	                    	<a href="findByPage.action?page=${i }" >${i }</a>
        	        	</c:if>
        	        	<c:if test="${i!=page}">
        	        		<a href="findByPage.action?page=${i }">${i }</a>
        	        	</c:if>
                    </c:forEach>
                    <c:if test="${page==totalPage}">
                    	<a href="#">下一页</a>
                    </c:if>
                    <c:if test="${page!=totalPage}">
	                    <a href="findByPage.action?page=${page+1 }">下一页</a>
                    </c:if>
                </div>
				<div class="foot">
					<p class="foot_son">bbc@gog.cpm</p>
				</div>
		</div>
		</div>
</body>
</html>