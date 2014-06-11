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
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-首页</title>
<link type="text/css" rel="stylesheet" href="css/index.css" />
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="sidebar">
      <div class="logo"><h1>后台管理</h1></div>
      <div class="sidebar-menu">
        <ul>
          <li class="current"><a href=""><i class="fa fa-dashboard"></i>首页</a></li>
          <li><a href=""><i class="fa fa-image"></i>管理员设置</a></li>
          <li><a href=""><i class="fa fa-folder-open"></i>功能菜单2</a></li>
          <li><a href=""><i class="fa fa-tags"></i>功能菜单3</a></li>
          <li><a href=""><i class="fa fa-laptop"></i>功能菜单4</a></li>
        </ul>
      </div>
      <div class="divider"></div>
  </div>
  <div class="mainbody">
    <div class="header">
      
      <div class="user">
            <div class="user-control">
              <a href="#" title="" class="user-ico" data-toggle="dropdown">
                  <img width="36" src="images/hp3.jpg" alt="">
                  <span><%=admin.getRealname() %></span>
                  <i class="fa fa-chevron-down"></i>
              </a>
             <!--  <ul class="dropdown-menu float-right">
                  <li>
                      <span class="badge badge-absolute float-left radius-all-100 mrg5R gradient-green tooltip-button" title="" data-original-title="You can add badges even to dropdown menus!">7</span>
                          <i class="glyph-icon icon-user mrg5R"></i>
                          Account Details
                  </li>
                  <li>
                          <i class="glyph-icon icon-cog mrg5R"></i>
                          Edit Profile
                  </li>
                  <li>
                          <i class="glyph-icon icon-flag mrg5R"></i>
                          Notifications
                  </li>
                  <li>
                          <i class="glyph-icon icon-signout font-size-13 mrg5R"></i>
                          <span class="font-bold">Logout</span>
                  </li>
              </ul> -->
          </div>
          <div class="user-logout">
              <a href="logout" class="logout">退出登录</a>
          </div>
      </div>
      <div class="clear"></div>
    </div>
  </div>
</div>
<div class="footer"></div>
</body>
</html>