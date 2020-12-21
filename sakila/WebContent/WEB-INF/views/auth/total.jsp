<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>total</title>
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
		<h1>통계</h1><hr>
		<h4>매장별 통계</h4>
		<table class="table table-bordered table-hover" style="text-align:center">
			<tr>
				<th>store</th>
				<th>manager</th>
				<th>total_sales</th>
			</tr>
			<c:forEach var="st" items="${storeTotalList}">
			<tr>
				<td>${st.store}</td>
				<td>${st.manager}</td>
				<td>${st.totalSales}</td>
			</tr>
			</c:forEach>
		</table><hr>
		<h4>카테고리별 통계</h4>
		<table class="table table-bordered table-hover" style="text-align:center">
			<tr>
				<th style="width:150px">category</th>
				<th>total_sales</th>
			</tr>
			<c:forEach var="ct" items="${categoryTotalList}">
			<tr>
				<td>${ct.category}</td>
				<td>${ct.totalSales}</td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</div>
</body>
</html>