<%--
  Created by IntelliJ IDEA.
  User: yuchende
  Date: 2019/5/27
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
</head>
<body>
<div class="container" >
    <!--            <img src="b.jpg" class="img-responsive">-->
    <nav role="navigation" class="col-md-offset-2 col-md-8 navbar navbar-inverse navbar-fixed-top" style="height:80px;padding-top: 15px;    ">
        <div class="container">
            <div class="navbar-header">
                <a href="article_main" class="navbar-brand">首页</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="article_findAll">文章</a></li>
                    <li><a href="collection">收藏</a></li>
                    <li class="active"><a href="articleSave">写文章</a></li>
                    <li><a href="#">关于我</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row" style="overflow: auto">
        <div class="col-md-12" style="background-color:rgba(255,255,255,0.8);height:87vh; margin-left: 0px;padding-top: 10px;">
            <div role="form" class="form-horizontal" style="margin-left: 18px;">
                <form action="article_save.action" method="post">
                    <div class="form-group" style="width: 300px;margin-left: 1px;">
                        <input class="form-control" name="name" placeholder="文章标题">
                    </div>
                    <div class="form-group" style="width: 300px;margin-left: 1px;">
                        <select class="form-control" name="varity">
                            <option>分类</option>
                            <option>Java</option>
                            <option>C++</option>
                            <option>算法</option>
                            <option>其他</option>
                        </select>
                    </div>
                    <div id="editor" class="form-group col-md-12">

                    </div>
                    <div>
                        <textarea id="article" name="article" style="display: none;"></textarea>
                    </div>
                    <div class="form-group" style="margin-left:1px;">
                        <textarea  class="form-control" name="describe" style="width: 300px;height: 100px;" placeholder="文章描述，至少30字"></textarea>
                    </div>
                    <div class="form-group" style="width: 300px;margin-left:1px;">

                        <input type="submit" class="form-control btn btn-success"  value="保存">
                    </div>
                </form>
            </div>

        </div>


    </div>


</div>
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    var $article=$('#article')

    editor.customConfig.onchange=function(html){
        $article.val(html)
    }
    editor.customConfig.uploadImgShowBase64=true
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()
    $article.val(editor.txt.html())
</script>

</body>
</html>
