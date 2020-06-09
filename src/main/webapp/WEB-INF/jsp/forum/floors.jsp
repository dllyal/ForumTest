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

<title>${topic.tname }</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style>
html {
	overflow-y: scroll;
}

form {
	margin: 0;
}

textarea {
	display: block;
}
.onefloorblock{
	background-color: #F9FAFB; 
	min-height: 300px;
	border: 1px solid #DDDDDD;
	border-top: 0px; 
	margin-bottom: 0px;
}
</style>

<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">

<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.js"></script>

<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles/simditor.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles/simditor-emoji.css" />
<script type="text/javascript" src="<%=basePath%>js/scripts/module.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/scripts/hotkeys.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/scripts/uploader.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/scripts/simditor.js"></script>
<script type="text/javascript" src="<%=basePath%>js/scripts/simditor-emoji.js"></script>

</head>

<body style="background-color: #EEF0F1;">

	<%@include file="../common/nva.jsp"%>
	<script type="text/javascript">
		$("#indexhome").addClass("active");
	</script>

	<div class="container">
		<c:if test="${!empty topic }">
		
			<h1>${topic.tname }</h1>
			<input id="tid" readonly="readonly" type="hidden" name="tid" value="${topic.tid }">
			
			<c:if test="${p.pageNum == 1 || p.pages == 0 }">
			
				<div class="row clearfix" style="border-top: 1px solid #DDDDDD;"></div>
				<div class="row clearfix onefloorblock">
					<div class="col-md-2 col-xs-12 column hidden-xs"><!-- 手机隐藏 -->
						<br>
						<div class="col-md-12 col-xs-3 column">
							<a>
						    	<img src="<%=basePath%>${topic.upicsrc }" class="img-circle img-responsive center-block" />
							</a>
							<hr>
						</div>
					    <div class="col-md-12 col-xs-7 column">
					    	<h3 class="text-center" style="margin-top: 0px;">${topic.uname }</h3>
					    	<p class="text-center">${topic.sign }</p>
					    </div>
					</div>
					<div class="visible-xs"><!-- 手机显示 -->
 						<div class="col-md-12 col-xs-3 column" style="height: 60px;">
							<a>
						    	<img style="height: 50px;margin-top: 5px;" alt="150x150" src="<%=basePath%>${topic.upicsrc }" class="img-circle img-responsive center-block" />
							</a>
						</div>
					    <div class="col-md-12 col-xs-8 column">
					    	<h3 class="" style="margin-top: 15px;">${topic.uname }</h3>
					    </div>
 					</div>
					<div class="col-md-10 col-xs-12 column" style="background-color: #FFFFFF; padding-top: 10px;">
						<div class="">
							<blockquote>
								<small>0# ---- &nbsp;<cite><fmt:formatDate
											value="${topic.createtime }" pattern=" yyyy-MM-dd HH:mm:ss " /></cite></small>
							</blockquote>
						</div>
						<div style="min-height: 250px;padding-left: 10px;padding-right: 10px;padding-top: 5px;">
							<p>${topic.tcontext }</p>
						</div>
					</div>
				</div>
			
			</c:if>
			
			
			<c:forEach items="${p.list }" var="note">
				<div class="row clearfix onefloorblock">
					
					<div class="col-md-2 col-xs-12 column hidden-xs"><!-- 手机隐藏 -->
						<br>
						<div class="col-md-12 col-xs-3 column">
							<a>
						    	<img src="<%=basePath%>${note.upicsrc }" class="img-circle img-responsive center-block" />
							</a>
							<hr>
						</div>
					    <div class="col-md-12 col-xs-7 column">
					    	<h3 class="text-center" style="margin-top: 0px;">${note.uname }</h3>
					    	<p class="text-center">${note.sign }</p>
					    </div>
					</div>
					
					<div class="visible-xs"><!-- 手机显示 -->
 						<div class="col-md-12 col-xs-3 column" style="height: 60px;">
							<a>
						    	<img style="height: 50px;margin-top: 5px;" alt="150x150" src="<%=basePath%>${note.upicsrc }" class="img-circle img-responsive center-block" />
							</a>
							
						</div>
					    <div class="col-md-12 col-xs-8 column">
					    	<h3 class="" style="margin-top: 15px;">${note.uname }</h3>
					    </div>
 					</div>
					
					<div class="col-md-10 col-xs-12 column" style="background-color: #FFFFFF; padding-top: 10px;">
						<!-- 楼层及时间等 -->
						<div id="${note.floor }#" class="">
							<blockquote>
								<small>${note.floor }# ---- &nbsp;<cite><fmt:formatDate
											value="${note.createtime }" pattern=" yyyy-MM-dd HH:mm:ss " /></cite></small>
							</blockquote>
						</div>
						<!-- 主体 -->
						<div style="min-height: 300px;padding-left: 10px;padding-right: 10px;">
							<p>${note.ncontext }</p>
						</div>
						<!-- 按钮评论条 -->
						<div style="padding-left: 10px;padding-right: 10px;">
							<p class="text-right">
								<button type="button" class="btn btn-primary btn-sm" onclick="getback(${note.nid },${note.tid },${note.floor })"
									>
									<span class="glyphicon glyphicon-triangle-bottom"
										aria-hidden="true"></span>
								</button>
							</p>
							<!-- 评论 -->
							<div id="note${note.nid }" class="row" style="overflow:hidden;display:none;">
								<div class="col-md-12 col-xs-12 column" >
									<hr>
									<div class="row clearfix">
										<div class="col-md-11 col-md-offset-1 column">
											<div class="list-group">
												<a id="${note.floor }" style="background-color: #F7F7F9;" class="list-group-item">没有回复</a>
											</div>
										</div>
									</div>
									
									<span class="input-group-btn text-right">
										<button class="btn btn-default" type="button" onclick="backtoback(${note.tid},${note.nid },${note.uid },${note.floor },'${note.uname}')">来说一句</button>
									</span>
									
									<hr>
								</div>
							</div>
						</div>
					</div>
				</div>
			
			</c:forEach>
			
			<!-- 分页 -->
			<c:set var="pageUrl" value="forum/readfloors?tid=${topic.tid }&page="></c:set>
			<!-- 最多显示MostPageNum个页码，当前页最多在页码条中居第MidActivePageNum位 -->
			<c:set var="MostPageNum" value="6"></c:set>
			<c:set var="MidActivePageNum" value="3"></c:set>
			<%@include file="../common/setPage.jsp" %>
			
			<br/>

		</c:if>
		
		
		<!-- 文本編輯器 -->
		<div class="row clearfix thumbnail">
			<div class="col-md-12 column">
				<div class="row clearfix">
	
					<div id="div1">
						<textarea id="editor" name="editor" placeholder="Balabala" autofocus></textarea>
					</div>

					<div id="buttons" style="padding: 10px;">
						<button id="btn2" type="button" class="btn btn-primary btn-sm">提交回复</button>
						<button id="btn3" type="button" class="btn btn-primary btn-sm" >清空</button>
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

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						回复
					</h4>
				</div>
				<div class="modal-body">
					<input id="Modaltid" readonly="readonly" type="hidden" name="tid" value="0">
					<input id="Modalfathernid" readonly="readonly" type="hidden" name="fathernid" value="0">
					<input id="Modalfatheruid" readonly="readonly" type="hidden" name="fatheruid" value="0">
					<input id="Modalfloor" readonly="readonly" type="hidden" name="floor" value="0">
					请输入回复内容
					<div class="input-group">
						<span class="input-group-addon" id="Modalfatheruname">@</span>
						<input type="text" id="Modaltext" class="form-control" placeholder="请输入回复内容">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" onclick="setbacktoback()">
						提交
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
</body>

