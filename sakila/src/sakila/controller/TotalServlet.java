package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.TotalService;
import sakila.vo.Total;

@WebServlet("/auth/TotalServlet")
public class TotalServlet extends HttpServlet {
	private TotalService totalService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/TotalServlet 호출 성공");
		totalService = new TotalService();
		ArrayList<Total> storeTotalList = totalService.getStoreTotal();
		ArrayList<Total> categoryTotalList = totalService.getCategoryTotal();
		request.setAttribute("storeTotalList", storeTotalList);
		request.setAttribute("categoryTotalList", categoryTotalList);
		request.getRequestDispatcher("/WEB-INF/views/auth/total.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
