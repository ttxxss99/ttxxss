<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html><!--网页文档头部文档声明 doc=document(文档)，type(类型)-->
<html><!--主体开始-->
	<!--网页头部区域-->
	<head>
		<!--声明当前页面的编码集charset=utf-8,中文编码集(gbk,gb2312),国际编码集(utf-8)-->
		<meta charset="utf-8" /><!--元信息标签 声明编码集-->
		<!--声明当前页面文档三要素-->
		<!--标题-->
		<title>在线音乐</title>
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
			body{background:#332e34;
				
			}
			a{text-decoration:none;}
			.fl{float:left;}
			.fr{float:right;}
			.header{
				width:100%;
				height:60px;
				min-width: 1300px;
			}
			.logo{
				height:100%;
			}
			.logo a{
				display:inline-block;
				font-size:23px;
				color:#829194;
				margin:20px 30px;
			}
			.user_info{
				width:400px;
				height:100%;
				
			}
			.login{
				width:300px;
				margin-top:10px;
			}
			.login span{
				font-size:16px;
				color:#fff;
				font-family:"微软雅黑";
				opacity:.8;
				margin-right:10px;
			}
			.user_info a{
				display:inline-block;
				font-size:16px;
				color:#fff;
				font-family:"微软雅黑";
				padding:5px 15px;
				border:1px solid rgba(150,150,150,.5);
				opacity:0.8;
				border-radius:5px;
				margin-right:10px;
				transition:all 0.5s;
			}
			.user_info a:hover{border:1px solid #fff;opacity:1;}
			.w{width:1200px;margin:0 auto;min-width: 1300px;}
			.content{
				height:100%;
				min-width: 1300px;
				overflow:hidden;
			}
			.con_left{
				width:100%;
				height:650px;
			}
			.con_right{
				width:30%;
				height:100%;
			}
			.biglogo{
				width:128px;
				margin-left:50px;
				height:128px;
				background:url("images/bigjita.png");
				opacity:0.8;
			}
			.nav{
				
				width:100%;
				margin-bottom:20px;
			}
			.nav_list{
				display:inline-block;
				font-size:14px;
				border:1px solid rgba(150,150,150,.5);
				color:#fff;
				opacity:0.8;
				cursor:pointer;
				padding:6px 25px;
				margin:0 2px;
				transition:all 0.5s;
			}
			.nav_list:hover{
				border:1px solid #fff;
				opacity:1;
			}
			.main_area{
				width:100%;
				height:500px;
				overflow-y:auto;
			}
			.main_area::-webkit-scrollbar{
				width:10px;
				height:8px;
			}
			
			.main_area::-webkit-scrollbar-thumb {/*滚动条里面小方块*/
				border-radius: 10px;
				-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
				background: #EDEDED;
			}
			.main_area::-webkit-scrollbar-track {/*滚动条里面轨道*/
				-webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
				border-radius: 10px;
				background: #535353;
			}
			
			.music_list tr{
				display:inline-block;
				width:100%;
				height:50px;
				line-height:50px;
				color:rgba(225,225,225,0.8);
				font-size:14px;
				border-bottom:1px solid rgba(150,150,150,0.1);
			}
			.music_list tr th{text-align:left;}
			.footer{
				height:100px;
				width:100%;
				position:fixed;
				left:0;
				bottom:0;
				padding-left:180px;
			}
			.music{
				height:100%;
			}
			.music_btn{
				float:left;
				width:130px;
				height:100%;
				position:relative;
				margin:0 10px;
			}
			a.player_btn{
				display:inline-block;
				position:absolute;
				top:50%;
				opacity:.8;
				background:url("images/player.png");
			}
			a.player_btn:hover{opacity:1;}
			.music_btn a:nth-child(1){
				background-position:0 -30px;
				width:19px;
				height:20px;
				margin-top:-10px;
			}
			.music_btn a:nth-child(2){
				width:19px;
				height:29px;
				margin-top:-14.5px;
				left:36%;
				margin-left:-11px;
			}
			.music_btn a:nth-child(3){
				background-position:0 -52px;
				width:19px;
				height:20px;
				margin-top:-10px;
				right:30%;
			}
			.music_btn a:nth-child(4){
				background-position:0 -173px;
				background-size:450%;
				right:0;
				width:25px;
				height:25px;
				margin-top:-10px;
			}

			.progress{
				width:auto;
				margin-left:150px;
				margin-right:200px;
				height:100%;
				position:relative;
			}
			.progress_bar{
				position:absolute;
				height:20px;
				left:10px;
				right:0;
				top:50%;
				margin-top:-9px;
			}
			.progress_info{
				position:absolute;
				background:#d8d8d8;
				height:2px;
				top:50%;
				margin-top:-1px;
			}
			.progress_list{
				position:absolute;
				top:50%;
				left:0;
				right:0;
				height:2px;
				margin-top:-1px;
				border-radius:2px;
				background:#808284;
				overflow:hidden;5
			}
			.progress_circle{
				width:10px;
				height:10px;
				background:#fff;
				border-radius:5px;
				overflow:hidden;
				position:absolute;
				margin-left:-5px;
				top:50%;
				margin-top:-5px;
			}
			.volume{
				float:right;
				width:200px;
				height:100%;
				right:0;
				position:relative;
				
			}
			.volume_set{
				width:60%;
				height:100%;
				position:relative;
				float:left;
		}
		.volume_set a{
			display:inline-block;
			position:absolute;
			width:26px;
			height:21px;
			top:50%;
			left:20px;
			margin-top:-10px;
			background:url("images/player.png") 0 -144px;
			opacity:0.8;
		}
		.progress_bar.volume1{
			margin-left:50px;
		}
		.mypic{
			display:inline-block;
			width:40px;
			height:40px;
			border-radius:50%;
			vertical-align:middle;
		}
		#frame{width:100%;height:100%;}
		</style>
			
	</head>

<% 
			if(session.getAttribute("user")==null){
			//跳转到登陆页面
			response.sendRedirect("login.jsp");
		}
	%>
	
	<!--网页身体区域-->
	<body>
		<!--头部logo + 导航-->
		<div class="header">
			<div class="logo fl">
				<a href="#">♫	MusicPlayer</a>
			</div>
			<div class="user_info fr">
				<div class="login fr">
					<span class="mypic"><img src="${user.userPic}"/></span>
					<span>欢迎${user.userName}</span>
					<a href="login.jsp">退出</a>
				</div>
				
			</div>
		</div>

		<!--主题内容区域-->
		<div class="content w">
			<div class="con_left fl">
				<div class="nav">
					<a href="MusicListServlet" target="main-content" class="nav_list">本地音乐</a>
					<a href="MyMusicLiftPageServlet?id=${user.userId}" target="main-content" class="nav_list">我的歌单</a>
					<a href="infoEdit.jsp" target="main-content" class="nav_list">个人中心</a>
					<a class="nav_list" href="musicOnling.jsp" target="main-content">歌曲搜索</a>
				</div>
				<div class="main_area" id="main_area">
					<!--系统音乐-->
					<iframe name="main-content" src="" frameborder="0" style="width:100%;height:100%;"></iframe>
				</div>
			</div>
			<div class="con_right fr">
				<div class="biglogo"></div>
				
			</div>
		</div>

		<!--页面底部区域-->
		<div class="footer">
		<audio id="musicPlayer" src="" controls="controls" style="width: 50%; height: 80px ;padding-left: 200px;"></audio>
			<div class="music w">
				<div class="music_btn">
					<a href="#" class="player_btn"></a>
					<a href="#" class="player_btn"></a>
					<a href="#" class="player_btn"></a>
					<a href="#" class="player_btn"></a>
				
				</div>
				<div class="volume">
					<div class="volume_set">
						<a href="#"></a>
					</div>
					<div class="volume_control">
						<div class="progress_bar volume1">
							<div class="progress_info"></div>
							<div class="progress_list"></div>
							<div class="progress_circle"></div>
						</div>
					</div>
				</div>

				<div class="progress">
					<div class="progress_bar">
						<div class="progress_info"></div>
						<div class="progress_list"></div>
						<div class="progress_circle"></div>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html><!--主体结束-->

