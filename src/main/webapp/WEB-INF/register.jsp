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
    
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
	
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="<%=basePath%>css/formbox.css">
	
	<style>
		body {
		  background-color: #eee;
		  overflow: hidden;
		}
		canvas {
		  z-index: -3;
		  position: fixed;
		  left: 0px;
		  top: 0px;
		  background-color: #0C6CC7;
		  display: block;
		  margin: 0 auto;
		}
	</style>
	
  </head>
  
<body>

	<%@include file="jsp/common/nva.jsp"%>
	<script type="text/javascript">
		$("#register").addClass("active");
	</script>

  	<div class="container">

		<nav class="navbar navbar-default">
		  	<div class="container-fluid">
		    	<div class="navbar-header">
		      		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
	          			<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
	        		</div>
		    	</div>
		  	</div>
		</nav>

		<div class="inputbox" >
		    <div class="col-md-6 col-md-offset-3 " style="border: 1px solid #DDDDDD;opacity: 0.93;background-color: #FFFFFF;padding-top: 10px;">
		        <form action="user/register" method="post">

		            <div class="form-group has-feedback">
		                <label for="username">用户名</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
		                    <input id="username" class="form-control" placeholder="请输入用户名" maxlength="20" type="text" name="account">
		                </div>

		                <span style="color:red;display: none;" class="tips"></span>
		                <span style="display: none;" class=" glyphicon glyphicon-remove form-control-feedback"></span>
		                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
		            </div>

		            <div class="form-group has-feedback">
		                <label for="password">密码</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		                    <input id="password" class="form-control" placeholder="请输入密码" maxlength="20" type="password" >
		                </div>

		                <span style="color:red;display: none;" class="tips"></span>
		                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
		                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
		            </div>

		            <div class="form-group has-feedback">
		                <label for="passwordConfirm">确认密码</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		                    <input id="passwordConfirm" class="form-control" placeholder="请再次输入密码" maxlength="20" type="password" name="password">
		                </div>
		                <span style="color:red;display: none;" class="tips"></span>
		                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
		                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
		            </div>


		            <div class="row">
		                <div class="col-xs-7">
		                    <div class="form-group has-feedback">
		                        <label for="idcode-btn">验证码</label>
		                        <div class="input-group">
		                            <span class="input-group-addon"><span class="glyphicon glyphicon-qrcode"></span></span>
		                            <input id="idcode-btn" class="form-control" placeholder="请输入验证码" maxlength="4" type="text">
		                        </div>
		                        <span style="color:red;display: none;" class="tips"></span>
		                        <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
		                        <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
		                    </div>
		                </div>
		                <div class="col-xs-5" style="padding-top: 30px">
		                    <div id="idcode" style="background: transparent;"></div>
		                </div>
		            </div>

		            <div class="form-group has-feedback">
		                <label for="phoneNum">手机号码</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
		                    <input id="phoneNum" class="form-control" placeholder="请输入手机号码" maxlength="11" type="text" name="phone">
		                </div>
		                <span style="color:red;display: none;" class="tips"></span>
		                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
		                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
		            </div>
					
					<br>

		            <div class="form-group">
		                <input class="form-control btn btn-primary" id="submit" value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册" type="submit">
		            </div>

		            <div class="form-group">
		                <input value="重置" id="reset" class="form-control btn btn-danger" type="reset">
		            </div>
		        </form>
		    </div>
		</div>

	</div>
	
	<canvas id="canvas"></canvas>

</body>

<script type="text/javascript" src="<%=basePath%>js/register.js"></script>

<script type="text/javascript" src="<%=basePath%>js/pointBG.js"></script>

</html>
