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
    
    <title>个人中心</title>
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
		dt{
			font-size: 15px;
			margin-bottom: 15px;
		}
		dl{
			margin-bottom: 0px;
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
			$("#userHome0").addClass("active");
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
						<dl class="dl-horizontal">
							<dt>账号</dt>
							<dd>${user.account}</dd>
							<dt>用户名</dt>
							<dd>${user.uname}</dd>
							<dt>用户签名</dt>
							<dd>${user.sign}</dd>
							<dt>联系方式</dt>
							<dd>${user.phone}</dd>
							<dt>用户身份</dt>
							<c:if test="${user.role==99 }">
						  		<dd>超级管理员</dd>
						  	</c:if>
						  	<c:if test="${user.role==66 }">
						  		<dd>管理员</dd>
						  	</c:if>
						  	<c:if test="${user.role==0 }">
						  		<dd>普通用户</dd>
						  	</c:if>
							<dt>用户状态</dt>
							<c:if test="${user.state==0 }">
						  		<dd>正常</dd>
						  	</c:if>
						  	<c:if test="${user.state!=0 }">
						  		<dd>受限</dd>
						  	</c:if>
							<dt>账号注册于</dt>
							<dd><fmt:formatDate value="${user.createtime }" pattern=" yyyy-MM-dd" /></dd>
						</dl>
					</div>  
				</div>
				
				<div class="panel panel-default">
				  	<div class="panel-heading">最近发表主题</div>
				  	<ul class="list-group">
					  	<c:if test="${p.pages!=0 }">
					  		<c:forEach items="${p.list }" var="topic">
					  			<li class="list-group-item">
					  				<cite>
										<fmt:formatDate value="${topic.createtime }" pattern=" yyyy-MM-dd HH:mm:ss " />
									</cite>
					  				<h4 style="margin-bottom: 5px;margin-top: 10px;"> 相关主题：
						  				<a href="<%=basePath%>forum/readfloors?tid=${topic.tid }">
											${topic.tname }
										</a>
									</h4>
							  	</li>
					  		</c:forEach>
					  		<li class="list-group-item">
						  		&nbsp;&nbsp;&nbsp;......
						  	</li>
					  	</c:if>
					  	<c:if test="${p.pages==0 }">
					  		<li class="list-group-item">
						  		最近没发表主题
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


</html>
