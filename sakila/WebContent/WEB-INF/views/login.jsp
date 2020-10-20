<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<!-- 부트스트랩  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div>
			오늘 접속자 수 : ${returnToStats.cnt} / 전체 접속자 수 : ${returnStatsTotal}
		</div>
		<form>
			<div>
				<input type="text" placeholder="ID" class="form-control" style="width:250px;">
			</div>
			<div>
				<input type="password" placeholder="PW" class="form-control" style="width:250px;">
			</div>
			<div>
				<button type="button" class="btn btn-outline-dark">Log-in</button>
			</div>
		</form>
	</div>
</body>
</html>