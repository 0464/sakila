package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.RentalListService;
import sakila.vo.Rental;


@WebServlet("/auth/DeleteRentalServlet")
public class DeleteRentalServlet extends HttpServlet {
	private RentalListService rentalListService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/DeleteRentalServlet 호출 성공");
		rentalListService = new RentalListService();
		
		// 대여id 불러오기
		int rentalId = Integer.parseInt(request.getParameter("rentalId"));
		
		System.out.println("rentalId : "+rentalId);
		
		rentalListService.getDeleteRental(rentalId);
		
		request.getRequestDispatcher("/WEB-INF/views/auth/rentalList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
