package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;

@WebServlet({"/","/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); // auth < 로그인이 되어있을때만 서블릿에 접근
			return;
		}
		statsService = new StatsService();
		// map 형식 받고 request
		Map<String, Object> map = statsService.getStats();
		request.setAttribute("returnToStats", map.get("returnToStats"));
		request.setAttribute("returnStatsTotal", map.get("returnStatsTotal"));

		// 포워딩
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		staffService = new StaffService();
		Staff paramStaff = new Staff();
		// login.jsp 페이지에서 id와 pw 값 받아와 paramStaff에 넣음
		paramStaff.setEmail(request.getParameter("id"));
		paramStaff.setPassword(request.getParameter("pw"));
		// getStaffByKey 메서드를 호출해 loginStaff에 넣음
		Staff loginStaff = staffService.getStaffByKey(paramStaff);
		System.out.println("loginStaff > "+loginStaff);
		if(loginStaff != null) {
			// request 변수
			String staffEmail = loginStaff.getEmail();
			String userName = loginStaff.getUsername();
			// request
			request.setAttribute("staffEmail", staffEmail);
			request.setAttribute("userName", userName);
			
			// 포워딩
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", loginStaff);
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		response.sendRedirect(request.getContextPath()+"/LoginServlet");
	}

}
