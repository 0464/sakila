package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.MVPListService;
import sakila.vo.Customer;

@WebServlet("/auth/MVPListServlet")
public class MVPListServlet extends HttpServlet {
	private MVPListService mvpListService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/MVPListServlet 호출 성공");
		mvpListService = new MVPListService();
		ArrayList<Customer> mvpList = mvpListService.getMVPList();
		request.setAttribute("mvpList", mvpList);
		request.getRequestDispatcher("/WEB-INF/views/auth/MVPList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
