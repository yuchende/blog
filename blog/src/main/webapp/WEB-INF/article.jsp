<%--
  Created by IntelliJ IDEA.
  User: yuchende
  Date: 2019/5/27
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
         <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <style type="text/css">
        body{
            background-color: #CCCCCC;
        }
        .row{
            margin-top: 100px;
        }

    </style>
</head>
<body>
<div class="container" style="height:1000px;">
    <!--            <img src="b.jpg" class="img-responsive">-->
    <nav role="navigation" class="col-md-offset-2 col-md-8 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
        <div class="container">
            <div class="navbar-header">
                <a href="main.html" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="aritcle.html">文章</a></li>
                    <li><a href="love.html">收藏</a></li>
                    <li ><a href="wirteAritcle.html">写文章</a></li>
                    <li><a href="#">关于我</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row">
        <div class="col-md-2" style="background-color:rgba(153,204,255,0.47);height: 1000px;">
            <ul>
                <li><a href="#">文章1 分时间段卢卡斯京东方逻辑上的法律上电费</a></li>
                <li><a href="#">文章2</a></li>
                <li><a href="#">文章3</a></li>
                <li><a href="#">文章4</a></li>
                <li><a href="#">文章5</a></li>
                <li><a href="#">文章6</a></li>
                <li><a href="#">文章7</a></li>
                <li><a href="#">文章7</a></li>
            </ul>
        </div>
        <div class="col-md-10" style="background-color:rgba(255,255,255,0.8);height:1000px; margin-left: 0px;">
			<%
				String html=(String)request.getParameter("article");
				out.println(html);
			%>
        </div>


    </div>


</div>

</body>
</html>
