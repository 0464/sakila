<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
		<h1>Sakila 비디오 대여점 프로젝트</h1><hr>
		
		<table class="table table-bordered table-hover">
			<tr><th>To Do List</th></tr>
			<tr><td>영화반납</td></tr>
			<tr><td>카테고리별 영화 전체검색</td></tr>
			<tr><td>카테고리별 영화 재고검색</td></tr>
			<tr><td>연체여부별 회원 검색</td></tr>
			<tr><td>영화 출연배우 등록</td></tr>
			<tr><td>관리자 마이페이지 상세보기 기능</td></tr>
			<tr><td>매장통계</td></tr>
			<tr><td>MVP</td></tr>
		</table>
		</div>
	</div>
</div>
</body>
</html>