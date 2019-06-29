<%@ page language="java"  pageEncoding="GBK"%>
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
			body{background:#332e34;}
			.user_regist{
				width:300px;
				position:absolute;
				top:50%;
				left:50%;
				margin-left:-150px;
				margin-top:-250px;
				background:#fafafa;
				padding:20px 30px 20px 30px;
				font-size:12px;
				color:#888;
				text-shadow:1px 1px 1px #FFF;
				border:1px solid #DDD;
				border-radius:5px;
			}
			.close{
				width:12px;
				height:12px;
				position:absolute;
				top:20px;
				right:30px;
				background:url(http://www.kuwo.cn/static/image/web/homePage/ugc/close.png);
			}
			.close:hover{
				background:url(http://www.kuwo.cn/static/image/web/homePage/ugc/closeHover.png);
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
				color:#333;
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
				width:70%;
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
				margin-top:10px;
				color:#333;
				border-radius:4px;
			}
			#myForm button:hover{
				color:#333;
				background:#ebebeb;
				border-color:#adadad;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#myForm").validate({
						rules:{
							userName:{required:true,minlength:6,maxlength:20},
							userPwd:{required:true,minlength:8,maxlength:16},
						},
						messages:{
							userName:{required:"请输入账号!",minlength:"账号长度不能小于6个字符！",maxlength:"账号长度不能大于20个字符！"},
							userPwd:{required:"请输入密码!",minlength:"账号长度不能小于8个字符！",maxlength:"账号长度不能大于16个字符！"}
						}
					});
			});
		</script>
	</head>

	<!--网页身体区域-->
	<body>
		<div class="user_regist">
			<h1>注册${tips}</h1>
			<!-- <a href="#" class="close"></a> -->
			<form id="myForm" action="UserRegistServlet" method="post" enctype="multipart/form-data">
				<p>
					<span>用户名</span>
					<label for="userName"></label>
					<input type="text" name="userName" placeholder="6-20位数字或字母"/>
				</p>
				<p>
					<span>密码</span>
					<label for="userPwd"></label>
					<input type="password" name="userPwd" placeholder="8-16位纯数字" />
				</p>
				<p>
					<span>确认密码</span>
					<label for="rePwd"></label>
					<input type="password" name="rePwd" placeholder="请确认密码"/>
				</p>
				<p>
					<span>昵称</span>
					<label for="userNick"></label>
					<input type="text" name="userNick" placeholder="请输入昵称"/>
				</p>
				<p>
					<span>性别</span>
					<label for="sex"></label>
					<input type="radio" name="sex" value="M" checked/>男 <input type="radio" name="sex" value="F" />女
				</p>
				<p>
					<span>头像</span>
					<label for="userPic"></label>
					<input type="file" name="userPic" />
				</p>
				<p>
					<span>个人说明</span>
					<label for="userDesc"></label>
					<textarea name="userDesc" id="" placeholder="说点什么呢"></textarea>
				</p>
				<button name="btn">确认注册</button>
			</form>
		</div>
	</body>
</html><!--主体结束-->
