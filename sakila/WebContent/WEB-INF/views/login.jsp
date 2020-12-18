<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<!-- 부트스트랩  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#loginBtn').click(function(){
			$('#loginForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-4"></div>
		<div class="col-4">
		<br><br><br><br><h1 style="text-align:center">Sakila</h1>
		<div>
			<table class="table table-hover" style="text-align:center">
				<tr>
					<td>오늘 접속자 수 : ${returnToStats.cnt}</td>
					<td>전체 접속자 수 : ${returnStatsTotal}</td>
				</tr>
			</table>
		</div>
		<form class="was-validated" id="loginForm" method="post" action="${pageContext.request.contextPath}/">
			<div class="form-group">
				<label>Email : </label>
				<input class="form-control" type="text" name="id" placeholder="Mike.Hillyer@sakilastaff.com" class="form-control" value="Mike.Hillyer@sakilastaff.com" required>
				<div class="valid-feedback"></div>
      			<div class="invalid-feedback">이메일을 입력해주세요.</div>
			</div>
			<div class="form-group">
				<label>Password : </label>
				<input class="form-control" type="password" name="pw" placeholder="1234" class="form-control" required>
				<div class="valid-feedback"></div>
      			<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
			</div>
			<div>
				<button style="width:100%" id="loginBtn" type="button" class="btn btn-outline-dark">Log-in</button>
			</div>
		</form>
		</div>
		<div class="col-4"></div>
	</div>
	</div>
</body>
</html>