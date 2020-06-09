<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
				<div class="thumbnail">
					<p style="height: 15px;margin-bottom: 0px;">&nbsp;</p>
					<img src="${pageContext.request.contextPath }/${user.upicsrc}" style="height: 240px;width: 240px;" class="img-rounded center-block" alt="头像">
					<div class="caption">
						<hr>
						<h3 class="text-center">${user.uname}</h3>
						<p class="text-center">${user.sign}</p>
					</div>
				</div>
				
				<div class="panel panel-default" style="min-height: 350px;">
				  	<div class="panel-heading">链接</div>
				  	<div class="list-group">
					  <a href="${pageContext.request.contextPath }/theuser/userhome" class="list-group-item">我的主页</a>
					  <a href="${pageContext.request.contextPath }/theuser/usertopics" class="list-group-item">我的主题</a>
					  <a href="${pageContext.request.contextPath }/theuser/usernotes" class="list-group-item">我的回帖</a>
					  <a href="${pageContext.request.contextPath }/theuser/userinfo" class="list-group-item">个人资料</a>
					  <a href="#" class="list-group-item">论坛主页</a>
					</div>
					<div class="panel-body">
					    About
					</div>
				</div>