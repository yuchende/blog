<%--

  Date: 12-12-4
  Time: 上午10:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  
  
    <p>欢迎  ${sessionScope.name}</p>
	<p>欢迎  ${sessionScope.gender}</p>
	<p>欢迎  ${sessionScope.openID}</p>
    <img alt="" src="${sessionScope.avatar}">
    
    
  </body>
</html>