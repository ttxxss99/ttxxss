<%@ page language="java"  pageEncoding="UTF-8"%>
<!doctype html><!--网页文档头部文档声明 doc=document(文档)，type(类型)-->
<html><!--主体开始-->
	<!--网页头部区域-->
	<head>
		<!--声明当前页面的编码集charset=utf-8,中文编码集(gbk,gb2312),国际编码集(utf-8)-->
		<meta charset="utf-8" /><!--元信息标签 声明编码集-->
		<!--声明当前页面文档三要素-->
		<!--标题-->
		<title>Login</title>
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
			a{text-decoration:none;}
			.user_login{
				position:fixed;
				top:20%;
				left:50%;
				margin-left:-120px;
				padding:10px 20px 20px;
				background:#fafafa;
				border:1px solid #DDD;
				border-radius:7px;
			}
			.top_box{
				width:100%;
				height:56px;
				line-height:56px;
				margin:0 0 20px 0;
				border-bottom:1px solid #eee;
			}
			.top_box h1{

				float:left;
				font-size:16px;
				font-family:sans-serif;
				font-weight:500;
			}
			.close_login{
				float:right;
				width:12px;
				height:12px;
				background:url(http://www.kuwo.cn/static/image/web/homePage/ugc/close.png);
				margin-top:20px;
			}
			.close_login:hover{
				background:url(http://www.kuwo.cn/static/image/web/homePage/ugc/closeHover.png);
			}
			.l_txt{
				display:block;
				margin:0 0 10px 20px;
				font-size:14px;
				color:#333;
			}
			.user,.pwd{
				display:inline-block;
				margin-right:10px;
				width:16px;
				height:16px;
			}
			.user{background:url("images/user.png");}
			.pwd{background:url("images/pwd.png");}
			form input{
				border:1px solid #ccc;
				color:#888;
				height:20px;
				line-height:15px;
				margin-right:6px;
				margin-top:12px;
				outline:0 none;
				padding:5px 0 5px 5px;
				border-radius:4px;
				box-shadow:inset 0 1px 1px rgba(0,0,0,0.075);
				font-size:12px;
			}
			form .button{
				display:inline-block;
				background:#fff;
				border:1px solid #ccc;
				padding:10px 25px 10px 25px;
				margin-top:20px;
				margin:20px 20px;
				color:#333;
				border-radius:4px;
				font-size:12px;
			}
			form .button:hover{
				color:#333;
				background:#ebebeb;
				border-color:#adadad;
			}
			
		
			
		</style>

	</head>

	<!--网页身体区域-->
	<body>
		<div class="user_login" >
			<div class="top_box">
				<h1>MusicPlayer</h1>
				<a href="#" class="close_login"></a>
			</div>
			<form action="UserLoginServlet" method="post">
				
				<span class="l_txt">账号登录</span>
				<p>
					<i class="user"></i>
					<input type="text" name="username" placeholder="用户名"/>${tips}
				</p>
				<p>
					<i class="pwd"></i>
					<input type="password" name="user_pwd" placeholder="密码"/>
				</p>
				<button name="btn" class="button">登陆</button>
				<a href="regist.jsp" class="button">注册</a>
				
			</form>
		</div>
		
		
	</body>
	<script type="text/javascript">
			//ajax
			$(document).ready(function(){
				$("#searchBtn").click(function(){
					//获取页面中输入框中的搜索关键词
					var k = $("$keyword").val();

					//2.将关键词通过ajax提交到MusicOnlineServlet

					//参数1:请求路径
					//参数2：传递到Servlet的参数
					//参数3：回调函数，当servlet传回数据之后，由此函数进行处理
					//参数4：返回数据的类型(text|html|xml|json)
					$.post("MusicOnlineServlet",{kw:k},function(data){
						//data就表示MusicOnlineServlet传递回来的音乐信息
						//处理音乐信息：将音乐信息显示到页面

						var arr = data.result.songs;
						for(var i=0;i<arr.length;i++){
							var song = arr[i];
							var songId = song.id;
							var songName = song.name;
							var single = song.artists[0].name;
							var album = song.ablum.name

							var tr = document.createElement("tr");
							var td1 = document.createElement("td");
							var td2 = document.createElement("td");
							var td3 = document.createElement("td");
							var td4 = document.createElement("td");
							var td5 = document.createElement("td");
							td1.innerHTML = songId;
							td2.innerHTML = songName;
							td3.innerHTML = single;
							td4.innerHtml
						}
						

					},"")
				})
			})
			
			function playMusic(sid){
				//1.获取播放器
				var player = document.getElementById("musicPlayer");
				//2.将当前的音乐路径设置给播放器的SRC属性
				player.src = "http://music.163.com/song/meadia/outer/url?id="+sid;
				//3.让播放器播放音乐
				player
			}
	</script>
</html><!--主体结束-->
