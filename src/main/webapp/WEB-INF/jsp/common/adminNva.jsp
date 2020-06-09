<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<nav class="navbar navbar-default " role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse2">
					<span class="sr-only">导航条</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath }/admin/adminhome">管理中心</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse2">
				<ul class="nav navbar-nav" id="nav-list">
					<li id="adminIndex"><a href="${pageContext.request.contextPath }/admin/adminhome">管理员主页</a></li>
					<li id="adminUser"><a href="${pageContext.request.contextPath }/admin/adminuser">用户管理</a></li>
					<c:if test="${user.role==99 }">
						<li id="adminBlock"><a href="${pageContext.request.contextPath }/admin/adminblock">板块管理</a></li>
					</c:if>
				</ul>
			</div>
		</nav>