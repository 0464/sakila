package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.vo.*;

public class FilmListDao {
	// 영화 목록 출력 메서드
	public ArrayList<Film> selectFilmList(Connection conn, int beginRow, int rowPerPage) throws Exception {
		
		ArrayList<Film> list = new ArrayList<Film>();
		
		PreparedStatement stmt = conn.prepareStatement(FilmListQuery.SELECT_FILM_LIST);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Film film = new Film();
			film.setFilmId(rs.getInt("FID"));
			film.setCategory(rs.getString("category"));
			film.setTitle(rs.getString("title"));
			film.setLanguage(rs.getString("name"));
			film.setRating(rs.getString("rating"));
			film.setRentalRate(rs.getFloat("price"));
			list.add(film);
		}
		System.out.println("list : "+list);
		return list;
	}
	
	// 영화 목록 카운트 메서드
	public int countFilmList(Connection conn) throws Exception {
		
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(FilmListQuery.SELECT_COUNT_FILM_LIST);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
	// 영화 재고 목록 출력 메서드
	public ArrayList<Film> selectFilmStockList(Connection conn, int beginRow, int rowPerPage) throws Exception {
		
		ArrayList<Film> list = new ArrayList<Film>();
		
		PreparedStatement stmt = conn.prepareStatement(FilmStockListQuery.SELECT_FILM_STOCK_LIST);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, rowPerPage);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Film film = new Film();
			film.setFilmId(rs.getInt("film_id"));
			film.setCategory(rs.getString("category"));
			film.setTitle(rs.getString("title"));
			film.setLanguage(rs.getString("language"));
			film.setRating(rs.getString("rating"));
			film.setFilmRentalAmount(rs.getInt("cnt"));
			list.add(film);
		}
		System.out.println("list : "+list);
		return list;
	}
	
	// 영화 재고 목록 카운트 메서드
	public int countFilmStockList(Connection conn) throws Exception {
		
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(FilmStockListQuery.SELECT_COUNT_FILM_STOCK_LIST);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
}
