<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="tabel" style="width:100%">
	<tr><td><br><br></td></tr>
	<tr><td style="text-align:center"><h1>Sakila</h1></td></tr>
	<tr><td style="text-align:center"><i class="fas fa-user-circle fa-3x"></i></td></tr>
	<tr><td style="text-align:center">
		<h6>${loginStaff.username} 관리자님</h6>
		<button type="button" class="btn btn-sm btn-outline-dark" onclick="location.href='${pageContext.request.contextPath}/auth/LogoutServlet'">Log-out</button><hr>
	</td></tr>
	<tr><td style="text-align:center"><h4>Menu</h4></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/IndexServlet">홈</a></td></tr>
	<tr><td><hr></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="">영화반납</a></td></tr>
	<tr><td><hr></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/CustomerListServlet">회원목록 관리</a></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/FilmListServlet">영화목록 관리</a></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/FilmStockListServlet">영화재고 관리</a></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/ActorListServlet">영화배우 관리</a></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="">영화 출연배우 등록</a></td></tr>
	<tr><td><hr></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/ChartListServlet">매장통계</a></td></tr>
	<tr><td><a style="color:black" class="nav-link" href="${pageContext.request.contextPath}/auth/MVPListServlet">MVP</a><hr></td></tr>
</table>