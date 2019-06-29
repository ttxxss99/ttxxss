<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			body::-webkit-scrollbar{display:none;}
			a{text-decoration:none;}
			.music_list{width:40%;height:100%;}
			.music_list tr{
				display:inline-block;
				width:100%;
				height:50px;
				line-height:50px;
				color:rgba(225,225,225,0.8);
				font-size:14px;
				border-bottom:1px solid rgba(150,150,150,0.1);
			}
			.music_list tr th{text-align:left;font-size:14px;font-weight:500;}

			.music_list tr>th:nth-child(4){padding-left:5px;}
			.music_list tr>td:nth-child(1),.music_list tr>th:nth-child(1){width:10%;}
			.music_list tr>td:nth-child(2),.music_list tr>th:nth-child(2){width:25%;}
			.music_list tr>td:nth-child(3),.music_list tr>th:nth-child(3){width:20%;}
			.music_list tr>td:nth-child(4),.music_list tr>th:nth-child(4){width:20%;}
			.music_list tr>td:nth-child(5),.music_list tr>th:nth-child(5){width:25%;}
			.music_list tr>td:nth-child(5){margin-left:10px;}

			
			.tda{
				display:inline-block;
				font-size:14px;
				border:1px solid rgba(150,150,150,.5);
				border-radius:10px;
				color:#fff;
				opacity:0.8;
				cursor:pointer;
				margin-left:28px;
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
						<th width="10%"></th>
						<th width="35%">歌单名称</th>
						<th width="20%">歌单描述</th>
						<th width="20%">创建时间</th>
						<th width="15%"></th>
					</tr>
					<tr>
						<td>1</td>
						<td>忘情水</td>
						<td>刘德华</td>
						<td>未知专辑</td>
						<td>
							<a href="" class="shou_btn tda">删除</a>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>忘情水</td>
						<td>刘德华</td>
						<td>未知专辑</td>
						<td>
							<a href="" class="shou_btn tda">删除</a>
						</td>
					</tr>
					
					
				</table>
			</div>
	</body>
</html><!--主体结束-->
