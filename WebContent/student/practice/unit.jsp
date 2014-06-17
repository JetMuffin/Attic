<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

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
            <div class="prtc-form">
                <form>
        			<c:forEach var="qs" items="${queset}">
        				<div class="prtc-ques">
        					<div class="prtc-desc"><p><span>${qs.number}. </span>${qs.description}</p></div>
        					<div class="prtc-op">${qs.option}</div>
        				</div>
        			</c:forEach>
        			<input type="submit" class="btn"/>
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

        //读取JSON题目选项信息
        var question=$(".prtc-form form .prtc-ques");
        var i = 1;
        question.each(function(){
            var json_data = $(this).children(".prtc-op").html();
            var json=eval(json_data); 
            var option_base = "<label><input type='radio' name='question_" + i + "'";
            var option,option_html="";
            $.each(json,function(i,n){  
                option = option_base + "value='" + json[i].option +"'/>" + json[i].option 
                        + ". " + json[i].answer +"</label>";
                option_html += option;              
            });
            console.log(option_html);
             $(this).children(".prtc-op").html(option_html);
            i++;
        });
	});
</script>
</body>
</html>