<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-首页</title>
<link type="text/css" rel="stylesheet" href="${PUBLIC}/css/index.css" />
<link type="text/css" rel="stylesheet" href="${PUBLIC}/css/total.css" />
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
    		<div>
    			<c:forEach var="subj" items="${subj}">
					<c:if test="${subj.isnav eq 1}">
						<div class="sbjt">
			                <div class="sbjt-title">
			                    <h3>${subj.title}<small>/${subj.name}</small></h3>         
			                </div>  
			           	 	<div class="sbjt-complete">
			            	</div>
			            	<div class="sbjt-info">
			                	<div class="sbjt-progress">
			                        <div class="progress">
			                          <div class="progress-bar" ></div>
			                        </div>
			                        <label class="progress-label">100%</label>
			                	</div>
			                	<div class="sbjt-detail">（共<strong id="total">${subj.unitnum}</strong>单元 已完成<strong id="cmplt">			      
			                		<c:set value="0" var="pcmpValue"/>
			                		<c:forEach var="pcmp" items="${pcmp}">
										<c:choose>
											<c:when test="${pcmp.key eq subj.name}">
												<c:set value="${pcmp.value}" var="pcmpValue"/>
											</c:when>
										</c:choose>
				        			</c:forEach>
				        			${pcmpValue}</strong>单元）
				        			
			                    	<a href="javascript:;" class="sbjt-opentag">查看<i class="fa fa-chevron-down"></i></a>
			                	</div>
			            	</div>
			            	<div class="sbjt-unit" id="English">
			            		<table>
			            			<c:forEach var="subj_unit" items="${subj_unit}">
				            			<c:if test="${subj_unit.name eq subj.name and subj_unit.isnav ne 1}">
					            			<c:set value="0" var="done" scope="session" />
					            			<c:set value="0" var="score" scope="session" />
					            			<tr>
					            				<td class="unit-title">第${subj_unit.unit}单元</td>
					            				<td>共${subj_unit.quesnum}题</td>
					            				<c:forEach var="ps" items="${userPracSet}">
													<c:if test="${ps.subject eq subj.name and ps.unit eq subj_unit.unit}">
														<c:set value="1" var="done" scope="session" />
														<c:set value="${ps.score}" var="score" scope="session" />
													</c:if>			
							        			</c:forEach>
							        			<c:choose>  
												   <c:when test="${done eq 1}"><td>已完成(<strong>${score}分</strong>)</td></c:when>  
												   <c:otherwise><td>未完成</td></c:otherwise>  
												</c:choose> 
					            				<td><a href="practice?subject=${subj_unit.name}&unit=${subj_unit.unit}"><i class="fa fa-edit"></i>开始做题</a></td>
					            			</tr>
				            			</c:if>
			            			</c:forEach>
			            		</table>
			            	</div>
						</div>
					</c:if>
	        	</c:forEach>
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
        
        $(".sbjt-opentag").click(function(){
        	$(this).parent().parent().parent().children(".sbjt-unit").fadeToggle();
        });
        
        //设置进度条及百分数
        $(".sbjt-detail").each(function(){
        	var total = $(this).children("#total").html();
        	var cmplt = $(this).children("#cmplt").html().trim();
        	var cmpltPercent = parseInt(cmplt*100/total);
        	var cmpltPercentHtml = cmpltPercent + "%";
        	
        	var color;
        	if(cmpltPercent<=5)
        		color = "#f63a0f";
        	else if(cmpltPercent<=25)
        		color = "#F27011";
        	else if(cmpltPercent<=50)
        		color = "#F2B01E";
        	else if(cmpltPercent<=75)
        		color = "#F2D31B";
        	else color = "#86E01E";
        	
        	var progress = $(this).prev(".sbjt-progress");
        	progress.children(".progress-label").html(cmpltPercentHtml);
        	progress.children().children(".progress-bar").css("width",cmpltPercentHtml);
        	progress.children().children(".progress-bar").css("background-color",color);
        });
        
	});
</script>
</body>
</html>