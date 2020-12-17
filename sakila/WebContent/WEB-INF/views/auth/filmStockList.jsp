<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filmStockList</title>
<!-- 부트스트랩  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 부트스트랩 Icons -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
					integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
					crossorigin="anonymous">
<!-- jQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-3">
			<jsp:include page="/inc/menu.jsp"></jsp:include>
		</div>
		<div class="col-sm-9">
		<br>
		<h1>영화 재고 목록</h1><hr>
		<table class="table table-bordered table-hover" style="text-align:center">
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>영화제목</th>
				<th>언어</th>
				<th>시청등급</th>
				<th>재고</th>
			</tr>
			<c:forEach var="fs" items="${filmStockList}">
			<tr>
				<td>${fs.filmId}</td>
				<td>${fs.category}</td>
				<td>${fs.title}</td>
				<td>${fs.language}</td>
				<td>${fs.rating}</td>
				<td>${fs.filmRentalAmount}</td>
			</tr>
			</c:forEach>
		</table><hr>
		<!-- 페이지 네비게이션 -->
			<ul class="pagination justify-content-center">
				<!-- 처음으로 버튼 -->
				<c:choose>
					<c:when test="${currentPage > 1}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/auth/FilmStockListServlet?currentPage=1">처음</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
							<a class="page-link" href="#">처음</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<!-- 이전 버튼 -->
				<c:choose>
					<c:when test="${currentPage > 1}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/auth/FilmStockListServlet?currentPage=${currentPage - 1}">이전</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
							<a class="page-link" href="#">이전</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<!-- 현재 페이지 표시 -->
				<c:forEach var="i" begin="${navFirstPage}" end="${navLastPage}">
					<c:if test="${i <= lastPage}">
						<c:choose>
							<%-- 현재 페이지 --%>
							<c:when test="${i == currentPage}">
								<li class="page-item disabled">
									<a class="page-link" href="#">${i}</a>
								</li>
							</c:when>
							<%-- 현재 페이지가 아닌 선택 가능한 페이지 --%>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/auth/FilmStockListServlet?currentPage=${i}">${i}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				
				<!-- 다음 버튼 -->
				<c:choose>
					<c:when test="${currentPage < lastPage}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/auth/FilmStockListServlet?currentPage=${currentPage + 1}">다음</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
							<a class="page-link" href="#">다음</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<!-- 마지막으로 버튼 -->
				<c:choose>
					<c:when test="${currentPage < lastPage}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/auth/FilmStockListServlet?currentPage=${lastPage}">마지막</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item disabled">
							<a class="page-link" href="#">마지막</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
</body>
</html>