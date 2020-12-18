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

@WebServlet("/auth/ActorOneServlet")
public class ActorOneServlet extends HttpServlet {
	private ActorListService actorListService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/ActorOneServlet 호출 성공");
		actorListService = new ActorListService();
		Actor paramActor = new Actor();
		// actorList.jsp 페이지에서 actorId 값 받아와 paramActor에 넣음
		paramActor.setActorId(Integer.parseInt(request.getParameter("actorId")));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println("currentPage : "+currentPage);
		ArrayList<Actor> list = actorListService.getActorOne(paramActor);
		request.setAttribute("actorOne", list);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/WEB-INF/views/auth/actorOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
