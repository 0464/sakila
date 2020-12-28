package sakila.service;

import java.util.*;
import java.sql.*;
import sakila.dao.*;
import sakila.vo.*;
import sakila.commons.*;

public class ActorListService {
	private ActorListDao actorListDao;
	// 배우 리스트
	public ArrayList<Actor> getActorList(int beginRow, int rowperPage) {
		ArrayList<Actor> list = null;
		
		actorListDao = new ActorListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = actorListDao.selectActorList(conn, beginRow, rowperPage);
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
	// 배우 검색 리스트
	public ArrayList<Actor> getActorSearchList(int beginRow, int rowperPage, String search) {
		ArrayList<Actor> list = null;
		
		actorListDao = new ActorListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = actorListDao.selectActorSearchList(conn, beginRow, rowperPage, search);
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
	// 배우 리스트 카운트
	public int countActorList() {
		
		int count = 0;
		
		actorListDao = new ActorListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			count = actorListDao.countActorList(conn);
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
	// 배우 검색 리스트 카운트
	public int countActorSearchList(String search) {
		
		int count = 0;
		
		actorListDao = new ActorListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			count = actorListDao.countActorSearchList(conn, search);
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
	// 배우 상세보기 메서드
	public ArrayList<Actor> getActorOne(Actor actor) {
		ArrayList<Actor> list = null;
		
		actorListDao = new ActorListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = actorListDao.selectActorOne(conn, actor);
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
