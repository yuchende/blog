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
    .insideContent{
    overflow:auto;
    }
    .insideContentson{

    }
    .w-e-text-container{

    height: 650px !important;
    }
    .nav1{
    height: 5em;
    width: 15em;
    margin: 0 auto;
    background-color: #F5F5DC;
    text-align: center;
    }
    .nav1 ul{
    list-style-type: none;
    display: inline-block;
    margin: 0;padding: 0;
    background-color: #3399CC;
    margin-top: 50px;


    border-top: 6px solid black;

    }
    .nav1 a{
    display:block;
    width: 10em;
    height: 5em;
    line-height: 5em;
    text-decoration: none;
    font-size: 15px;
    color: black;

    }
    .nav1 a:hover {
    background-color: #E6E6FA;
    }
	table{
    border-collapse:separate;
    border-spacing:0px 14px;;
		}
    .nav ul li {


    }
    </style>
    </head>
    <body>
    <div class="container" style="height:1500px;">
    <!--            <img src="b.jpg" class="img-responsive">-->
    <nav role="navigation" class="col-md-12 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
    <div class="container">
    <div class="navbar-header">
    <a href="article_main" class="navbar-brand">首页</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
    <li class="active"><a href="article_findAll">文章浏览</a></li>
    <li><a href="collection_findArti">文章管理</a></li>
    <li ><a href="articleSave">发表文章</a></li>
    <li><a href="userInfo">关于我</a></li>
    <li style="position:absolute;right:5px;">
                        <%  Object user=session.getAttribute("user"); if(user!=null){ %> <img style="display:inline-block;background-color:white;width:40px;height:40px;border-radius:20px;" alt="暂无头像" src="${sessionScope.user.face}"> <%  }else{  %><a onclick="show()">登陆</a></li><%     }%>  
              
    </ul>
    </div>
    </div>
    </nav>
    <div class="row col-md-12"  style="height:1500px;display: flex;justify-content:space-start;flex-wrap: none;">
    <div class="col-md-2 nav1" style="background-color:#3399CC;height: 1500px;overflow:auto;padding-top:10px;">
    <ul>
    <li style="border-bottom:1px solid #99CCFF"><a href="userInfo">个人信息 ☞</a></li>
    <li style="border-bottom:1px solid #99CCFF"><a href="#">权限申请 &nbsp;&nbsp;</a></li>
    <li style="border-bottom:1px solid #99CCFF"><a href="#">系统邮件  &nbsp;&nbsp;</a></li>
    </ul>

    </div>
    <div class="col-md-10 insideContent " style="background-color:rgba(255,255,255,0.8);height:1500px;">
    <table class="table" style="margin-top:80px;">
    <tbody>
    <tr><td>头像：</td><td><img style="display: inline-block;width:100px;height: 100px;" src="<s:property value="user1.face" />"></td></tr>
    <tr style="margin-top: 10px;"><td>昵称：</td><td><s:property value="user1.nickname" /></td></tr>   
    <tr ><td>用户名：</td><td><s:property value="user1.username" /></td></tr>
    <tr ><td>性别：</td><td><s:property value="user1.gender" /></td></tr>
    <tr><td>邮箱：</td><td>如abc.@126.com</td></tr>
  
    <tr><td>当前用户等级：</td><td><s:property value="level" /></td></tr>
    <tr><td>当前用户权限：</td><td><s:property value="levelContent" /></td></tr>

    </tbody>
    </table>

    </div>
    </div>
    </div>

    </body>
    </html>