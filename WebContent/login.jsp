<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="attic.web.model.User"%> 
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${PUBLIC}/css/login.css" />
<link href="${PUBLIC}/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
</head>
<body>
<div class="container">
	<section class="main">	
		<c:if test="${msg ne null}">
			<div class="message">
				<i class="icon-warning"></i>${msg}
				<a class="removing-tag"><i class="fa fa-times"></i></a>
			</div>
		</c:if> 
		<form class="login-form" action="login" method="post">
			<h1>在线学习系统</h1>
			<a href="register.jsp" class="signup">注册<i class="fa fa-arrow-circle-right"></i></a>
			<p>
				<label for="login">Username</label>
				<input type="text" name="uid" placeholder="学号/工号" required>
			</p>
			<p>
				<label for="password">password</label>
				<input type="password" name='password' placeholder="密码" required> 
			</p>
			<p>
				<input type="submit" name="submit" value="登录" />
			</p>  
		</form>​
	</section>	
</div>
<script type="text/javascript" src="${PUBLIC}/js/jquery.js"></script>
<script>
	$(document).ready(function(){
		$(".removing-tag").click(function(){
			$(".message").fadeOut();
		});
	});
</script>
</body>
</html>