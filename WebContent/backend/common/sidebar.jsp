 <%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="attic.web.model.Node"%> 
 <%@ page import="attic.web.dao.NodeDao"%> 
 <%@ page import="attic.web.dao.NodeDaoImpl"%> 
 <%@ page import="java.util.ArrayList" %>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  <%
  		NodeDao nodeDao = new NodeDaoImpl(); 
  		ArrayList<Node> NAV_KEY=nodeDao.getAllNav();
		Node navelem = new Node();
		int index;
		String b=request.getRequestURL().toString();
		out.println(b);
		session.setAttribute("nav",NAV_KEY);
		session.setAttribute("nav_son",NAV_KEY);
  %>
  <div class="sidebar">
      <div class="logo"><h1>后台管理</h1></div>
      <div class="sidebar-menu">
        <ul>
          <c:forEach var="nav" items="${nav}">   
				<c:if test="${nav.pid eq 0}">  
					<li><a href=""><i class="$nav.icon"></i>${nav.title}</a>
						<ul>
							<c:forEach var="nav_son" items="${nav_son}"> 
								<c:if test="${nav_son.pid eq nav.id}">						
									<li><a href="">${nav_son.title}</a></li>
								</c:if> 
							</c:forEach> 	
						</ul>
					</li>  
				</c:if>  		
		  </c:forEach>  
        </ul>
      </div>
      <div class="divider"></div>
  
  </div>