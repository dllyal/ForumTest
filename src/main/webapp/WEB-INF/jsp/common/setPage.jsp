<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 分页变量 -->
							<c:set var="pages" value="${p.pages}"></c:set>
							<c:set var="pageNum" value="${p.pageNum}"></c:set>
							<c:set var="hasPreviousPage" value="${p.hasPreviousPage}"></c:set>
							<c:set var="hasNextPage" value="${p.hasNextPage}"></c:set>
							<c:set var="prePage" value="${p.prePage}"></c:set>
							<c:set var="nextPage" value="${p.nextPage}"></c:set>
							<c:set var="firstPage" value="${p.firstPage}"></c:set>
							<c:set var="lastPage" value="${p.lastPage}"></c:set>
							<c:set var="url" value="${pageUrl }"></c:set>
							<!-- 最多显示mostpagenum个页码，当前页最多在页码条中居第midActivePageNum位 -->
							<c:set var="mostpagenum" value="${MostPageNum }"></c:set>
							<c:set var="midActivePageNum" value="${MidActivePageNum }"></c:set>
							<!-- 页码条 -->
							<nav aria-label="Page navigation">
								<ul class="pager">
									
									<li><a href="${pageContext.request.contextPath }/${url}${firstPage}">首页</a></li>
									
									<c:choose>
										<c:when test="${hasPreviousPage}">
								    		<li><a href="${pageContext.request.contextPath }/${url}${prePage}">&laquo;</a></li>
							    		</c:when>
							    		<c:otherwise>
											<li class=""><a style="background-color: #ddd;">&laquo;</a></li>
										</c:otherwise>
									</c:choose>
										
									<c:choose>
										<c:when test="${pages>mostpagenum && pageNum<midActivePageNum}">
											<c:forEach var="i" begin="1" end="${mostpagenum }">
												<c:if test="${pageNum==i }">
													<li class="active"><a style="background-color: #337ab7;color: #FFFFFF;">${i} </a></li>
												</c:if>
												<c:if test="${pageNum!=i }">
													<li><a href="${pageContext.request.contextPath }/${url}${i} ">${i} </a></li>
												</c:if>
											</c:forEach>
										</c:when>
										<c:when test="${pages>mostpagenum && pageNum>=midActivePageNum && pageNum+mostpagenum-midActivePageNum>pages}">
											<c:forEach var="i" begin="${pages-mostpagenum+1 }" end="${pages }">
												<c:if test="${pageNum==i }">
													<li class="active"><a style="background-color: #337ab7;color: #FFFFFF;">${i} </a></li>
												</c:if>
												<c:if test="${pageNum!=i }">
													<li><a href="${pageContext.request.contextPath }/${url}${i} ">${i} </a></li>
												</c:if>
											</c:forEach>
										</c:when>
										<c:when test="${pages>mostpagenum && pageNum>=midActivePageNum && pageNum+mostpagenum-midActivePageNum<=pages}">
											<c:forEach var="i" begin="${p.pageNum-midActivePageNum+1 }" end="${pageNum-midActivePageNum+mostpagenum }">
												<c:if test="${pageNum==i }">
													<li class="active"><a style="background-color: #337ab7;color: #FFFFFF;">${i} </a></li>
												</c:if>
												<c:if test="${pageNum!=i }">
													<li><a href="${pageContext.request.contextPath }/${url}${i} ">${i} </a></li>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach var="i" begin="1" end="${pages}">
												<c:if test="${pageNum==i }">
													<li class="active"><a style="background-color: #337ab7;color: #FFFFFF;">${i} </a></li>
												</c:if>
												<c:if test="${pageNum!=i }">
													<li><a href="${pageContext.request.contextPath }/${url}${i} ">${i} </a></li>
												</c:if>   
											</c:forEach>
										</c:otherwise>
									</c:choose>
										
									<c:choose>
										<c:when test="${hasNextPage}">
								 			<li><a href="${pageContext.request.contextPath }/${url}${nextPage}">&raquo;</a></li>
							    		</c:when>
							    		<c:otherwise>
											<li class=""><a style="background-color: #ddd;">&raquo;</a></li>
										</c:otherwise>
									</c:choose>
										
									<li><a href="${pageContext.request.contextPath }/${url}${lastPage}">尾页</a></li>
						
								</ul>
							</nav>	
							
							<!-- 页码跳转 -->
							<div class="row clearfix">
								<div class="col-md-2 col-md-offset-5 col-xs-12">
									<div class="input-group">
										<span class="input-group-addon">共${pages }页</span>
											<select class="form-control" id="selectpage">
												<c:forEach var="i" begin="1" end="${pages}">  
													<option value="${i}">${i}</option>
												</c:forEach>
											</select>
										<span class="input-group-btn">
											<a onclick="gotoPage();" class="btn btn-default">Go!</a>
										</span>
									</div>
								</div>
							</div>
							<script>
								function gotoPage() {
									var options=document.getElementById("selectpage").value;
									//alert(options);
									window.location = "${pageContext.request.contextPath }/${url}"+options;
								}
							</script>
							
							