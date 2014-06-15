<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="attic.web.model.Admin"%> 
<% 
	Admin admin = (Admin)session.getAttribute("admin"); 
	String msg =(String)session.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="source/css/login.css" />
<link href="source/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
</head>
<body>
<div class="container">
	<section class="main">	
			<% if(msg!=null){ %>    
				<div class="message">
					<i class="icon-warning"></i><%=msg %>
					<a class="removing-tag"><i class="fa fa-times"></i></a>
				</div>
			<% } %>	
		<form class="login-form" action="login" method="post">
			<h1>后台管理</h1>
			<p>
				<label for="login">Username</label>
				<input type="text" name="uid" placeholder="Username" required>
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" name='password' placeholder="Password" required> 
			</p>
			<p>
				<input type="submit" name="submit" value="登录" />
			</p>  
		</form>​
	</section>	
</div>
<script type="text/javascript" src="source/js/jquery.js"></script>
<script>
	$(document).ready(function(){
		$(".removing-tag").click(function(){
			$(".message").fadeOut();
		});
	});
</script>
</body>
</html>