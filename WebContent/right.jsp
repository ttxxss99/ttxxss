<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	body{background:;}
	table > tr {
		width: 100%;
		height: 100%;
		line-height: 50px;
		background: rgba(0,0,0,0.4);
		border-bottom:1px solid red;
		
	}
	.nav > table >th{
		float: left;
	}
</style>
</head>
<body>
				<table>
					<tr><td>
						<div class="nav">
							<table >
							<tr class="head">
							<th width="15"></th>
							<th width="200">歌曲</th>
							<th width="200">歌手</th>
							<th width="200">专辑</th>
					
							</tr>
						<c:forEach items="${key3}" var="m">
							<tr>
							<td>${m.musicId}</td>
							<td>${m.musicName}</td>
							<td>${m.musicArt}</td>
							<td>${m.musicAlbum}</td>
							</tr>
						</c:forEach>
				</table>
</body>
</html>