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
    
    <title>论坛板块管理</title>
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
						<br>
						
						<hr>
		
						<div class="row clearfix">
							<div class="col-md-12 column" style="">
								<div class="row" id="blockbox" style="">
								
									
								</div>
							</div>
						</div>
						
						<hr>
						
						<p>
							<a target="_blank" class="btn btn-primary" href="admin/adminblockadd">添加新板块</a>
						</p>
						
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
	
	$.post(
		"forum/getallblock",
		{},
		function(data) {
		
			var obj = JSON.parse(data);
			for(var i=0;i<obj.length;i++){
				var newElement = document.createElement("div");
				newElement.setAttribute('class', "col-md-4");
				
				var delre = '<a href="javascript:delblock('+obj[i].bid+');" class="btn btn-danger btn-xs" role="button" >删除</a>&nbsp;&nbsp;&nbsp;&nbsp;';
				if(obj[i].state==1){
					delre = '<a href="javascript:reblock('+obj[i].bid+');" class="btn btn-info btn-xs" role="button" >恢复</a>&nbsp;&nbsp;&nbsp;&nbsp;';
				};
				
				var vvv=
					'<div class="thumbnail" style="margin-bottom: 0px;">'+
						'<img alt="300x200" src="'+obj[i].bpicsrc+'" />'+
						'<div class="caption">'+
							'<h3>'+obj[i].bname+'</h3>'+
							'<p>'+obj[i].bcontext+'</p>'+
							'<p> '+
								'<a target="_blank" class="btn btn-primary" href="topic/read?bid='+obj[i].bid+'">进入</a>&nbsp;&nbsp;&nbsp;&nbsp;'+
								'<a target="_blank" class="btn btn-primary" href="admin/adminblockinfo?bid='+obj[i].bid+'">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;'+
								delre+
							'</p>'+
						'</div>'+
					'</div>'
				;
				
				newElement.innerHTML = vvv;
				var targetElement = document.getElementById("blockbox");
				targetElement.appendChild(newElement);
				
				
				
			};
		}
	);
</script>


<script type="text/javascript">
	
	function delblock(bid) 
	{ 
	    var con;
		con=confirm("确定删除么?"); //在页面上弹出对话框
		if(con==true){
			var obj = "0";
			$.post(
		  		"admin/admindelblock",
		  		{"bidStr":bid},
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
	
	//恢复
	function reblock(bid) 
	{ 
	    var con;
		con=confirm("确定恢复么?"); //在页面上弹出对话框
		if(con==true){
			var obj = "0";
			$.post(
		  		"admin/adminreblock",
		  		{"bidStr":bid},
		  		function(data){
		  			obj = JSON.parse(data).toString();
		  			if(obj == "1"){
		  				alert("请确保登录状态");
		  			};
		  			if(obj != "2"){
		  				alert("出现错误");
		  			}else{
		  				alert("恢复成功");
		  				//window.location.href=window.location.href;
		  			};
				}
			);
			window.location.href=window.location.href;
		};
	};

	
</script>

</html>
