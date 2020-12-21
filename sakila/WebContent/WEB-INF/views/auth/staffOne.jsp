<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>staffOne</title>
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
		<c:forEach var="s" items="${staffList}">
		<div class="col-sm-9"><br>
		<h1>관리자 마이페이지</h1><hr>
		<div class="row">
			<div class="col-sm-4">
			<div class="form-group">
				<div class="card" style="width:100%; height:300px">
				<img class="card-img-top" src="images.jpg" style="width:100%; height:200px"/>
					<div class="card-body">
					<h4 class="card-title">${s.lastName}</h4>
					<h5 class="card-title">${s.firstName}</h5>
					</div>
				</div>
			</div>
			</div>
			<div class="col-sm-8">
				<div class="form-group">
					<label>staff_id</label>
					<input type="text" class="form-control" value="${s.staffId}" readonly="readonly">
				</div>
				<div class="form-group">
					<label>store_id</label>
					<input type="text" class="form-control" value="${s.storeId}" readonly="readonly">
				</div>
			</div>
		</div>
		<div class="form-group">
			<label>address</label>
			<input type="text" class="form-control" value="${s.address}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>email</label>
			<input type="text" class="form-control" value="${s.email}" readonly="readonly">
		</div>
		</div>
		</c:forEach>
	</div>
</div>
</body>
</html>