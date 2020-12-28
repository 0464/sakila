package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.ActorListService;
import sakila.vo.Actor;

@WebServlet("/auth/ActorListServlet")
public class ActorListServlet extends HttpServlet {
	private ActorListService actorListService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/ActorListServlet 호출 성공");
		actorListService = new ActorListService();
		
		int currentPage = 1;
		// currentPage null인지 아닌지 체크
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("currentPage : "+currentPage);
		
		// 검색
		String search = "";
		if (request.getParameter("search") != null) {
			search = request.getParameter("search");
		}
		// 페이지당 데이터를 표시할 개수
		int rowperPage = 10;
		
		// 전체 데이터 수
		int totalCount = 0;
		totalCount = actorListService.countActorList();
		// 검색 내용이 있을 경우
		if (search != "") {
			totalCount = actorListService.countActorSearchList(search);
		}
		
		System.out.println("totalCount : "+totalCount);
		// 마지막 페이지
		int lastPage = totalCount / rowperPage;
		// 10 미만의 개수의 데이터가 있는 페이지를 표시
		if (totalCount % rowperPage != 0) {
			lastPage += 1;
		}
		// 전체 페이지가 0개이면 현재 페이지도 0으로
		if (lastPage == 0) {
			currentPage = 0;
		}
		// 네비게이션에 표시할 페이지 수
		int navPerPage = 10;
		int navFirstPage = currentPage - (currentPage % navPerPage) + 1;
		int navLastPage = navFirstPage + navPerPage - 1;
		// 10으로 나누어 떨어질 경우
		if (currentPage % navPerPage == 0 && currentPage != 0) {
			navFirstPage = navFirstPage - navPerPage;
			navLastPage = navLastPage - navPerPage;
		}
		
		ArrayList<Actor> list = actorListService.getActorList((currentPage - 1) * rowperPage, rowperPage);
		// 검색 내용이 있을 경우
		if (search != "") {
			System.out.println("search : "+search);
			list = actorListService.getActorSearchList((currentPage - 1) * rowperPage, rowperPage, search);
		}
		System.out.println("list : "+list);
		// 필름 검색
		request.setAttribute("search", search);
		// 회원 리스트
		request.setAttribute("actorList", list);
		// 페이징
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		// 네비 페이징
		request.setAttribute("navPerPage", navPerPage);
		request.setAttribute("navFirstPage", navFirstPage);
		request.setAttribute("navLastPage", navLastPage);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/actorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