<script>

	// 文本编辑器
	var editor,toolbar;
	Simditor.locale = 'zh-CN';
    toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|' , 'emoji' , 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment' ];
	var editor = new Simditor({
	  	textarea: $('#editor'),
	  	//optional options
	  	placeholder: '这里输入文字...',
	    toolbar: toolbar,
	    emoji: {
			imagePath: 'images/emoji/'
		},
	    pasteImage: true,
	    defaultImage: '/simditor/images/image.png',
	  	upload: {
	       url: 'up/up.do',
	       params: null,
	       fileKey: "fileName",
	       connectionCount: 1,
	       leaveConfirm: "正在上传,确定要取消上传文件吗?"
	    }
	});
	
	function formeditor(){
		//editor.sync();
		if(editor.sync()==""){
			alert("不能空");
			return false;
		}
		return true;
	};
	
	/*
	$("#btn1").click(function(){
	  	alert(editor.getValue());
	});
	*/
	$("#btn2").click(function(){
	  	var tid = $("#tid").val();
	  	var myeditor = editor.sync();
	  	if(myeditor==""){
			alert("不能空");	
			return null;
		};
	  	var con;
		con=confirm("确定发表么?"); //在页面上弹出对话框
		if(con==true){
			var obj = "0";
			$.post(
		  		"forum/setnewfloor",
		  		{"editor":myeditor,"tid":tid},
		  		function(data){
		  			obj = JSON.parse(data).toString();
		  			if(obj == "1"){
		  				alert("请确保登录状态");
		  			}else{
		  				if(obj == "2"){
			  				alert("出现错误");
			  			}else{
			  				alert("成功");
			  				window.location.href=window.location.href;
			  			};
		  			};
				}
			);
			//window.location.href=window.location.href;
		};
	});
	
	$("#btn3").click(function(){
	  	editor.setValue("");
	});
	
	
	// 读取回复
	
	function getback(nid,tid,floor){
		if($("#"+floor).next().length==0){
		
			getbackAJAX(nid,tid,floor);
		}else{
			$("#note"+nid).slideToggle(350);
			//$("#"+floor).nextAll().remove();
		};
	};
	
	function getbackAJAX(nid,tid,floor){
		
		$.post(
	  		"forum/getbacks",
	  		{"tidStr":tid,"floorStr":floor},
	  		function(data){
	  			var obj = JSON.parse(data);

				for(var i=0;i<obj.length;i++){

					var newElement = document.createElement("div");
					newElement.setAttribute('class', "list-group-item");
					var year = 1900 + parseInt(obj[i].createtime.year);
					var month = 1 + parseInt(obj[i].createtime.month);
					var day = parseInt(obj[i].createtime.date);
					var hours = parseInt(obj[i].createtime.hours);
					var minutes = parseInt(obj[i].createtime.minutes);
					var seconds = parseInt(obj[i].createtime.seconds);
					if(month<10){
						month = "0"+month;
					};
					if(day<10){
						day = "0"+day;
					};
					if(hours<10){
						hours = "0"+hours;
					};
					if(minutes<10){
						minutes = "0"+minutes;
					};
					if(seconds<10){
						seconds = "0"+seconds;
					};
					
					var date = ""+year+"-"+month+"-"+day;
					var time = ""+hours+":"+minutes+":"+seconds;
					//var datetime = new Date(parseInt(obj[i].createtime.time)/1000);
					//alert(mydate);
					//alert(datetime);
					
					var sss=''+
							'<div class="row clearfix">'+
								'<div class="col-md-12 column">'+
									'<strong><a>'+obj[i].uname+'</a>&nbsp;:&nbsp;<a>@&nbsp;'+obj[i].fatheruname+'</a>&nbsp;</strong>:&nbsp;'+obj[i].ncontext+
								'</div>'+
								'<div class="col-md-12 column">'+
								
									'<p class="text-right" style="margin-bottom: 0px;">'+
										'<small><cite>'+date+'&nbsp;&nbsp;'+time+'</cite></small>&nbsp;&nbsp;'+
										'<button type="button" class="btn btn-default btn-xs" onclick="backtoback('+obj[i].tid+','+obj[i].nid+','+obj[i].uid+','+obj[i].floor+',\''+obj[i].uname+'\')">'+
											'<span class="glyphicon glyphicon-pencil"></span>'+
										'</button>'+
									'</p>'+
								'</div>'+
							'</div>';
					
					newElement.innerHTML = sss;
					var targetElement = document.getElementById(floor);
					targetElement.innerHTML = "回复";
					var parent = targetElement.parentNode;
					parent.appendChild(newElement);
					//tid,fathernid,fatheruid,floor
				};
				
				$("#note"+nid).slideToggle(400);

			}
		);

	};
	
	function backtoback(tid,fathernid,fatheruid,floor,fatheruname){
		$('#Modaltid').val(tid);
		$('#Modalfathernid').val(fathernid);
		$('#Modalfatheruid').val(fatheruid);
		$('#Modalfloor').val(floor);
		$('#Modalfatheruname').html("@"+fatheruname);
		$('#Modaltext').val("");
		$('#myModal').modal('show');
	};
	
	function setbacktoback(){
		var Modaltid = $('#Modaltid').val();
		var Modalfathernid = $('#Modalfathernid').val();
		var Modalfatheruid = $('#Modalfatheruid').val();
		var Modalfloor = $('#Modalfloor').val();
		var Modaltext = $('#Modaltext').val();
		if(Modaltid==""||Modaltid=="0"||Modalfathernid==""||Modalfathernid=="0"||Modalfatheruid==""||Modalfatheruid=="0"||Modalfloor==""||Modalfloor=="0"){
			alert("出现故障");
			return null;
		};
		if($.trim(Modaltext)==""){
			alert("不能为空");
			return null;
		};
		/*
		alert($('#Modaltid').val());
		alert($('#Modalfathernid').val());
		alert($('#Modalfatheruid').val());
		alert($('#Modalfloor').val());
		alert($('#Modaltext').val());
		*/
		var con;
		con=confirm("确定回复么?"); //在页面上弹出对话框
		if(con==true){
			var obj = "0";
			$.post(
		  		"forum/setback",
		  		{
		  			"editor":Modaltext,
		  			"tid":Modaltid,
		  			"fathernid":Modalfathernid,
		  			"fatheruid":Modalfatheruid,
		  			"floor":Modalfloor
		  		},
		  		function(data){
		  			obj = JSON.parse(data).toString();
		  			if(obj == "1"){
		  				alert("请确保登录状态");
		  			}else{
		  				if(obj == "2"){
			  				alert("出现错误");
			  			}else{
			  				alert("成功");
			  				window.location.href=window.location.href;
			  			};
		  			};
				}
			);
			//window.location.href=window.location.href;
		};
		
	};
	
	
</script>

</html>
