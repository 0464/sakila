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

@WebServlet("/auth/CustomerOneServlet")
public class CustomerOneServlet extends HttpServlet {
	private CustomerListService customerListService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/CustomerOneServlet 호출 성공");
		customerListService = new CustomerListService();
		Customer paramCustomer = new Customer();
		// customerList.jsp 페이지에서 customerId 값 받아와 paramCustomer에 넣음
		paramCustomer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("currentPage : "+currentPage);
		ArrayList<Customer> list = customerListService.getCustomerOne(paramCustomer);
		request.setAttribute("customerOne", list);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/WEB-INF/views/auth/customerOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
