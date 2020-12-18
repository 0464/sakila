<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>filmOne</title>
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
		<h1>영화 상세보기</h1><hr>
		<c:forEach var="f" items="${filmOne}">
			<div class="form-group">
				<label>film_id</label>
				<input type="text" class="form-control" value="${f.filmId}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>title</label>
				<input type="text" class="form-control" value="${f.title}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>description</label>
				<textarea cols="30" rows="5" class="form-control" readonly="readonly">${f.description}</textarea>
			</div>
			<div class="form-group">
				<label>release_year</label>
				<input type="text" class="form-control" value="${f.releaseYear}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>language</label>
				<input type="text" class="form-control" value="${f.language}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>length</label>
				<input type="text" class="form-control" value="${f.length}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>replacement_cost</label>
				<input type="text" class="form-control" value="${f.replacementCost}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>rating</label>
				<input type="text" class="form-control" value="${f.rating}" readonly="readonly">
			</div>
			<div class="form-group">
				<label>last_update</label>
				<input type="text" class="form-control" value="${f.lastUpdate}" readonly="readonly">
			</div>
		</c:forEach>
		<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/auth/FilmListServlet">목록</a>
		</div>
	</div>
</div>
</body>
</html>