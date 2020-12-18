package sakila.service;

import java.util.*;
import java.sql.*;

import sakila.dao.*;
import sakila.vo.*;
import sakila.commons.*;

public class FilmListService {
	private FilmListDao filmListDao;
	
	public ArrayList<Film> getFilmList(int beginRow, int rowPerPage) {
		ArrayList<Film> returnList = null;
		
		filmListDao = new FilmListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			returnList = filmListDao.selectFilmList(conn, beginRow, rowPerPage);
			
			// 쿼리성공 시  commit
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return returnList;
	}
	
	public int countFilmList() {
		
		int count = 0;
		
		filmListDao = new FilmListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			count = filmListDao.countFilmList(conn);
			
			// 쿼리 성공 시  commit
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
	// 영화 상세보기
	public ArrayList<Film> getFilmOne(Film film) {
		ArrayList<Film> list = null;
		
		filmListDao = new FilmListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = filmListDao.selectFilmOne(conn, film);
			
			// 쿼리성공 시  commit
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}