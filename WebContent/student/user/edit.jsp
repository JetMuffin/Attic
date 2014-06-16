<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="attic.web.model.User"%> 
<%
	User user = (User)session.getAttribute("user"); 
	if(user==null)
	{
		session.setAttribute("msg","请先登录！");
		response.sendRedirect("../login.jsp");
		return;
	}
    response.setCharacterEncoding("utf-8");  
    request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-首页</title>
<link type="text/css" rel="stylesheet" href="${PUBLIC}/css/index.css" />
<link type="text/css" rel="stylesheet" href="${PUBLIC}/css/user.css" />
<link href="${PUBLIC}/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="../common/sidebar.jsp" />
    <div class="main">
    	<jsp:include page="../common/header.jsp">
    		<jsp:param value="首页" name="href"/>
    	</jsp:include>
    	<div class="content">
    		<div class="edit-title"><h3>个人资料</h3></div>
    		<div class="edit-form">
    			<form action="">
    				<table>
    					<tr>
    						<td class="name">学号：</td>
    						<td><input type="text" value="" class="edit-input"/></td>
    					</tr>
    					<tr>
    						<td class="name">密码：</td>
    						<td><input type="password" class="edit-input"/></td>
    					</tr>
    					<tr>
    						<td class="name">真实姓名：</td>
    						<td><input type="text" value="" class="edit-input"/></td>
    					</tr>
    					<tr>
    						<td class="name">性别：</td>
    						<td class="sex">
    							<label><input type="radio" name="sex" value="1"/>男</label>
    							<label><input type="radio" name="sex" value="0"/>女</label>
    						</td>
    					</tr>
    					<tr>
    						<td class="name">学校：</td>
    						<td><input type="text" value=" " class="edit-input"/></td>
    					</tr>
    					 <tr>
    						<td class="name">专业：</td>
    						<td><input type="text" value=" " class="edit-input"/></td>
    					</tr>
    					<tr>
    						<td class="name">年级：</td>
    						<td><input type="text" value=" " class="edit-input"/></td>
    					</tr>
    					 <tr>
    						<td class="name">班级：</td>
    						<td><input type="text" value=" " class="edit-input"/></td>
    					</tr>
    				</table>
    			</form>
    		</div>
   	 	</div>
		<jsp:include page="../common/footer.jsp" />
    </div>
</div>
<script type="text/javascript" src="${PUBLIC}/js/jquery.js"></script>
<script>
	$(document).ready(function(){
		$(".sidebar-menu ul li ul").hide();
        $(".sidebar-menu li a").click(function() {
            $(".sidebar-menu li ul").slideUp(),
            $(".sidebar-menu li").removeClass("active"),
            $(this).parent("li").addClass("active"),
            $(this).next("ul").slideDown();
        });
	});
</script>
</body>
</html>