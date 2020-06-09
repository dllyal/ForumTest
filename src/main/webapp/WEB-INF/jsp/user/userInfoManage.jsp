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
    
    <title>个人信息管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
	
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/calendar.js"></script>
	
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
			$("#userInfo").addClass("active");
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
						
						<div style="padding: 20px;">
						
							<form id="jvForm" action="up/profile.do" method="post" enctype="multipart/form-data">
									
									
								<input id="upload" name="file" accept="image/*" type="file" style="display: none" onchange="uploadPic()" />
							
							
								<label for="upicsrc">头像</label>
							
								<img id="mypic" src="<%=basePath%>${user.upicsrc}" style="height: 180px;width: 180px;" class="img-rounded img-responsive" alt="头像">

								<p style="margin: 10px;"><button id="uploadpic" type="button" class="btn btn-primary btn-xs">点击选择更换头像</button></p>

							</form>
							
							
							
						
							<form action="theuser/userupdate" method="post" onsubmit="return formcheck();">
							
							<input id="upicsrc" readonly="readonly" type="hidden" name="upicsrc" value="${user.upicsrc }">

				            <div class="form-group has-feedback">
				                <label for="account">账号</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="account" readonly="readonly" class="form-control" maxlength="20" type="text" name="account" value="${user.account }">
				                </div>
				            </div>
				            
				            <div class="form-group has-feedback">
				                <label for="uname">用户名</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="uname" class="form-control" maxlength="20" type="text" name="uname" value="${user.uname }">
				                </div>
				            </div>
				            
				            <div class="form-group has-feedback">
				                <label for="sex">性别</label>
				                <div class="input-group">&nbsp;&nbsp;&nbsp;&nbsp;
				                   	<label class="radio-inline">
									  <input type="radio" name="sex" id="sex0" value="0" <c:if test='${user.sex == 0 }'>checked='checked'</c:if>> 男
									</label>
									<label class="radio-inline">
									  <input type="radio" name="sex" id="sex1" value="1" <c:if test='${user.sex != 0 }'>checked='checked'</c:if>> 女
									</label>
				                </div>
				            </div>

							<div class="form-group has-feedback">
				                <label for="birthday">生日</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="birthday" class="form-control" readonly="readonly" type="text" name="birthday" onclick="new Calendar().show(this)" value="<fmt:formatDate value='${user.birthday }' pattern='yyyy-MM-dd' />">
				                </div>
				            </div>
				            
				            <div class="form-group has-feedback">
				                <label for="phone">手机号码</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
				                    <input id="phone" class="form-control" maxlength="11" type="text" name="phone" value="${user.phone }">
				                </div>
				           	</div>
							
				            <div class="form-group has-feedback">
				                <label for="sign">签名</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="sign" class="form-control" maxlength="20" type="text" name="sign" value="${user.sign }">
				                </div>
				            </div>
				            
				            <div class="form-group has-feedback">
				                <label for="note">备注</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="note" class="form-control" maxlength="40" type="text" name="note" value="${user.note }">
				                </div>
				            </div>
							
							<br>
		
				            <div class="form-group">
				                <input class="form-control btn btn-primary" id="submit" value="保&nbsp;&nbsp;存&nbsp;&nbsp;修&nbsp;&nbsp;改" type="submit">
				            </div>
				            
				        	</form>
				        
				        </div>
				        
					</div>  
				</div>  
			
				<div class="panel panel-default">
				  	<div class="panel-heading">密码修改</div>
				  	<div class="panel-body">
				  		<div style="padding: 10px;">
				  			
				  			<form action="theuser/pwdupdate" method="post" onsubmit="return formcheckpwd();">
				  			
				  			<label for="note">请输入原密码:</label>
				    		<div id="oldpassworddiv" class="input-group">
						  		<input type="password" class="form-control" placeholder="请输入原密码" id="oldpassword" name="oldpassword">
						  		<span class="input-group-addon">
						  			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						  		</span>
						  	</div>
						  	<p id="oldpwderr" style="color: red;margin-top: 3px;">&nbsp;&nbsp;&nbsp;&nbsp;</p>
						  	
						  	<label for="note">请输入新密码:</label>
				    		<div id="newpassword1div" class="input-group">
						  		<input type="password" class="form-control" placeholder="请输入新密码" id="newpassword1" name="newpassword1">
						  		<span class="input-group-addon">
						  			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						  		</span>
						  	</div>
						  	<p id="newpwderr1" style="color: red;margin-top: 3px;">&nbsp;&nbsp;&nbsp;&nbsp;</p>
						  	
						  	<label for="note">请重复新密码:</label>
				    		<div id="newpassword2div" class="input-group">
						  		<input type="password" class="form-control" placeholder="请重复新密码" id="newpassword2" name="newpassword2">
						  		<span class="input-group-addon">
						  			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						  		</span>
						  	</div>
						  	<p id="newpwderr2" style="color: red;margin-top: 3px;">&nbsp;&nbsp;&nbsp;&nbsp;</p>

						  	<div class="form-group">
				                <input class="form-control btn btn-primary" id="submitpwd" value="确&nbsp;&nbsp;定&nbsp;&nbsp;修&nbsp;&nbsp;改" type="submit">
				            </div>
						  	
						  	</form>
						  	
						</div>
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

