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
    
    <title>管理用户</title>
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
		$("#adminhome").addClass("active");
	</script>
	
  	<div class="container">
		
		<%@include file="../common/adminNva.jsp"%>
		<script type="text/javascript">
			$("#adminUser").addClass("active");
		</script>
		
		<div class="row" style="border: 0px solid #DDDDDD;padding: 0px;">
		
			<div class="col-sm-6 col-md-3" style="border: 0px solid #DDDDDD;">
				<%@include file="../common/auLeft.jsp"%>
			</div>
			
			<div class="col-sm-6 col-md-9" style="border: 0px solid #DDDDDD;">
				
				<div class="page-header">
				
					<c:if test="${user.role==99 }">
						<h1>超级管理员 <small>Super administrator</small></h1>
					</c:if>
					<c:if test="${user.role==66 }">
						<h1>管理员 <small>Administrator</small></h1>
					</c:if>
				  	
				</div>
				
				<div class="thumbnail">
					
					<p style="height: 5px;margin-bottom: 0px;">&nbsp;</p>
					<div class="caption">
						<blockquote>
							<p>
								全球化的论坛交流社区.
							</p> <small>关键词 <cite>开源</cite></small>
						</blockquote>
						
						<div class="row">
							<div class="col-lg-3"></div>
							<div class="col-lg-9">
								<form class="form-inline" action="admin/adminuser">
									<div class="form-group">
								    	<div class="input-group">
								      		<div class="input-group-addon">请输入用户昵称或账号</div>
								      		<input type="text" class="form-control" name="words">								    
								    	</div>
								  	</div>
									<button type="submit" class="btn btn-primary">搜索</button>
								</form>
							</div>
						</div>
						<hr style="margin: 0px;">
						
						<div class="table-responsive">
							<table class="table table-hover table-bordered">
								<tr><th>#</th><th>账号</th><th>昵称</th><th> </th></tr>
								<c:forEach items="${p.list }" var="theuser">	
							  		<tr>
							  			<td>${theuser.uid }</td>
							  			<td>${theuser.account }</td>
										<td>${theuser.uname }</td>
										<td>
											<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath }/admin/adminuserinfo?userid=${theuser.uid}" role="button">用户信息操作</a>&nbsp;&nbsp;
											<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath }/admin/adminusernote?uid=${theuser.uid}" role="button">用户帖子操作</a>&nbsp;&nbsp;
											<a class="btn btn-default btn-xs" href="${pageContext.request.contextPath }/admin/adminusertopic?uid=${theuser.uid}" role="button">用户主题操作</a>
										</td>
									</tr>
							  	</c:forEach>
								
							</table>
						</div>
						
						
						
						<!-- 分页 -->
					  	<c:set var="pageUrl" value="admin/adminuser?page="></c:set>
					  	<!-- 最多显示MostPageNum个页码，当前页最多在页码条中居第MidActivePageNum位 -->
						<c:set var="MostPageNum" value="6"></c:set>
						<c:set var="MidActivePageNum" value="3"></c:set>
					  	<%@include file="../common/setPage.jsp" %>
						
					</div>  
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


</html>
