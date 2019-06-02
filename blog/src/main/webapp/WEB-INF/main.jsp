<%@ page language="java" contentType="text/html; charset=utf-8"
                                   pageEncoding="utf-8"%>
                                   <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
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
    <div id="content" class="container" style="height:1000px;">
<!--            <img src="b.jpg" class="img-responsive">-->
        <nav role="navigation" class="col-md-offset-2 col-md-8 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
            <div class="container">
                <div class="navbar-header " style="border:1px solid gray;padding-left: 10px;">
                    <a href="article_main" class="navbar-brand">首页</a>
                 </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="article_findAll">文章</a></li>
                        <li><a href="collection">收藏</a></li>
                        <li ><a href="article_save">写文章</a></li>
                        <li><a href="#">关于我</a></li>
                        <li style="position:absolute;right:5px;"><a onclick="show()">登陆</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div  id="rowContent" class="row">
        		<s:iterator value="list" status="st">
                 <div class="col-md-3 sizeOfA bacgroundA positionBlocA">
                     <div class="col-sm-12 blockCustomInside" >
                         <label style=""><a href="article_findByID?articlesigle=<s:property value="id" />"><s:property value="title"/></a></label>
                     </div>
                     <a href="article_findByID?articlesigle=<s:property value="id" />" style="color:black;">
                     <div class="col-sm-12 blockCustomInside2" >
                         <label style="font-weight: 100"><s:property value="mark"/></label>
                     </div>
                     </a>
                 </div>
				</s:iterator>
                 <!-- 
                 </div>
                 <div class="col-md-2 bacgroundA positionBlocB " style="height: 400px;">
                     <div class="col-sm-12" style="height:20px;background-color: rgba(255,255,204,0.5);text-align: center;margin-top:50px;">
                         <label style="">二叉树的应用</label>
                     </div>
                     <div class="col-sm-12" style="height:310px;background-color: rgba(02,102,153,0.12);margin-top: 5px">
                         <label style="font-weight: 100">二叉树的应用sdfjsld解放拉萨酱豆腐睡觉了对方就是劳动法就了</label>
                     </div>

                 </div>


                 <div class="col-md-3 bacgroundA positionBlocC" style="height: 190px;" >
                     <div class="col-sm-12" style="height:20px;background-color: rgba(255,255,204,0.5);text-align: center;margin-top:50px;">
                         <label style="">二叉树的应用</label>
                     </div>
                     <div class="col-sm-12" style="height:100px;background-color: rgba(02,102,153,0.12);margin-top: 5px">
                         <label style="font-weight: 100">二叉树的应用sdfjsld解放拉萨酱豆腐睡觉了对方就是劳动法就了</label>
                     </div>

                 </div> -->


        </div>


    </div>
	<div id="hidebox" class="login col-xs-offset-1" >
    <form role="form" class="form-horizontal col-sm-offset-1 formposition">

        <div class="form-group">
            <label class="col-sm-12 control-label" style="font-weight:600;font-size:25px;text-align: center;margin-bottom: 15px;">欢迎登陆&nbsp;&nbsp;&nbsp;Myblog</label>
            <div style="">
                <input type="button" style=" position:absolute; right:5px;top:5px;" class="btn btn-danger btn-xs" value="✖" onclick="hide()">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">name:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="name" placeholder="请输入邮箱或者手机号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">password:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" name="name" placeholder="请输入密码">
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
                <input type="submit" class="form-control btn btn-default btn-sm" value="注册">
            </div>
        </div>
    </form>
</div>

</body>
</html>