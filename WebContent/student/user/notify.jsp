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
    		<div class="admin-add">
	    		<form action="Register">
	    			<label for="" class="label">用户名：<span class="required">*</span></label>
	    			<input type="text" class="input" required>
	    			<label for="">密码：<span class="required">*</span></label>
	    			<input type="password" class="input" required>
	    			<label for="">真实姓名：</label>
	    			<input type="text" class="input" required>
	    			<label for="">验证码：<span class="required">*</span></label>
	    			<input type="text" class="input" required>
	    			<input type="submit" class="button" value="提交"/>
	    			<input type="reset" class="button" value="重置"/>
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