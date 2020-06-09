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
    
    <title>论坛板块维护</title>
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
		$("#adminhome").addClass("active");
	</script>
	
  	<div class="container">
		
		<%@include file="../common/adminNva.jsp"%>
		<script type="text/javascript">
			$("#adminBlock").addClass("active");
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

						<div style="padding: 20px;">
						
							<h3><span class="label label-default">板块编辑</span></h3>
						
							<div class="page-header">
								<h1>${block.bname} <small>${block.bid}</small></h1>					  	
							</div>
						
							<form id="jvForm" action="up/profile.do" method="post" enctype="multipart/form-data">
									
									
								<input id="upload" name="file" accept="image/*" type="file" style="display: none" onchange="uploadPic()" />
							
							
								<label for="upicsrc">封面图</label>
							
								<img id="mypic" src="<%=basePath%>${block.bpicsrc}" style="height: 150px;width: 450px;" class="img-rounded img-responsive" alt="头像">

								<p style="margin: 10px;"><button id="uploadpic" type="button" class="btn btn-primary btn-xs">点击选择更换图片</button></p>

							</form>

							<form action="admin/adminblockupdate" method="post" onsubmit="return formcheck();">
							
							<input id="bpicsrc" readonly="readonly" type="hidden" name="bpicsrc" value="${block.bpicsrc }">
							<input id="bid" readonly="readonly" type="hidden" name="bid" value="${block.bid }">

				            
				            <div class="form-group has-feedback">
				                <label for="bname">板块名</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="bname" class="form-control" maxlength="20" type="text" name="bname" value="${block.bname }">
				                </div>
				            </div>
				            
				            <div class="form-group has-feedback">
				                <label for="bcontext">板块介绍</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="bcontext" class="form-control" maxlength="20" type="text" name="bcontext" value="${block.bcontext }">
				                </div>
				            </div>
      
				            <div class="form-group has-feedback">
				                <label for="note">备注</label>
				                <div class="input-group">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				                    <input id="note" class="form-control" maxlength="40" type="text" name="note" value="${block.note }">
				                </div>
				            </div>
							
							<div class="form-group has-feedback">
				                <label for="state">状态</label>
				                <div class="input-group">&nbsp;&nbsp;&nbsp;&nbsp;
				                   	<label class="radio-inline">
									  <input type="radio" name="state" id="state0" value="0" <c:if test='${block.state == 0 }'>checked='checked'</c:if>> 正常
									</label>
									<label class="radio-inline">
									  <input type="radio" name="state" id="state1" value="1" <c:if test='${block.state == 1 }'>checked='checked'</c:if>> 受限
									</label>
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

	//修改资料，提交前检查
	function formcheck() {  
		
		var bool1 = $("#upicsrc").val()=="";
		var bool2 = $("#bcontext").val()=="";
		var bool3 = $("#bname").val()=="";
		var bool4 = $("#bid").val()=="";
		
		if(bool1||bool2||bool3||bool4){
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
			url : "up/up.do",
			// 请求方式  
			type : "post",
			// 服务器响应的数据类型  
			dataType : "json",
			// 请求成功时执行的回调函数  
			success : function(data, status, xhr) { 
				if (data.msg == "ok") {
					var path = data.file_path;
					$("#mypic").attr("src", "<%=basePath%>"+path) ;
					$("#bpicsrc").attr("value", path) ;
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
