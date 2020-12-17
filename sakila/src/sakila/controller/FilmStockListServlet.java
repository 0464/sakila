package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.FilmStockListService;
import sakila.vo.Film;

@WebServlet("/auth/FilmStockListServlet")
public class FilmStockListServlet extends HttpServlet {
	private FilmStockListService filmStockListService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/FilmStockListServlet 호출 성공");
		
		filmStockListService = new FilmStockListService();
		
		// 현재 페이지
		int currentPage = 1;
		
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이지당 데이터를 표시할 개수
		int rowPerPage = 10;
		
		// 전체 데이터 수
		int totalCount = 0;
		totalCount = filmStockListService.countFilmStockList();	// 전체 데이터 개수
		
		// 마지막 페이지
		int lastPage = totalCount / rowPerPage;
		if (totalCount % rowPerPage != 0) {
			lastPage += 1;
		}
		
		if (lastPage == 0) {
			currentPage = 0;
		}
		
		int navPerPage = 10;
		int navFirstPage = currentPage - (currentPage % navPerPage) + 1;
		int navLastPage = navFirstPage + navPerPage - 1;
		
		if (currentPage % navPerPage == 0 && currentPage != 0) {
			navFirstPage = navFirstPage - navPerPage;
			navLastPage = navLastPage - navPerPage;
		}
		
		ArrayList<Film> list = filmStockListService.getFilmStockList((currentPage - 1) * rowPerPage, rowPerPage);
		// 영화 재고 목록 리스트
		request.setAttribute("filmStockList", list);
		// 페이징
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		// 네비 페이징
		request.setAttribute("navPerPage", navPerPage);
		request.setAttribute("navFirstPage", navFirstPage);
		request.setAttribute("navLastPage", navLastPage);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/filmStockList.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
