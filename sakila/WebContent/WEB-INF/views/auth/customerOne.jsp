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
		<h1>회원 상세보기</h1><hr>
		<c:forEach var="c" items="${customerOne}">
			<div class="form-group">
				<label>customer_id</label>
				<input type="text" class="form-control" value="${c.customerId}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>name</label>
				<input type="text" class="form-control" value="${c.name}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>email</label>
				<input type="text" class="form-control" value="${c.email}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>address</label>
				<input type="text" class="form-control" value="${c.address}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>zip code</label>
				<input type="text" class="form-control" value="${c.zipCode}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>phone</label>
				<input type="text" class="form-control" value="${c.phone}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>notes</label>
				<input type="text" class="form-control" value="${c.notes}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>SID</label>
				<input type="text" class="form-control" value="${c.sid}" readonly="readonly">
			</div>
		</c:forEach>
		<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/auth/CustomerListServlet?currentPage=${currentPage}">목록</a>
		</div>
	</div>
</div>
</body>
</html>