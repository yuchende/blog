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
		#hidebg { position:absolute;left:0px;top:0px;
  	  background-color:#000;
    	width:100%;  /*宽度设置为100%，这样才能使隐藏背景层覆盖原页面*/
    	filter:alpha(opacity=60);  /*设置透明度为60%*/
    	opacity:0.6;  /*非IE浏览器下设置透明度为60%*/
    	display:none; /* http://www.jb51.net */
    	z-Index:2;}
	#hidebox { position:absolute;width:400px;height:400px;top:200px;left:30%;background-color:#fff;cursor:pointer;z-Index:3;border-top: 1px solid gray;
    	border-bottom:1px solid gray;padding-top:50px;background-color: rgba(248,248,255,0.5);border-radius:6px; display:none;}
	#content { text-align:center;cursor:pointer;z-Index:1;}
    </style>
    <script>
        function show()  //显示隐藏层和弹出层
        {
            var hideobj=document.getElementById("hidebg");
            hidebg.style.display="block";  //显示隐藏层
            hidebg.style.height=document.body.clientHeight+"px";  //设置隐藏层的高度为当前页面高度
            document.getElementById("hidebox").style.display="block";  //显示弹出层
        }
        function hide()  //去除隐藏层和弹出层
        {
            document.getElementById("hidebg").style.display="none";
            document.getElementById("hidebox").style.display="none";
        }
    </script>
</head>
<body>
<div id="hidebg"></div>

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
                    <li><a href="userInfo">关于我</a></li>
                    <li style="position:absolute;right:5px;">
                        <%  Object user=session.getAttribute("user"); if(user!=null){ %> <img style="display:inline-block;background-color:white;width:40px;height:40px;border-radius:20px;" alt="暂无头像" src="${sessionScope.user.face}"> <%  }else{  %><a onclick="show()">登陆</a></li><%     }%>  
                </ul>
            </div>
        </div>
    </nav>
  	<div id="hidebox" class="login col-xs-offset-1"   style="text-align: center; ">
    			       <h4 style="margin-top:60px;">
           对不起！
       </h4>
    <h5 style="padding-top: 10px;">您没有相应的权限</h5>
    <h5 style="padding-top: 10px;"><a href="#">请点击这里！申请权限</a></h5>
    <h5>或者进入个人信息面板，申请权限</h5>
    <h4 style="padding-top: 10px;">谢谢配合！</h4>
   </div>
    <div class="row" >
        <div id="rowContent" class="col-md-12" >
            <div class="col-md-12" style="height: 100px;background-color: rgba(255,255,255,0.6)">

            </div>
            <div class="col-md-12 " style="height: 900px;background-color: rgba(255,255,255,0.7);overflow: auto;">
                                   
                    <% String level=(String)session.getAttribute("level");
                    	if("canDiscuss".equals(level)){
                    		%> 
                    			<ul>
                    				<li>
                    					<label>java</label>
                    					<ul>
                    							<li>
                    									<a  href="#"><button type="button" class="btn btn-xs btn-default positionBlocA" style="border-radius:17px;">删除</button></a>&nbsp;&nbsp;
                                    					<a  href="#"><button type="button" class="btn btn-xs btn-default positionBlocA" style="border-radius: 17px;">修改</button></a>&nbsp;&nbsp;
                                    					<a href="#">关于集合的使用</a>
                    							</li>
                    					</ul>
                    				</li>
                    			</ul>
                    		    <script >show();</script>
                    		<%
                    	}else{
                    %>
                    <%  Object ob=request.getAttribute("res2");%>
                    <%  if(null!=ob){ %>
                     <ul>
                    <s:iterator value="res2" status="st">
                    	<li>
                        	<label><s:property value="varity"></s:property></label>
                        	<ul>
                       		 	<s:iterator value="set" status="st">
                               	 <li>
                                    	<a  href="collection_delete?id=<s:property value="id"/>"><button type="button" class="btn btn-xs btn-default positionBlocA" style="border-radius:17px;">删除</button></a>&nbsp;&nbsp;
                                    	<a href="collection_update?id=<s:property value="id"/>"><button type="button" class="btn btn-xs btn-default positionBlocA" style="border-radius: 17px;">修改</button></a>&nbsp;&nbsp;
                                    	<a href="#"><s:property value="title"/></a>
                               	 </li>
                                </s:iterator>
                        	</ul>
                    	</li>
                    </s:iterator>
                </ul>
                <%}else{
                	%> 
                	<h2 style="text-align:center;">空空如也！快去添加您的文章吧！</h2>
                	<%
                } %>
                <% }%>

                    
     
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