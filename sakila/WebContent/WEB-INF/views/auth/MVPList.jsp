<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVPList</title>
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
		<h1>MVP</h1><hr>
		<h4>TOP 10</h4>
		<table class="table table-bordered table-hover" style="text-align:center">
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>total_sales</th>
				<th>SID</th>
			</tr>
			<c:forEach var="mvp" items="${mvpList}">
			<tr>
				<td>${mvp.customerId}</td>
				<td>${mvp.name}</td>
				<td>${mvp.totalAmount}</td>
				<td>${mvp.sid}</td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</div>
</body>
</html>