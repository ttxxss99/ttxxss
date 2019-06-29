 <%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="js/jquery-1.8.1.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#searchBtn").click(function(){
				var k = $("#keyWord").val();
				$.post("MusicOnlineServlet",{kw:k},function(data){
					//data就表示MusicOnlineServlet传递回来的音乐信息
					//处理音乐信息：将音乐信息显示到页面
					var arr = data.result.songs;
				
					var table =document.getElementById("musicList");
					table.innerHTML= "";
					for(var i=0; i<arr.length;i++){
						var song = arr[i];
						var songId = song.id;
						var songName =song.name;
						var singer = song.artists[0].name;
						var album = song.album.name;
						
						
						var tr = document.createElement("tr");//<tr></tr>
						var td1 = document.createElement("td");
						var td2 = document.createElement("td");
						var td3 = document.createElement("td");
						var td4 = document.createElement("td");
						var td5 = document.createElement("td");
						
						td1.innerHTML = songId;
						td2.innerHTML = songName;
						td3.innerHTML = singer;
						td4.innerHTML = album;
						td5.innerHTML = "<input type = 'button' value ='播放'  onclick ='playMusic("+songId+")'/>";
						tr.appendChild(td1);
						tr.appendChild(td2);
						tr.appendChild(td3);
						tr.appendChild(td4);
						tr.appendChild(td5);
						table.appendChild(tr);
					}
					
				},"json");
			
			});
		});
			
			
			function playMusic(sid){
				// 1.获取播放器
				var player = $("#musicPlayer",parent.document);
				
				//var player = document.getElementById("musicPlayer")
				//2.将当前的音乐路径设置给播放器的src属性
				player[0].src = "http://music.163.com/song/media/outer/url?id="+sid;
				//3.让播放器放音乐
				player[0].play();
			}
			
		
		</script>
		
		
		
		
		<style type="text/css">
			div{
				width: 1000px;
				margin: auto;
				
			}
			#musicList{
				width: 1000px;
				color: gray;
				font-size: 14px;
			}
			#musicList tr{
				height: 35px;
			}
			#musicList tr td {
				border-bottom: 1px lightgray dashed;
			}
		</style>
	</head>
	<body>
		<div>
		<input type="text"  name="kw" id="keyWord" placeholder="歌曲名/歌手名"/>
		<input  type="button" value="搜索"  id = "searchBtn">
		<!--  <audio id = "musicPlayer" src = ""  controls="controls"></audio>-->
		<hr />
		<table id="musicList" cellspacing="0">
			
			
			
		</table>
		</div>
	</body>
</html>
