<%@ page language="java" contentType="text/html; charset=utf-8"
                                   pageEncoding="utf-8"%>
                                   <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

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
        .blockCustom{
            height: 200px;background-color: #FFFFFF; margin-left:40px;margin-bottom: 10px;
            margin-top: 10px;
        }
        .blockCustomInside{
            height:40px;background-color: rgba(255,255,204,0.5);text-align: center;margin-top:20px;
        }
        .blockCustomInside2{
            height:140px;background-color: rgba(02,102,153,0.12);margin-top: 5px;
        }
        .positionBlocA{
            margin-left:40px;
            margin-bottom: 10px;
            margin-top: 10px;
        }
        .positionBlocB{
            margin-left:10px;margin-bottom: 10px;
            margin-top: 10px;
        }
        .positionBlocC{
            margin-left:70px;position:absolute;margin-top: 220px;margin-bottom: 10px

        }
        .bacgroundA{
            background-color: #FFFFFF;
        }
        .sizeOfA{
            height: 220px;
        }

    </style>
</head>
<body>
    <div class="container" style="height:1000px;">
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


</body>
</html>