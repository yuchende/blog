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
                    <li><a href="#">关于我</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row col-md-12"  style="height:1500px;display: flex;justify-content:space-start;flex-wrap: none;">
        <div class="col-md-2" style="background-color:rgba(153,204,255,0.47);height: 1500px;overflow:auto;padding-top:10px;">
        	<% if(null!=request.getAttribute("list")){ %>
            <ul>
            	<s:iterator value="list" status="st">
                <li style="border-bottom:1px solid black;margin-top:20px;"><a href="article_findByID?articleVar=<s:property value="varity" />&articlesigle=<s:property value="id" />"><s:property value="title" /></a></li>
                </s:iterator>    
            </ul>
            <% }%>
            <% if(null!=request.getAttribute("av")){ %>
            <ul>
            	<label style="border-bottom:1px solid black;font-size:18px;margin-top:10px;word-wrap:break-word;word-break:break-all; overflow: hidden; ">分类：<s:property value="av.varity" /></label>
            	<s:iterator value="av.set" status="st">
                        <li style="border-bottom:1px solid black;margin-top:10px;"><a href="article_findByID?articleVar=<s:property value="av.varity" />&articlesigle=<s:property value="id" />"><s:property value="title" /></a></li>
                </s:iterator>    
            </ul>
            <% }%>
            
        </div>
        <div class="col-md-10 insideContent " style="background-color:rgba(255,255,255,0.8);height:1500px; margin-left: 10px;">
        	
			<%
				String he=(String)request.getAttribute("article");
				if(he!=null){
				%>
				<h2 style="text-align:center;border-bottom:1px solid black;"><s:property value="name" /></h2>
        		<h5 style="text-align:left;font-weight:300;margin-top:20px;">文章描述：<s:property value="describe" /></h5>
				<% 
					out.println(he);
				}else{
					%>
					<s:iterator value="list" status="st">
					<div class="col-md-12">
							<div class="col-sm-12">
							<label style="margin-top:30px;"><a href="article_findByID?articlesigle=<s:property value="id" />"><s:property value="title" /></a></label>
							</div>
							<div class="col-sm-12" style="border-bottom:1px dashed gray;">
									<label style="margin-top:10px;font-weight:300;"><s:property value="mark" /></label>
							</div>
					</div>
						</s:iterator>  	
					<%
				}
			%>
        </div>
    </div>
</div>

</body>
</html>
