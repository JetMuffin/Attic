<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="attic.web.model.Admin"%> 
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<% 
	Admin admin = (Admin)session.getAttribute("admin"); 
	if(admin==null)
	{
		session.setAttribute("msg","请先登录！");
		response.sendRedirect("login.jsp");
		return;
	}
%>
	<div class="header"> 
      <div class="user">
            <div class="user-control">
              <a href="#" title="" class="user-ico" data-toggle="dropdown">
                  <img width="36" src="../source/images/hp3.jpg" alt="">
                  <span>${admin.realname}</span>
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
              <a href="../logout" class="logout">退出登录</a>
          </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="breadcrumb">
    	<c:forEach var="nav" items="${nav}">
    		<c:if test="${nav.pid eq 0 and nav.module eq module_name}">
    			<a><i class="fa fa-${nav.icon}"></i>${nav.title}</a>    		
	    		<c:forEach var="nav_son" items="${nav_son}"> 
					<c:if test="${nav_son.action eq action_name}">						
						<span><i class="fa fa-${nav_son.icon}"></i></i>${nav_son.title}</span>
					</c:if> 
				</c:forEach> 	
			</c:if>
    	</c:forEach>
    </div>