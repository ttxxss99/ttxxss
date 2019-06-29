<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html><!--网页文档头部文档声明 doc=document(文档)，type(类型)-->
<html><!--主体开始-->
	<!--网页头部区域-->
	<head>
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
			body{overflow:hidden;}
			body::-webkit-scrollbar{display:none;}
			a{text-decoration:none;}
			.music_list_body{
				width: 45%; height:480px;float: left; border: 1px solid slateblue;
			}
			.music_list{width:100%;float:left; border: 1px solid salmon;}
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
			.music_list tr td{text-align:center;}

			.music_list tr>td:nth-child(1),.music_list tr>th:nth-child(1){margin-right:5px;}
			.music_list tr>td:nth-child(2),.music_list tr>th:nth-child(2){margin-right:5px;}
			.music_list tr>td:nth-child(3),.music_list tr>th:nth-child(3){margin-right:5px;}
			.music_list tr>td:nth-child(4),.music_list tr>th:nth-child(4){margin-right:5px;}
			.music_list tr>td:nth-child(5),.music_list tr>th:nth-child(5){margin-right:5px;}
			.head >th:nth-child(2){padding-left: 30px;}
			.music_list tr:not(.head):hover{
				background:rgba(255,255,2555,0.4);
			}
			.add_table{
				border: 1px solid saddlebrown;
				width: 100%;
				
				border-top-width:211px ;
				
			}
			.head > th{
				
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
			.right{
				width:54%;
				float:right;
				border: 1px solid olive;
			}
		</style>

	</head>

	<!--网页身体区域-->
	<body>
		<div class="music_list_body">
			<div class="music_list">
				<table>
					<tr class="head">
						<th width="30"></th>
						<th width="200">歌单名称</th>
						<th width="200">歌单说明</th>
						<th width="200">创建时间</th>
						
					</tr>
					
					<c:forEach items="${musicList}" var="m">
									<tr>
										<td width="30">${m.listId}</td>
										<td width="200"><a href="MyMusicRightPageServlet?id=${m.listId}" target="right-content" class="nav_list">${m.listName}</a></td>
										<td width="200">${m.listDesc}</td>
										<td width="200">${m.listTime}</td>
									</tr>
								</c:forEach>
					
					
				</table>
			</div>
			<div class="add_music_list">
				<table class="add_table" cellspacing="0" >
					<tr><th>Header</th></tr>
					<tr><td>Data</td></tr>
				</table>
				
			</div>
			
			
		</div>
			<div class="right">
				<iframe name="right-content" src="" frameborder="0" style="width:100%;height:100%;"></iframe>
			</div>
			
			
	</body>
	
	
	
	
	
	
	
	
	<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
	<script type="text/javascript">
		function playMusic(){
			// 1.获取播放器
			var player=$("#musicPlayer",parent.document);
			console.log(player);
			//var player = document.getElementById("musicPlayer")
			//2.将当前的音乐路径设置给播放器的src属性
			player.src = "mp3/1.mp3";
			//3.让播放器放音乐
			player.play();
		}
	</script>
</html><!--主体结束-->
