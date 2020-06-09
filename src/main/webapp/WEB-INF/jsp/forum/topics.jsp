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
    
    <title>${block.bname }</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
		.userimg{ 
			width:60px; 
			height:60px;

		} 
		.onetopicblock{
			border: 1px solid #DDDDDD;
			border-top: 0px; 
			/*margin-bottom: 0px;*/
		}
		.demo1{  
		    width: 100%;  
		    height: 30%;    
		    text-align: center;  
		}  
		.demo1:before{  
		    background: url(${block.bpicsrc }) no-repeat; 
		    background-size: cover;  
		    width: 100%;  
		    height: 100%;  
		    content: "";  
		    position: absolute;  
		    top: 0;  
		    left: 0;  
		    z-index: -1;/*-1 可以当背景*/  
		    -webkit-filter: blur(3px);  
		    filter: blur(3px);  
		}  
		.threed{
			color: #fafafa;
			letter-spacing: 0;
			text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135 
		}
	</style>

	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles/simditor.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles/simditor-emoji.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/scripts/module.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/scripts/hotkeys.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/scripts/uploader.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/scripts/simditor.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/scripts/simditor-emoji.js"></script>
	
	
  </head>
  
<body style="background-color: #EEF0F1;">

	<%@include file="../common/nva.jsp"%>
	<script type="text/javascript">
		$("#indexhome").addClass("active");
	</script>

  	<div class="container">
  		<div class="row clearfix" style="padding-bottom: 20px;">
  			
			<div class="col-md-12 column">
				
				<div class="demo1" style="">
					<h1 class="threed" style="position:absolute;left:0;bottom:0;">&nbsp;&nbsp;&nbsp;${block.bname }&nbsp;<small>${block.bcontext }</small></h1>
				</div>
				
			</div>
		</div>
  	
  		<div class="row clearfix">
			<div id="left" class="col-md-9 column">

				<div class="row clearfix" style="padding-left: 10px;padding-right: 10px;">
					<div class="col-md-12 column" style="background-color: #FFFFFF;" >
					
						<div class="row clearfix" style="border-top: 1px solid #DDDDDD;"></div>
						
						<c:if test="${!empty p }">
					    	<c:forEach items="${p.list }" var="topics">
					    		
					    		<div class="row clearfix onetopicblock">

									<div class="col-md-2 col-xs-2 column" >
									
										<p style="height: 8px;">&nbsp;</p>
										
										<img alt="50x50" height="60px;" width="60px;" src="<%=basePath%>${topics.upicsrc }" class="img-circle img-responsive center-block userimg" />
										
										<!-- 手机隐藏 此处username-->
										<div class="hidden-xs"><h5 class="text-center">${topics.uname }</h5></div>
										
									</div>
			
									<div class="col-md-10 col-xs-10 column" style="padding-left: 0px;">
 										
 										<!-- 填充 -->
 										<p style="height: 8px;">&nbsp;</p>
 										<!-- 手机隐藏   填充 -->
										<div class="hidden-xs"><p style="height: 0px;">&nbsp;</p></div>
										
 										<!-- 手机在此处显示  username -->
 										<div class="visible-xs">
 											<p class=""><em>${topics.uname }</em></p>
 										</div>
 										
 										<div>
 											<h3 style="margin-top: 10px;">
												<a target="_blank" href="<%=basePath%>forum/readfloors?view=0&tid=${topics.tid }">
													${topics.tname }
												</a>
											</h3>
										</div>
										
										<hr style="margin-top: 17px;margin-bottom: 17px;">
										
										<div class="row clearfix">
			
											<div class="col-md-8 column">
												
													<cite>
														创建：<fmt:formatDate value="${topics.createtime }" pattern=" yyyy-MM-dd HH:mm:ss " />
													</cite>
													&nbsp;&nbsp;|&nbsp;&nbsp;
													<cite>
														最后回复： <fmt:formatDate value="${topics.modifytime }" pattern=" yyyy-MM-dd HH:mm:ss " />
													</cite>
												
							
											</div>
			
											<div class="col-md-4 column">
												<p class="text-right">
													<span class="badge">${topics.viewnum }</span>
													<span class="badge">${topics.backnum }</span>
												</p>
											</div>
			
										</div>
										
										<p style="height: 0px;">&nbsp;</p>
			
									</div>
			
								</div>
 
					    	</c:forEach>
					    	
					    </c:if>
					    <c:if test="${empty p.list }">
					    	<div class="page-header">
							  <h1>空的啊&nbsp;&nbsp;&nbsp;<small>Nothing</small></h1>
							</div>
							<p>
						  		<input type="button" value="发帖" onclick="toEditer();" class="btn btn-default btn-lg btn-block"/>    
							</p>
							<hr>
					    </c:if>
						
					</div>
				</div>

			</div>
			
			<div id="right" class="col-md-3 column" style="background-color: #FFFFFF;">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<br>
						<div class="input-group">
				      		<input type="text" class="form-control" placeholder="Search for...">
				      		<span class="input-group-btn">
				        		<button class="btn btn-default" type="button">Go!</button>
				      		</span>
				   		</div>
					</div>
				</div>
			
				<hr>

				<div class="row clearfix">
					<div class="col-md-12 column">
						<p>
					  		<input type="button" value="发帖" onclick="toEditer();" class="btn btn-default btn-lg btn-block"/>  
						</p>
					</div>
				</div>

				<hr>

			</div>

		</div>
  	
	    <!-- 分页 -->
		<c:set var="pageUrl" value="forum/getTopics?bid=${bid }&page="></c:set>
		<!-- 最多显示MostPageNum个页码，当前页最多在页码条中居第MidActivePageNum位 -->
		<c:set var="MostPageNum" value="6"></c:set>
		<c:set var="MidActivePageNum" value="3"></c:set>
		<%@include file="../common/setPage.jsp" %>
	    
		
		<br>
		<input id="bid" readonly="readonly" type="hidden" name="bid" value="${bid }">
		<!-- 文本編輯器 -->
		<div class="row clearfix ">
			<div class="col-md-12 ">
				

				
				<div class="row clearfix">
					<div id="" class="col-md-12">
						<div class="input-group">
						  <span class="input-group-addon" id="basic-addon-tname">请输入标题</span>
						  <input type="text" class="form-control" id="tname" name="tname" aria-describedby="basic-addon-tname">
						</div>
					</div>
				</div>
				
				<br>
			
				<div class="row clearfix">
					
					<div id="div1" class="col-md-12">
						<textarea id="editor" name="editor" placeholder="Balabala" autofocus></textarea>
					</div>

					<div id="buttons" class="col-md-12" style="padding: 20px;">
						<button id="btn2" type="button" class="btn btn-primary btn-sm">提交回复</button>
						<button id="btn3" type="button" class="btn btn-primary btn-sm">清空</button>
					</div>
	
				</div>
			</div>
		</div>
	    
	</div>

</body>

<script type="text/javascript">
	
	$("#right").height($("#left").height());
	
	 function toEditer() {
		 var scroll_offset = $("#div1").offset();
		 $("body,html").animate({
		 	scrollTop:scroll_offset.top 
		 },350);
	 }

	//文本编辑器
	var editor,toolbar;
	Simditor.locale = 'zh-CN';
    toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|' , 'emoji' , 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment' ];
	var editor = new Simditor({
	  	textarea: $('#editor'),
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
	
	$("#btn2").click(function(){
	  	var bid = $("#bid").val();
	  	var tname = $("#tname").val();
	  	var myeditor = editor.sync();
	  	if(myeditor==""){
			alert("不能空");	
			return null;
		};
		if(tname==""){
			alert("不能空");	
			return null;
		};
	  	var con;
		con=confirm("确定发表么?"); //在页面上弹出对话框
		if(con==true){
			var obj = "0";
			$.post(
		  		"forum/setnewtopic",
		  		{"editor":myeditor,"bid":bid,"tname":tname},
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
	
</script>

</html>
