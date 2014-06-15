 <%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  <div class="sidebar">
      <div class="logo"><h1>后台管理</h1></div>
      <div class="sidebar-menu">
        <ul>
          <c:forEach var="nav" items="${nav}">   
				<c:if test="${nav.pid eq 0}">  
					<c:choose>  
					   <c:when test="${nav.module eq module_name}"><li class="current-page"></c:when>  
					   <c:otherwise><li></c:otherwise>  
					</c:choose> 
						<a href="javascript:;"><i class="fa fa-${nav.icon}"></i>${nav.title}</a>
						<ul>
							<c:forEach var="nav_son" items="${nav_son}"> 
								<c:if test="${nav_son.pid eq nav.id}">						
									<li><a href=${nav_son.url}><i class="fa fa-chevron-right"></i>${nav_son.title}</a></li>
								</c:if> 
							</c:forEach> 	
						</ul>
					</li>  
				</c:if>  		
		  </c:forEach>  
        </ul>
        <div class="divider"></div>
      </div>      
  </div>