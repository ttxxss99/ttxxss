<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html><!--网页文档头部文档声明 doc=document(文档)，type(类型)-->
<html><!--主体开始-->
	<!--网页头部区域-->
	<head>
	
	
	<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
		
	
		<!--声明当前页面的编码集charset=utf-8,中文编码集(gbk,gb2312),国际编码集(utf-8)-->
		<meta charset="utf-8" /><!--元信息标签 声明编码集-->
		<!--声明当前页面文档三要素-->
		<!--标题-->
		<title></title>
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
			body::-webkit-scrollbar{display:none;}
			a{text-decoration:none;}
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


			.music_list tr>td:nth-child(1),.music_list tr>th:nth-child(1){width:35px;}
			.music_list tr>td:nth-child(2),.music_list tr>th:nth-child(2){width:300px;}
			.music_list tr>td:nth-child(3),.music_list tr>th:nth-child(3){width:150px;}
			.music_list tr>td:nth-child(4),.music_list tr>th:nth-child(4){width:150px;}
			.music_list tr>td:nth-child(5),.music_list tr>th:nth-child(5){width:200px;}

			.music_list tr:not(.head):hover{
				background:rgba(255,255,2555,0.4);
			}
			.tda{
				display:inline-block;
				font-size:14px;
				border:1px solid rgba(150,150,150,.5);
				border-radius:10px;
				color:#fff;
				opacity:0.8;
				cursor:pointer;
				margin:0 8px;
				transition:all 0.5s;
				line-height:25px;
				padding:0px 10px;
			}
			.tda:hover{
				border:1px solid #fff;
				opacity:1;
			}
		</style>

	</head>

	<!--网页身体区域-->
	<body>
		<div class="music_list">
				<table>
					<tr class="head">
						<th width="40"></th>
						<th width="350">歌曲</th>
						<th width="150">歌手</th>
						<th width="150">专辑</th>
						<th width="100"><a href="#">添加歌单</a></th>
					</tr>
					<c:forEach items="${key3}" var="m">
						<tr>
							<td>${m.musicId}</td>
							<td>${m.musicName}</td>
							<td>${m.musicArt}</td>
							<td>${m.musicAlbum}</td>
							<td><input type = "button" value ="播放'" onclick ="playMusic('${m.musicPath}')"/></td>
						</tr>
					</c:forEach>
				</table>
				<!--  <audio id = "musicPlayer" src = ""  controls="controls"></audio>-->
				<hr />
			</div>
	</body>
	<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
	<script type="text/javascript">
		
		
		function playMusic(sid){
			// 1.获取播放器
			var player = $("#musicPlayer",parent.document);
			console.log(player);
			//var player = document.getElementById("musicPlayer")
			//2.将当前的音乐路径设置给播放器的src属性
			player[0].src = sid;
			//3.让播放器放音乐
			player[0].play();
		}
		
	
	</script>
</html><!--主体结束-->
