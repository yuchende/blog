<%--
Created by IntelliJ IDEA.
User: yuchende
Date: 2019/5/27
Time: 21:13
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
        #rowContent{
            height: 1000px;
            border:1px solid rgba(112,128,144,0.2);
            border-top:0;
            background-color:rgba(255,255,255,0.5);
        }
        ::-webkit-scrollbar{
            display: none;
        }
        .positionBlocA{
            margin-bottom:2px;
        }

    </style>
</head>
<body>
<div class="container" style="height:1000px;">
    <!--            <img src="b.jpg" class="img-responsive">-->
    <nav role="navigation" class="col-md-12 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
        <div class="container">
            <div class="navbar-header">
                <a href="article_main" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="article_findAll">文章浏览</a></li>
                    <li class="active"><a href="collection_findArti">文章管理</a></li>
                    <li ><a href="articleSave">发表文章</a></li>
                    <li><a href="#">关于我</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="row" >
        <div id="rowContent" class="col-md-12" >
            <div class="col-md-12" style="height: 100px;background-color: rgba(255,255,255,0.6)">

            </div>
            <div class="col-md-12 " style="height: 900px;background-color: rgba(255,255,255,0.7);overflow: auto;">
                <ul>

                    <!--<li><button type="button" class="btn btn-success btn-xs positionBlocA" style="margin-left: 0px;">增加分类</button></li>-->
                    <s:iterator value="res2" status="st">
                    	<li>
                        	<label><s:property value="varity"></s:property></label>
                        	<ul>
                       		 	<s:iterator value="set" status="st">
                               	 <li>
                                    	<a  href="collection_delete?id=<s:property value="id"/>"><button type="button" class="btn btn-xs btn-default positionBlocA" style="border-radius:17px;">删除</button></a>&nbsp;&nbsp;
                                    	<a></a><button type="button" class="btn btn-xs btn-default positionBlocA" style="border-radius: 17px;">修改</button></a>&nbsp;&nbsp;
                                    	<a href="#"><s:property value="title"/></a>
                               	 </li>
                                </s:iterator>
                        	</ul>
                    	</li>
                    </s:iterator>
                </ul>
            </div>
        </div>
    </div>
    
	<script >
		var isDeleteSuccess=${sessionScope.isDeleteSuccess}	
			if(isDeleteSuccess===1){
				alert('删除成功！');
				<%
				session.setAttribute("isDeleteSuccess",null);
				%>
			}
		
	</script>



</div>


</body>
</html>