package sakila.service;

import java.util.*;
import java.sql.*;
import sakila.dao.*;
import sakila.vo.*;
import sakila.commons.*;

public class RentalListService {
	private RentalListDao rentalListDao;
	// 대여 리스트
	public ArrayList<Rental> getRentalList(int beginRow, int rowperPage) {
		ArrayList<Rental> list = null;
		
		rentalListDao = new RentalListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = rentalListDao.selectRentalList(conn, beginRow, rowperPage);
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
	// 대여 검색 리스트
	public ArrayList<Rental> getRentalSearchList(String search) {
		ArrayList<Rental> list = null;
		
		rentalListDao = new RentalListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = rentalListDao.selectRentalSearchList(conn, search);
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
	// 대여 리스트 카운트
	public int countRentalList() {
		
		int count = 0;
		
		rentalListDao = new RentalListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			count = rentalListDao.countRentalList(conn);
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
	// 반납
	public void getDeleteRental(int rentalId) {
		
		rentalListDao = new RentalListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			rentalListDao.deleteRental(conn, rentalId);
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
	}
}
