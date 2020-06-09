<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav id="nav" class="navbar navbar-default " role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">导航条</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" style="padding: 10px 15px;" href=""> <img
				alt="百度" style="width:80px;height: 26px;"
				src="${pageContext.request.contextPath }/img/logo.jpg" />
			</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav" id="nav-list">
				<li id="indexhome"><a href="${pageContext.request.contextPath }">论坛</a></li>
				<c:if test="${!empty user }">
					<li id="userhome"><a href="${pageContext.request.contextPath }/theuser/userhome">个人中心</a></li>
					<c:if test="${user.role>0 }">
						<li id="adminhome"><a href="${pageContext.request.contextPath }/admin/adminhome">管理中心</a></li>
					</c:if>
				</c:if>
				<c:if test="${empty user }">
					<li id="login"><a href="${pageContext.request.contextPath }/user/tologin">登录</a></li>
					<li id="register"><a href="${pageContext.request.contextPath }/user/toregister">注册</a></li>
				</c:if>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${!empty user }">
					<li><a>${user.uname }</a></li>
					<li><a href="${pageContext.request.contextPath }/theuser/logout">注销</a></li>
				</c:if>
				<li><a href="#">About</a></li>
			</ul>
		</div>
	</div>
	</nav>