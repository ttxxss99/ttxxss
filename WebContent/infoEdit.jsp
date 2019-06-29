<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html><!--��ҳ�ĵ�ͷ���ĵ����� doc=document(�ĵ�)��type(����)-->
<html><!--���忪ʼ-->
	<!--��ҳͷ������-->
	<head>
		<!--������ǰҳ��ı��뼯charset=utf-8,���ı��뼯(gbk,gb2312),���ʱ��뼯(utf-8)-->
		<meta charset="utf-8" /><!--Ԫ��Ϣ��ǩ �������뼯-->
		<!--������ǰҳ���ĵ���Ҫ��-->
		<!--����-->
		<title>ע��</title>
		<!--�ؼ���-->
		<meta name="Keywords" content="" />
		<!--����-->
		<meta name="Description" content="" />

		<!--base,link,style,script-->
		<!--ҳ���ϵ��������ӹ涨Ĭ�ϵ�ַ��Ĭ��Ŀ��-->
		<base href="" /><!--ҳ���ϵ��������ӹ涨Ĭ�ϵ�ַ��Ĭ��Ŀ��-->
		<!--�����ⲿ��ʽ��-->
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
				font-family:"΢���ź�";
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
				font-family:"΢���ź�";
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
							userName:{required:"�������˺�!",minlength:"�˺ų��Ȳ���С��8���ַ���",maxlength:"�˺ų��Ȳ��ܴ���20���ַ���"},
							userNick:{required:"�������˺�!",minlength:"�˺ų��Ȳ���С��2���ַ���",maxlength:"�˺ų��Ȳ��ܴ���20���ַ���"},
							
						}
					});
					
			});
			

		</script>
	</head>

	<!--��ҳ��������-->
	<body>
		<div class="user_regist">
			<h1>��������</h1>
			<form id="myForm" action="UserEditSaverlets" method="post"  target="_parent" enctype="multipart/form-data">
				<p>
					<span>�ҵ�ID</span>
					<input type="text" name="userId" value="${user.userId}" disabled="disabled"/>
					
				</p>
				<p>
					<span>�û���</span>
					<input type="text" name="userName" value="${user.userName}"/>
					
				</p>
				<p>
					<span>����</span>
					<input type="password" name="userPwd" value="${user.userPwd}"/>
					
				</p>
				<p>
					<span>ͷ��</span>
						<img src="${user.userPic}" alt="" width="30" height="30" style="vertical-align:middle;" />
						<label for="inputFile" class="button" style="cursor:pointer;">
							ѡ���ļ�
						</label>
					<input type="file" name="userPic" id="inputFile" style="display: none" onchange="changed">
				</p>
				<p>
					<span>�ǳ�</span>
					<input type="text" name="userNick" value="${user.userNick}"/>
				</p>
				<p>
					<span>�Ա�</span>
					<input type="radio" name="userSex" value="M" checked/>�� <input type="radio" name="userSex" value="F" />Ů
				</p>
				
				<p>
					<span>����˵��</span>
					<textarea name="userDesc" id="" >${user.userDesc}</textarea>
				</p>
				<button name="btn">ȷ���޸�</button>
			</form>
		</div>
	</body>
</html><!--�������-->
