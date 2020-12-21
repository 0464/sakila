package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.StaffService;
import sakila.vo.Staff;

@WebServlet("/auth/StaffServlet")
public class StaffServlet extends HttpServlet {
	private StaffService staffService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/StaffServlet 호출 성공");
		staffService = new StaffService();
		Staff paramStaff = new Staff();
		// menu.jsp 페이지에서 staffId 값 받아와 paramStaff에 넣음
		paramStaff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
		
		ArrayList<Staff> list = staffService.getStaffInfo(paramStaff);
		
		request.setAttribute("staffList", list);
		request.getRequestDispatcher("/WEB-INF/views/auth/staffOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
