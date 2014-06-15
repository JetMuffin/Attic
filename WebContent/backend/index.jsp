<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="attic.web.model.Admin"%> 
<% 
	Admin admin = (Admin)session.getAttribute("admin"); 
	if(admin==null)
	{
		session.setAttribute("msg","请先登录！");
		response.sendRedirect("login.jsp");
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
<link type="text/css" rel="stylesheet" href="source/css/index.css" />
<link href="source/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="common/sidebar.jsp" />
    <div class="main">
    	<jsp:include page="common/header.jsp">
    		<jsp:param value="首页" name="href"/>
    	</jsp:include>
    	<div class="content">
    		
   	 	</div>
		<jsp:include page="common/footer.jsp" />
    </div>

</div>

</body>
</html>