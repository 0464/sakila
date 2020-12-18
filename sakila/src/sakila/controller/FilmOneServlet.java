package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.service.FilmListService;
import sakila.vo.Film;

@WebServlet("/auth/FilmOneServlet")
public class FilmOneServlet extends HttpServlet {
	private FilmListService filmListService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/auth/FilmOneServlet 호출 성공");
		filmListService = new FilmListService();
		Film paramFilm = new Film();
		// filmList.jsp 페이지에서 filmId 값 받아와 paramFilm에 넣음
		paramFilm.setFilmId(Integer.parseInt(request.getParameter("filmId")));
		
		ArrayList<Film> list = filmListService.getFilmOne(paramFilm);
		request.setAttribute("filmOne", list);
		request.getRequestDispatcher("/WEB-INF/views/auth/filmOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
