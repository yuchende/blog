<%--
  Created by IntelliJ IDEA.
  User: yuchende
  Date: 2019/5/27
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        .w-e-text-container{

            height: 450px !important;
        }
        ::-webkit-scrollbar{
    		width: 0;
    		height: 0;
    		color: transparent;
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
  	<div id="hidebox" class="login col-xs-offset-1"   style="text-align: center; ">
    			       <h4 style="margin-top:60px;">
           对不起！
       </h4>
    <h5 style="padding-top: 10px;">您没有相应的权限</h5>
    <h5 style="padding-top: 10px;"><a href="#">请点击这里！申请权限</a></h5>
    <h5>或者进入个人信息面板，申请权限</h5>
    <h4 style="padding-top: 10px;">谢谢配合！</h4>
   </div>
<div class="container" >
    <!--            <img src="b.jpg" class="img-responsive">-->
    <nav role="navigation" class="col-md-12 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
        <div class="container">
            <div class="navbar-header">
                <a href="article_main" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    	<li><a href="article_findAll">文章浏览</a></li>
                        <li><a href="collection_findArti">文章管理</a></li>
                        <li ><a href="articleSave">发表文章</a></li>
                        <li><a href="userInfo">关于我</a></li>
                        <li style="position:absolute;right:5px;">
                        <%  Object user=session.getAttribute("user"); if(user!=null){ %> <img style="display:inline-block;background-color:white;width:40px;height:40px;border-radius:20px;" alt="暂无头像" src="${sessionScope.user.face}"> <%  }else{  %><a onclick="show()">登陆</a></li><%     }%>  
                </ul>
            </div>
        </div>
    </nav>
    <div class="row" style="overflow: auto">
        <div class="col-md-12" style="background-color:rgba(255,255,255,0.8);height:87vh; margin-left: 0px;padding-top: 10px;">
        
            <div role="form" class="form-horizontal" style="margin-left: 18px;">
                <form action="article_save.action?articleid=<s:property value="art.id" />" method="post">
                    <div class="form-group" style="width: 300px;margin-left: 1px;">
                        <input class="form-control" name="name" placeholder="文章标题" value="<s:property value="art.title" />">
                    </div>
                    <div class="form-group" style="width: 300px;margin-left: 1px;">
                        <select class="form-control" name="varity" >
                        	<% String varity=(String)request.getAttribute("art.varity");  String varity2="分类"; %>
                            <option><%=varity==null?varity2:varity%><%-- <s:property value="art.varity" /> --%> </option>
                            <option >Java</option>
                            <option>C++</option>
                            <option>算法</option>
                            <option>前端/Html/Css/JS/JQuery</option>
                            <option>其他</option>
                        </select>
                    </div>
                   <!--  这里是文本框的编辑的地方-->
                    <div id="editor" class="form-group col-md-12" style="z-index:1;">
                    		
                    </div>
                    <div>
                        <textarea id="article" name="article" style="display:none">
                      			  <s:property value="content" />
                    	</textarea>
                    	
                    </div>
                    
                    <div class="form-group" style="margin-left:1px;">
                        <textarea  class="form-control" name="describe" style="width: 300px;height: 100px;" placeholder="文章描述，至少30字"><s:property value="art.mark" /></textarea>
                    </div>
                    <div class="form-group" style="width: 300px;margin-left:1px;">

                        <input type="submit" class="form-control btn btn-success"  value="保存">
                    </div>
                </form>
            </div>
    	<% String level=(String)session.getAttribute("level");
    			if("canDiscuss".equals(level)){
    			%>
    			<script>
    				show();
    			</script>
    			<% 
    		}
    
    %>
            
        </div>
    </div>
      
    
</div>
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript">
	<%-- var content="${content}";  '<%=request.getParameter("content") %>'; --%>
    var E = window.wangEditor
    var editor = new E('#editor')
    var $article=$('#article')
    editor.customConfig.onchange=function(html){
        $article.val(html)
    }
    editor.customConfig.uploadImgShowBase64=true
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    editor.txt.html($article.val());
    $article.val(editor.txt.html())
</script>

</body>
</html>
