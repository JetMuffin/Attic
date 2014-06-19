<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-首页</title>
<link type="text/css" rel="stylesheet" href="${PUBLIC}/css/index.css" />
<link type="text/css" rel="stylesheet" href="${PUBLIC}/css/unit.css" />
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
			<div class="prtc-header">
    			<h2>${subject}</h2>
    			<small>第${unit}单元</small>
    		</div>
    		<div class="prtc-statics">
    			<h1>${score}分！</h1>
    			<h3>你共做对了${cornum}题，做错了${wrongnum}题</h3>
    		</div>
	   	 	<c:forEach var="ws" items="${wrongset}" varStatus="status">
	        	<div class="prtc-ques">
	        		<div class="prtc-desc"><p><span>${ws.number}. </span>${ws.description}</p></div>
	        		<div class="prtc-op">${ws.option}</div>
	        		<div class="prtc-answer">
	        			<span>正确答案：<strong>${ws.answer}</strong></span>
	        			<span>你的答案：${fn:substring(wronganswer,status.index,status.index+1)}</span>
	        		</div>
	        	</div>
	        </c:forEach>
        </div>
		<jsp:include page="../common/footer.jsp" />
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
        
        //读取JSON题目选项信息
        var question=$(".prtc-ques");
        var i = 1;
        question.each(function(){
            var json_data = $(this).children(".prtc-op").html();
            var json=eval(json_data); 
            var option,option_html="<p>";
            $.each(json,function(i,n){  
                option =  "<span>"+json[i].option + ". " + json[i].answer +"</span>";
                option_html += option;              
            });
            option_html+="</p>";
            console.log(option_html);
             $(this).children(".prtc-op").html(option_html);
            i++;
        });
        });
</script>
</body>
</html>