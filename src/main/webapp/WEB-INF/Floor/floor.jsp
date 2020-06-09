<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'floor.jsp' starting page</title>

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 
文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<script type="text/javascript" src="<%=basePath %>js/jquery.qqFace.js"></script>
<script type="text/javascript">

	$(function(){
		$('.emotion').qqFace({
			id : 'facebox', 
			assign:'saytext', 
			path:'arclist/'	//表情存放的路径
		});
		$(".sub_btn").click(function(){
			var str = $("#saytext").val();
			$("#show").html(replace_em(str));
		});
	});

	//查看结果
	function replace_em(str){
		str = str.replace(/\</g,'&lt;');
		str = str.replace(/\>/g,'&gt;');
		str = str.replace(/\n/g,'<br/>');
		str = str.replace(/\[em_([0-9]*)\]/g,'<img src="arclist/$1.gif" border="0" />');
		return str;
	}

</script>

</head>

<body>
	<div class="container">
		<c:if test="${!empty topic }">
			<h1>${topic.tname }</h1>
			<c:forEach items="${notes }" var="note">
				<hr>
				<div class="row clearfix" >
					<div class="col-md-1 col-xs-2 column">
						<img alt="140x140"
							src="http://ibootstrap-file.b0.upaiyun.com/lorempixel.com/140/140/default.jpg"
							class="img-thumbnail" />
					</div>
					<div class="col-md-11 col-xs-10 column">
						<blockquote>
							<p>name ${note.uid }</p>
							<small>${note.floor }樓 ---- &nbsp;于<cite><fmt:formatDate value="${note.createtime }" pattern=" yyyy-MM-dd HH:mm:ss "/></cite></small>
						</blockquote>
						<p>${note.ncontext }</p>
						<p class="text-right">
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="collapse" data-target="#editback${note.nid }">
								<span class="glyphicon glyphicon-pencil"
									aria-hidden="true"></span>
							</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-primary btn-sm"
								data-toggle="collapse" data-target="#note${note.nid }">
								<span class="glyphicon glyphicon-triangle-bottom"
									aria-hidden="true"></span>
							</button>
						</p>
						<div id="editback${note.nid }" class="row collapse on">
							<div class="input-group col-md-6 col-md-offset-5 ">
								<span class="input-group-addon emotion" id="basic-addon1">😊</span>
						      	<input type="text" class="form-control" placeholder="請輸入回復内容">
						      	<span class="input-group-btn">
						        	<button class="btn btn-default" type="button">回復</button>
						      	</span>
						    </div>
						</div>
						<div id="note${note.nid }" class="col-md-12 col-xs-12 column collapse on">
							<p id="${note.nid }" class="text-center small">沒有回復啊</p>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:if test="${!empty backs }">
				<c:forEach items="${backs }" var="back">
					<script>
						var newElement = document.createElement("div");
						newElement.setAttribute('class', "row clearfix");
						var ss = ''
							+'<div class="panel panel-default">'
								+'<div class="panel-heading">'
									+'<p>'
										+'<strong>name ${back.uid }</strong>&nbsp;&nbsp;&nbsp;&nbsp;<small>回復于&nbsp;-- &nbsp;<cite><fmt:formatDate value="${back.createtime }" pattern=" yyyy-MM-dd HH:mm "/></cite></small>'
									+'</p>'
								+'</div>'
								+'<div class="panel-body">'
									+'<p>${back.ncontext }</p>'
									+'<p class="text-right">'
										+'<button type="button" class="btn btn-primary btn-sm" data-toggle="collapse" data-target="#editback${back.nid }">'
											+'<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>'
										+'</button>'
										+'&nbsp;&nbsp;&nbsp;&nbsp;'
										+'<button type="button" class="btn btn-primary btn-sm" data-toggle="collapse" data-target="#note${back.nid }">'
											+'<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>'
										+'</button>'
									+'</p>'
									+'<div id="editback${back.nid }" class="row collapse on">'
										+'<div class="input-group col-md-6 col-md-offset-5 ">'
									      	+'<input type="text" class="form-control" placeholder="請輸入回復内容">'
									      	+'<span class="input-group-btn">'
									        	+'<button class="btn btn-default" type="button">回復</button>'
									      	+'</span>'
									    +'</div>'
									+'</div>'
									+'<div id="note${back.nid }" class="col-md-11 col-xs-11 pull-right column collapse on">' 
										+'<p id="${back.nid }" class="text-center small">沒有回復啊</p>' 
									+'</div>' 
								+'</div>'
							+'</div>';
						newElement.innerHTML = ss;
						var targetElement = document.getElementById("${back.fathernid }");
						targetElement.innerHTML = "&nbsp;&nbsp;";
						var parent = targetElement.parentNode;
						parent.appendChild(newElement);
					</script>
				</c:forEach>
			</c:if>
			<hr>
		</c:if>

	</div>
</body>

</html>
