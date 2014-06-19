<%@ page language="java" contentType="text/html; charset=utf-8"%> 

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
    		<div class="welcome block">
    			<h1>您好，${user.name}</h1>
    			<p>欢迎来到练习系统！</p>
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
        
        var height = $(".main").height();
        $(".sidebar").css("min-height",height);
        
	});
</script>
</body>
</html>