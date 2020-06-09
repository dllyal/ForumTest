<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>全球化的论坛交流社区.</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="论坛,forum,交流">
<meta http-equiv="description" content="This is my page">

<style>
html {
	overflow-y: scroll;
}
</style>

<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>

<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>



</head>

<body>
	<%@include file="jsp/common/nva.jsp"%>
	<script type="text/javascript">
		$("#indexhome").addClass("active");
	</script>

	<div class="container">

		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="carousel slide" style="background-color: #E6E5E5" id="carousel-853792">
					<ol id="lunboli" class="carousel-indicators">
						<li class="active" data-slide-to="0" data-target="#carousel-853792"></li>
						
					</ol>
					<div id="lunbodiv" class="carousel-inner">
						<div class="item active" >
							<img alt="" width="100%" height="100%"
								src="<%=basePath%>img/index.jpg" />
							<div class="carousel-caption">
								<h4>全球化的论坛交流社区.</h4>
								<p> 全球化的论坛交流社区  </p>
							</div>
						</div>
						
						
					</div>
					<a class="left carousel-control" href="#carousel-853792"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-853792"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		</div>
		
		<hr>
		
		<div class="row clearfix">
			<div class="col-md-12 column" style="">
				<div class="row" id="blockbox" style="">
				
					
				</div>
			</div>
		</div>
		
		<hr>

		This is my Forum. <br> 
		
	</div>
	
	<c:if test="${!empty msg }">
		<script type="text/javascript">
			alert("${msg }");
		</script>
	</c:if>

</body>

<script type="text/javascript">
	
	$.post(
		"forum/getblocks",
		{},
		function(data) {
		
			var obj = JSON.parse(data);
			for(var i=0;i<obj.length;i++){
				var newElement = document.createElement("div");
				newElement.setAttribute('class', "col-md-4");
				obj[i].bname
				var vvv=
					'<div class="thumbnail" style="margin-bottom: 0px;">'+
						'<img alt="300x200" src="'+obj[i].bpicsrc+'" />'+
						'<div class="caption">'+
							'<h3>'+obj[i].bname+'</h3>'+
							'<p>'+obj[i].bcontext+'</p>'+
							'<p> <a target="_blank" class="btn btn-primary" href="forum/getTopics?bid='+obj[i].bid+'">进入</a></p>'+
						'</div>'+
					'</div>'
				;
				
				newElement.innerHTML = vvv;
				var targetElement = document.getElementById("blockbox");
				targetElement.appendChild(newElement);
				
				var n=i+1;
				var $li = '<li data-slide-to="'+n+'" data-target="#carousel-853792"></li>';
				$('#lunboli').append($li); //将新创建的div节点插入到nav容器的内容底部
				
				var $div = ''
						+'<div class="item" style="">'
							+'<img alt="" src="'+obj[i].bpicsrc+'" width="100%" height="100%" />'
							+'<div class="carousel-caption">'
								+'<h4>'+obj[i].bname+'</h4>'
								+'<p>'+obj[i].bcontext+'</p>'
							+'</div>'
						+'</div>';
				$('#lunbodiv').append($div); //将新创建的div节点插入到nav容器的内容底部
				
			};
		}
	);
</script>

</html>