<script type="text/javascript">

	function formcheckpwd() {  
		if(!(checkoldpassword()&&checknewpassword1()&&checknewpassword2())){
			alert("请按要求输入！");  
	        return false; 
		}
	    var con;
		con=confirm("确定修改么?"); //在页面上弹出对话框
		if(con==true){
			return true;
		}else{
			return false; 		
		};  
	}

	function checkoldpassword() {
	    if ($('#oldpassword').val().length < 1) {
	        $('#oldpwderr').html("&nbsp;&nbsp;&nbsp;&nbsp;不能为空啊");
	        $('#oldpassworddiv').addClass("has-error");
	        return false;
	    }else{
	    	return true;
	    }
	}

	function checknewpassword1() {
	    if ($('#newpassword1').val().length < 8) {
	        $('#newpwderr1').html("&nbsp;&nbsp;&nbsp;&nbsp;密码太短，不能少于8个字符");
	        $('#newpassword1div').addClass("has-error");
	        return false;
	    } else {
	        if (atLeastTwo($('#newpassword1').val()) < 2) {
	           $('#newpwderr1').html("&nbsp;&nbsp;&nbsp;&nbsp;密码中至少包含字母、数字、特殊字符的两种");
	           $('#newpassword1div').addClass("has-error");
	           return false;
	        } else {
	           return true;
	        }
	    }
	}
	
	function checknewpassword2() {
	    if ($('#newpassword2').val() != $('#newpassword1').val()) {
	        $('#newpwderr2').html("&nbsp;&nbsp;&nbsp;&nbsp;两次输入的密码不一致");
	        $('#newpassword2div').addClass("has-error");
	        return false;
	    } else {
	        return true;
	    }
	}
	
	// 匹配字母、数字、特殊字符至少两种的函数
	function atLeastTwo(password) {
		var PasswordSpecial = /[~!@#%&=;':",./<>_\}\]\-\$\(\)\*\+\.\[\?\\\^\{\|]/;
		var PasswordAlpha = /[a-zA-Z]/;
		var PasswordNum = /[0-9]/;
	    var a = PasswordSpecial.test(password) ? 1 : 0;
	    var b = PasswordAlpha.test(password) ? 1 : 0;
	    var c = PasswordNum.test(password) ? 1 : 0;
	    return a + b + c;
	}
	
	$('#oldpassword').focus(function() {
		$('#oldpwderr').html("&nbsp;&nbsp;&nbsp;&nbsp;");
		$('#oldpassworddiv').removeClass("has-error");
	});
	
	$('#oldpassword').blur(function() {
		checkoldpassword();
	});

	
	$('#newpassword1').change(function() {
		checknewpassword1();
	});
	
	$('#newpassword2').change(function() {
		checknewpassword2();
	});
	
	$('#newpassword1').focus(function() {
		$('#newpwderr1').html("&nbsp;&nbsp;&nbsp;&nbsp;");
		$('#newpassword1div').removeClass("has-error");
	});
	
	$('#newpassword2').focus(function() {
		$('#newpwderr2').html("&nbsp;&nbsp;&nbsp;&nbsp;");
		$('#newpassword2div').removeClass("has-error");
	});
	
	$('#newpassword1').blur(function() {
		checknewpassword1();
	});
	
	$('#newpassword2').blur(function() {
		checknewpassword2();
	});


</script>

<script type="text/javascript">
	//修改资料，提交前检查
	function formcheck() {  
		
		var bool1 = $("#upicsrc").val()=="";
		var bool2 = $("#account").val()=="";
		var bool3 = $("#uname").val()=="";
		var bool4 = $("#birthday").val()=="";
		var bool5 = $("#phone").val()=="";
		var bool6 = $("#sign").val()=="";
		
		if(bool1||bool2||bool3||bool4||bool5||bool6){
			alert("除备注外都不能为空！");  
	        return false; 
		}
	    var con;
		con=confirm("确定修改么?"); //在页面上弹出对话框
		if(con==true){
			return true;
		}else{
			return false; 		
		};  
	} 
</script>

<script type="text/javascript">
	//上传头像图片
	$(function() {

		$("#uploadpic").click(function() {
			$("#upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
		});

		//建立一個可存取到該file的url
		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) { // basic
				url = window.createObjectURL(file) ;
			} else if (window.URL != undefined) { // mozilla(firefox)
				url = window.URL.createObjectURL(file) ;
			} else if (window.webkitURL != undefined) { // webkit or chrome
				url = window.webkitURL.createObjectURL(file) ;
			}
			return url;
		}
	});

	function uploadPic() {
		var huanchong = "img/huanchong.gif";
		$("#mypic").attr("src", huanchong) ; //将图片路径存入src中，显示出图片
		// 上传设置  
		var options = {
			// 规定把请求发送到那个URL  
			url : "up/profile.do",
			// 请求方式  
			type : "post",
			// 服务器响应的数据类型  
			dataType : "json",
			// 请求成功时执行的回调函数  
			success : function(data, status, xhr) { 
				if (data.msg == "ok") {
					var path = data.file_path;
					$("#mypic").attr("src", "<%=basePath%>"+path) ;
					$("#upicsrc").attr("value", path) ;
				} else if (data.msg == "false") {
					alert("上傳失敗了");
					$("#mypic").attr("src", $("#upicsrc").val()) ;
				} else {
					alert("出現故障");
					$("#mypic").attr("src", $("#upicsrc").val()) ;
				}
			}
		};

		$("#jvForm").ajaxSubmit(options);
	}
</script>

</html>
