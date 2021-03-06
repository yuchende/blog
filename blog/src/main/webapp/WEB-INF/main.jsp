<%@ page language="java" contentType="text/html; charset=utf-8"
                                   pageEncoding="utf-8"%>
                                   <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
   <%--  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-1.10.2.min.js"></script> --%>
	
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script>
        $(document).ready(function(){
            $("#clickToShow").click(function(){
                $(".clicktoInsert").fadeIn(2500);
                $("#clicktohide").fadeOut('slow');
            });
        });
    </script>
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
    <style type="text/css">
 				.bakstyle:hover{opacity:0.6;filter:alpha(opacity=200);background-color: rgb(0,0,0);font-weight: 600;color:#FFFFFF;}
 				 .artHoverFontColor{ text-decoration:none;color:black;}
    </style>
</head>
<body>
	<div id="hidebg"></div>
    <div id="content" class="container" style="height:1500px;">
<!--            <img src="b.jpg" class="img-responsive">-->
        <nav role="navigation" class="col-sm-12 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
            <div class="container">
                <div class="navbar-header " style="border:1px solid gray;padding-left: 10px;">
                    <a href="article_main" class="navbar-brand">首页</a>
                 </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="article_findAll">文章浏览</a></li>
                        <li><a href="collection_findArti">文章管理</a></li>
                        <li ><a href="articleSave">发表文章</a></li>
                        <li><a href="userInfo">关于我</a></li>
                        <li style="position:absolute;right:5px;">
                        <%  Object user=session.getAttribute("user"); if(user!=null){ %><a href="login_unlogin" style="color:white;position:relative;right:60px;">退出登陆</a>  <img style="display:inline-block;background-color:white;width:40px;height:40px;border-radius:20px;position:relative;bottom:43px;" alt="暂无头像" src="${sessionScope.user.face}"> <%  }else{  %><a onclick="show()">登陆</a></li><%     }%>  
                    </ul>
                </div>
            </div>
        </nav>
        		
        <div  id="rowContent" class="row" style="overflow:auto;">
        		<%  int i=1;  %>
        		<s:iterator value="res" status="st">
                 <div class="col-md-10 col-md-offset-1" style="border:15px solid  rgba(0,0,0,0.5);;margin-top: 20px;display: flex;justify-content:space-around;flex-wrap: wrap;
                   border-top:8px solid rgba(0,0,0,0.8);border-radius: 15px;
                    ">
                    <div class="col-md-12" style="border-bottom:2px solid gray;height:50px;">
                        <label class=" mouseHoverEvent  col-md-12" style="margin-top:20px;font-size:20px;background-color:gray;color: white;text-align:left;">文章分类：<s:property value="varity" /></label>
                    </div>
             
                    <div class="col-md-12" style="display: flex;justify-content:flex-start;flex-wrap: wrap;" >
						<s:iterator value="set" status="st">
							<%	if(i<4){%>
                        <div class="col-md-3 sizeOfA bacgroundA positionBlocA bakstyle">
                            <div class="col-sm-12 blockCustomInside" >
                                <label style=""><a href="article_findByID?articlesigle=<s:property value="id" />"><s:property value="title"/></a></label>
                            </div>
                            <div class="col-sm-12 blockCustomInside2" >
                              	<a  class='artHoverFontColor'  href="article_findByID?articlesigle=<s:property value="id" />"> <label style="font-weight: 100"><s:property value="mark"/></label></a>
                            </div>
                        </div>
                        <%}else{ %>
                        	<div class="col-md-3 sizeOfA bacgroundA positionBlocA bakstyle clicktoInsert" style="display:none;">
                            <div class="col-sm-12 blockCustomInside" >
                                <label style=""><a href="article_findByID?articlesigle=<s:property value="id" />"><s:property value="title"/>   </a></label>
                            </div>
                            <div class="col-sm-12 blockCustomInside2" >
                               <a class='artHoverFontColor' href="article_findByID?articlesigle=<s:property value="id" />"> <label style="font-weight: 100"><s:property value="mark"/></label></a>
                            </div>
                        </div>
                        <%} %>
                        <% i++; %>

                     	</s:iterator>
						<%  %>
						<s:if test="set.size()>3">
                       			<div id='clicktohide' class=" col-md-3  sizeOfA bacgroundA positionBlocA bakstyle">
                           			 	<div id="clickToShow" class="col-sm-12 blockCustomInside3" >
                               			 			<label style="margin-left: 17px;margin-top: 60px;font-size:20px;font-weight: 100; ">点击加载</label>
                          				  </div>
                        </div>
                       </s:if>

                    </div>
                </div>
                <% i=1; %>
                   </s:iterator>
        </div>


    </div>
	<div id="hidebox" class="login col-xs-offset-1"  style="height:440px;">
    <form role="form" action="login_loginAccess" class="form-horizontal col-sm-offset-1 formposition" method="post">

        <div class="form-group">
            <label class="col-sm-12 control-label" style="font-weight:600;font-size:25px;text-align: center;margin-bottom: 15px; white-space:pre;"> 欢迎登陆&nbsp;&nbsp;&nbsp;Myblog&#10; </label>
           <h6 style="position: absolute;top: 90px;/*! text-align: center; */left: 140px;">非管理员请用其他能录方式</h6>
            <div >
                <input type="button" style=" position:absolute; right:5px;top:5px;" class="btn btn-danger btn-xs" value="✖" onclick="hide()">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-11">
                <input type="text" class="form-control" name="username" placeholder="请输入邮箱或者手机号"  >
            </div>
        </div>
        <div class="form-group">
            <!-- <label class="col-sm-2 control-label">密码:</label> -->
            <div class="col-sm-11">
                <input type="password" class="form-control" name="password" placeholder="请输入密码" >
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-11 ">
                <input type="submit" class="form-control btn btn-success btn-sm" value="登陆">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-11 ">
                <input type="reset" class="form-control btn btn-info btn-sm" value="重置">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-11 ">
                <!-- <input type="submit" class="form-control btn btn-default btn-sm"  value="注册"> -->
                <button type="button" class="form-control btn btn-default btn-sm"  data-toggle="collapse" data-target="#demo">其他登陆方式</button>
                <div id="demo" class="collapse">
                		<div class="col-sm-2">
                				<a href="login_login2Access"><img alt="" style="margin-top:7px;width:33px;height:33px;" src="pic/qq.png"></a>
                		</div>
				</div>							
            </div>
        </div>
    </form>
</div>
	<%
		String statusMsg=(String)session.getAttribute("loginMsg");
		response.setContentType("text/html;charset=utf-8");
		if(statusMsg!=null){
			out.println(statusMsg);
			if(statusMsg.equals("isRight")){
				out.println("<script>alert(\"登陆成功！祝您访问愉快！\");</script>");
			}
			if(statusMsg.equals("isErr")){
				out.println("<script>alert(\"登陆失败！请检查您的账户！\");</script>");
			}
			session.setAttribute("loginMsg",null);
		}
	%>
	<script>
		var status=${sessionScope.loginStatus};	

		if(status!=null){//status为空
			if("false"===status){
				 show();
				<% session.setAttribute("loginStatus",null);%>
			}
			if(status===false){//status不为空,且登陆状态为false，则弹出登陆框
				 show();
				<% session.setAttribute("loginStatus",null);%>
			}
		}
	</script>
</body>
</html>