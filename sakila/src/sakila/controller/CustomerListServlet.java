package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.CustomerListService;
import sakila.vo.Customer;

@WebServlet("/auth/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
	private CustomerListService customerListService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/CustomerListServlet 호출 성공");
		customerListService = new CustomerListService();
		
		int currentPage = 1;
		// currentPage null인지 아닌지 체크
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// 검색 내용
		String search = null;
		if (request.getParameter("search") != null) {
			search = request.getParameter("search");
		}
		
		// 페이지당 데이터를 표시할 개수
		int rowperPage = 10;
		
		// 전체 데이터 수
		int totalCount = 0;
		totalCount = customerListService.countCustomerList();
		// 검색 내용이 있을 경우
		if (search != null && search != "") {
			totalCount = customerListService.countCustomerSearchList(search);
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
		
		ArrayList<Customer> list = customerListService.getCustomerList((currentPage - 1) * rowperPage, rowperPage);
		// 검색 내용이 있을 경우
		if (search != null && search != "") {
			System.out.println("search : "+search);
			list = customerListService.getCustomerSearchList((currentPage - 1) * rowperPage, rowperPage, search);
		}
		System.out.println("list : "+list);
		// 회원 리스트
		request.setAttribute("customerList", list);
		// 필름 검색
		request.setAttribute("search", search);
		// 페이징
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		// 네비 페이징
		request.setAttribute("navPerPage", navPerPage);
		request.setAttribute("navFirstPage", navFirstPage);
		request.setAttribute("navLastPage", navLastPage);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/customerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
