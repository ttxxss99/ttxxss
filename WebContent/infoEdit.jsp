<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html><!--网页文档头部文档声明 doc=document(文档)，type(类型)-->
<html><!--主体开始-->
	<!--网页头部区域-->
	<head>
		<!--声明当前页面的编码集charset=utf-8,中文编码集(gbk,gb2312),国际编码集(utf-8)-->
		<meta charset="utf-8" /><!--元信息标签 声明编码集-->
		<!--声明当前页面文档三要素-->
		<!--标题-->
		<title>注册</title>
		<!--关键字-->
		<meta name="Keywords" content="" />
		<!--描述-->
		<meta name="Description" content="" />

		<!--base,link,style,script-->
		<!--页面上的所有链接规定默认地址或默认目标-->
		<base href="" /><!--页面上的所有链接规定默认地址或默认目标-->
		<!--连接外部样式表-->
		<link rel="stylesheet" href="" /> 
		<style type="text/css">
			*{margin:0px;padding:0px;}
			.user_regist{
				width:500px;
				
				height:450px;
				
				padding:20px 30px 20px 30px;
				font-size:12px;
				color:#DDD;
				border:1px solid #DDD;
				border-radius:5px;
			}
			
			.user_regist h1{
				font-size:25px;
				font-family:"微软雅黑";
				display:block;
				padding:0px 0px 10px 40px;
				border-bottom:1px solid #dadada;
				margin:-10px -30px 30px -30px;
			}
			#myForm p{
				margin-bottom:5px;
			}
			#myForm p span{
				display:inline-block;
				width:20%;
				text-align:right;
				padding-right:10px;
				margin-top:10px;
				font-weight:bold;
			}
			#myForm input[type="text"],#myForm input[type="password"]{
				border:1px solid #ccc;
				color:#888;
				height:20px;
				line-height:15px;
				margin-right:6px;
				margin-top:2px;
				outline:0 none;
				padding:5px 0 5px 5px;
				width:40%;
				border-radius:4px;
				box-shadow:inset 0 1px 1px rgba(0,0,0,0.075);
				font-size:12px;
			}
			#myForm input[type="file"]{
				width:54%;
			}
			#myForm textarea{
				height:100px;
				padding:5px 0 0 5px;
				width:70%;
				font-size:12px;
				color:#888;
				font-family:"微软雅黑";
				vertical-align:middle;
			}
			#myForm button{
				background:#fff;
				border:1px solid #ccc;
				padding:10px 25px 10px 25px;
				margin-top:40px;
				color:#333;
				border-radius:4px;
			}
			#myForm button:hover{
				color:#333;
				background:#ebebeb;
				border-color:#adadad;
			}
			label.error{
				color:red;
				font-size:12px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function(){
				$("#myForm").validate({
						rules:{
							userName:{required:true,minlength:8,maxlength:20},
							userNick:{required:true,minlength:2,maxlength:20}
						},
						messages:{
							userName:{required:"请输入账号!",minlength:"账号长度不能小于8个字符！",maxlength:"账号长度不能大于20个字符！"},
							userNick:{required:"请输入账号!",minlength:"账号长度不能小于2个字符！",maxlength:"账号长度不能大于20个字符！"},
							
						}
					});
					
			});
			

		</script>
	</head>

	<!--网页身体区域-->
	<body>
		<div class="user_regist">
			<h1>个人中心</h1>
			<form id="myForm" action="UserEditSaverlets" method="post"  target="_parent" enctype="multipart/form-data">
				<p>
					<span>我的ID</span>
					<input type="text" name="userId" value="${user.userId}" disabled="disabled"/>
					
				</p>
				<p>
					<span>用户名</span>
					<input type="text" name="userName" value="${user.userName}"/>
					
				</p>
				<p>
					<span>密码</span>
					<input type="password" name="userPwd" value="${user.userPwd}"/>
					
				</p>
				<p>
					<span>头像</span>
						<img src="${user.userPic}" alt="" width="30" height="30" style="vertical-align:middle;" />
						<label for="inputFile" class="button" style="cursor:pointer;">
							选择文件
						</label>
					<input type="file" name="userPic" id="inputFile" style="display: none" onchange="changed">
				</p>
				<p>
					<span>昵称</span>
					<input type="text" name="userNick" value="${user.userNick}"/>
				</p>
				<p>
					<span>性别</span>
					<input type="radio" name="userSex" value="M" checked/>男 <input type="radio" name="userSex" value="F" />女
				</p>
				
				<p>
					<span>个人说明</span>
					<textarea name="userDesc" id="" >${user.userDesc}</textarea>
				</p>
				<button name="btn">确认修改</button>
			</form>
		</div>
	</body>
</html><!--主体结束-->
