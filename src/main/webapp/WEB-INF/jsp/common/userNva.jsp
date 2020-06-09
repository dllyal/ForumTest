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
				<a class="navbar-brand" href="${pageContext.request.contextPath }/theuser/userhome">个人中心</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse2">
				<ul class="nav navbar-nav" id="nav-list">
					<li id="userHome0"><a href="${pageContext.request.contextPath }/theuser/userhome">个人主页</a></li>
					<li id="userTopics"><a href="${pageContext.request.contextPath }/theuser/usertopics">我的主题</a></li>
					<li id="userNotes"><a href="${pageContext.request.contextPath }/theuser/usernotes">我的回帖</a></li>
					<li id="userInfo"><a href="${pageContext.request.contextPath }/theuser/userinfo">个人资料</a></li>
				</ul>
			</div>
		</nav>