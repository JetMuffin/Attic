<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="attic.web.model.User"%> 
<%@ page import="java.util.ArrayList"%>
<%@ page import="attic.web.model.Node"%>
<%@ page import="attic.web.dao.NodeDao"%>
<%@ page import="attic.web.dao.NodeDaoImpl"%>

<%
	NodeDao nodeDao = new NodeDaoImpl(); 
	ArrayList<Node> NAV_KEY = new ArrayList();
	String MODULE_NAME;
	String ACTION_NAME;
	
	MODULE_NAME = request.getServletPath();
	int start = MODULE_NAME.lastIndexOf("/");
	MODULE_NAME = MODULE_NAME.substring(1,start); 
	start = MODULE_NAME.lastIndexOf("/");
	MODULE_NAME = MODULE_NAME.substring(start+1); //获取当前模块名，待改善
	
	ACTION_NAME = request.getServletPath();
	start = ACTION_NAME.lastIndexOf("/");
	int end = ACTION_NAME.lastIndexOf(".");
	ACTION_NAME = ACTION_NAME.substring(start+1,end);//获取当前action名
	
	NAV_KEY=nodeDao.getAllNav();
	
	session.setAttribute("module_name",MODULE_NAME);
	session.setAttribute("action_name",ACTION_NAME);
	session.setAttribute("nav",NAV_KEY);
	session.setAttribute("nav_son",NAV_KEY);
	
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
<link type="text/css" rel="stylesheet" href="../source/css/index.css" />
<link href="../source/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="../common/sidebar.jsp" />
    <div class="main">
    	<jsp:include page="../common/header.jsp">
    		<jsp:param value="首页" name="href"/>
    	</jsp:include>
    	<div class="content">
    		<div class="welcome block">
    			<h1>您好，${user.name}</h1>
    			<p>这是网站的后台，请您不要对系统做恶意的改动，否则将会破坏网站的运行。</p>
    			<p><strong>您可以点击左侧的菜单选择您需要的操作。</strong></p>	
    		</div>
    		<div class="notification block">
    			<h2>通知</h2>
    			<p>您暂时没有未读的通知。</p>
    		</div>
   	 	</div>
		<jsp:include page="../common/footer.jsp" />
    </div>
</div>
<script type="text/javascript" src="../source/js/jquery.js"></script>
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