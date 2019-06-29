<%@ page language="java"  pageEncoding="GBK"%>
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
				font-family:"΢���ź�";
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
							userName:{required:"�������˺�!",minlength:"�˺ų��Ȳ���С��6���ַ���",maxlength:"�˺ų��Ȳ��ܴ���20���ַ���"},
							userPwd:{required:"����������!",minlength:"�˺ų��Ȳ���С��8���ַ���",maxlength:"�˺ų��Ȳ��ܴ���16���ַ���"}
						}
					});
			});
		</script>
	</head>

	<!--��ҳ��������-->
	<body>
		<div class="user_regist">
			<h1>ע��${tips}</h1>
			<!-- <a href="#" class="close"></a> -->
			<form id="myForm" action="UserRegistServlet" method="post" enctype="multipart/form-data">
				<p>
					<span>�û���</span>
					<label for="userName"></label>
					<input type="text" name="userName" placeholder="6-20λ���ֻ���ĸ"/>
				</p>
				<p>
					<span>����</span>
					<label for="userPwd"></label>
					<input type="password" name="userPwd" placeholder="8-16λ������" />
				</p>
				<p>
					<span>ȷ������</span>
					<label for="rePwd"></label>
					<input type="password" name="rePwd" placeholder="��ȷ������"/>
				</p>
				<p>
					<span>�ǳ�</span>
					<label for="userNick"></label>
					<input type="text" name="userNick" placeholder="�������ǳ�"/>
				</p>
				<p>
					<span>�Ա�</span>
					<label for="sex"></label>
					<input type="radio" name="sex" value="M" checked/>�� <input type="radio" name="sex" value="F" />Ů
				</p>
				<p>
					<span>ͷ��</span>
					<label for="userPic"></label>
					<input type="file" name="userPic" />
				</p>
				<p>
					<span>����˵��</span>
					<label for="userDesc"></label>
					<textarea name="userDesc" id="" placeholder="˵��ʲô��"></textarea>
				</p>
				<button name="btn">ȷ��ע��</button>
			</form>
		</div>
	</body>
</html><!--�������-->
