<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人主题帖管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
	
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	
	<style type="text/css">
		html {
			overflow-y: scroll;
		}
	</style>
	
  </head>
  
<body>

	<%@include file="../common/nva.jsp"%>
	<script type="text/javascript">
		$("#userhome").addClass("active");
	</script>

  	<div class="container">
		
		<%@include file="../common/userNva.jsp"%>
		<script type="text/javascript">
			$("#userTopics").addClass("active");
		</script>
		
		<div class="row" style="border: 0px solid #DDDDDD;padding: 0px;">
			<div class="col-sm-6 col-md-3" style="border: 0px solid #DDDDDD;">
				<%@include file="../common/auLeft.jsp"%>
			</div>
			<div class="col-sm-6 col-md-9" style="border: 0px solid #DDDDDD;">
				<div class="thumbnail">
					<p style="height: 5px;margin-bottom: 0px;">&nbsp;</p>
					<div class="caption">
						<blockquote>
							<p>
								全球化的论坛交流社区.
							</p> <small>关键词 <cite>开源</cite></small>
						</blockquote>
						<br>
						
					</div>  
				</div> 
				<div class="panel panel-default">
				  	<div class="panel-heading">我的主题</div>
				  	<ul class="list-group">
					  	<c:if test="${p.pages!=0 }">
					  		<c:forEach items="${p.list }" var="topic">
					  			<li class="list-group-item">
					  				<cite>
										<fmt:formatDate value="${topic.createtime }" pattern=" yyyy-MM-dd HH:mm:ss " />
									</cite>
					  				<h4 style="margin-bottom: 5px;margin-top: 10px;"> 主题：
						  				<a href="<%=basePath%>forum/readfloors?tid=${topic.tid }">
											${topic.tname }
										</a>
									</h4>
									<hr style="margin-top: 3px;margin-bottom: 3px;">
									<div style="background-color: #F7F7F9;padding: 10px;margin-bottom: 5px;word-break:break-all;">
										${topic.tcontext }
									</div>
									<p class="text-right"><a href="javascript:deltopic(${topic.tid});" class="btn btn-danger btn-xs" role="button" >删除</a>&nbsp;&nbsp;&nbsp;&nbsp;</p>
							  	</li>
					  		</c:forEach>
					  		
					  		<!-- 分页 -->
					  		<c:set var="pageUrl" value="theuser/usertopics?page="></c:set>
					  		<!-- 最多显示MostPageNum个页码，当前页最多在页码条中居第MidActivePageNum位 -->
							<c:set var="MostPageNum" value="6"></c:set>
							<c:set var="MidActivePageNum" value="3"></c:set>
					  		<%@include file="../common/setPage.jsp" %>
					  		
							<br>
					  		
					  	</c:if>
					  	<c:if test="${p.pages==0 }">
					  		<li class="list-group-item">
						  		最近没发表
						  	</li>
					  	</c:if>
					</ul>
				</div> 
			</div>  
		</div>
		
	</div>
	
	<c:if test="${!empty msg }">
		<script type="text/javascript">
			alert("${msg }");
		</script>
	</c:if>

</body>

<script type="text/javascript">
	function deltopic(tid) 
	{ 
	    var con;
		con=confirm("确定删除么?"); //在页面上弹出对话框
		if(con==true){
			var obj = "0";
			$.post(
		  		"theuser/userdeltopic",
		  		{"tidStr":tid},
		  		function(data){
		  			obj = JSON.parse(data).toString();
		  			if(obj == "1"){
		  				alert("请确保登录状态");
		  			};
		  			if(obj != "2"){
		  				alert("出现错误");
		  			}else{
		  				alert("删除成功");
		  				//window.location.href=window.location.href;
		  			};
				}
			);
			window.location.href=window.location.href;
		};
	};
</script>

</html>
