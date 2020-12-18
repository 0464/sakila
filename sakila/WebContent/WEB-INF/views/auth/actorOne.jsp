<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actorOne</title>
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
		<div class="col-sm-9"><br>
		<h1>배우 상세보기</h1><hr>
		<c:forEach var="a" items="${actorOne}">
			<div class="form-group">
				<label>actor_id</label>
				<input type="text" class="form-control" value="${a.actorId}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>first_name</label>
				<input type="text" class="form-control" value="${a.firstName}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>last_name</label>
				<input type="text" class="form-control" value="${a.lastName}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>film_info</label>
				<textarea rows="10" class="form-control" readonly="readonly">${a.filmInfo}</textarea>
			</div>
		</c:forEach>
		<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/auth/ActorListServlet?currentPage=${currentPage}">목록</a>
		</div>
	</div>
</div>
</body>
</html>