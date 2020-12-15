<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="container">
	<h1>index.jsp</h1>
	<nav class="navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link">${loginStaff.email} 관리자님</a>
		</li>
		<li>
			<a class="nav-link" href="${pageContext.request.contextPath}/auth/LogoutServlet">Log-out</a>
		</li>
	</ul>
	</nav>
	<div class="row">
	<div class="col-sm-2">
	<ul class="nav flex-column">
		<li class="nav-item"><h4>Menu</h4></li>
		<li><a href="${pageContext.request.contextPath}/auth/IndexServlet">홈</a></li>
		<li><hr></li>
		<li>영화반납</li>
		<li><hr></li>
		<li>회원목록 관리</li>
		<li>영화목록 관리</li>
		<li>영화재고 관리</li>
		<li>영화배우 관리</li>
		<li>영화 출연배우 등록</li>
		<li><hr></li>
		<li>매장통계</li>
		<li>MVP</li>
	</ul>
	</div>
	<div class="col-sm-10">
	내용
	</div>
	</div>
</body>
</html>