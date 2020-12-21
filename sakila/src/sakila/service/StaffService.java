package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import sakila.commons.DBUtil;
import sakila.dao.FilmListDao;
import sakila.dao.StaffDao;
import sakila.dao.StatsDao;
import sakila.vo.Film;
import sakila.vo.Staff;

public class StaffService {
	private StaffDao staffDao;
	private StatsDao statsDao;
	// id와 pw값을 받아와 selectStaffByKey 메서드로 확인하고 그 값을 returnStaff에 받아 반환하는 메서드
	public Staff getStaffByKey(Staff paramStaff) {
		statsDao = new StatsDao();
		staffDao = new StaffDao();
		Connection conn = null;
		Staff returnStaff = null;
		try {
			// DB 연결
			conn = statsDao.getConnection();
			// 오토커밋 false
			conn.setAutoCommit(false);
			
			paramStaff.setEmail(paramStaff.getEmail());
			paramStaff.setPassword(paramStaff.getPassword());
			// // id와 pw를 받아와 데이터에 대입하여 정보가 있는지 확인하는 메서드 없다면 null값 반환
			returnStaff = staffDao.selectStaffByKey(conn, paramStaff);
			System.out.println("returnStaff > "+returnStaff);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return returnStaff;
	}
	// 관리자 마이페이지
	public ArrayList<Staff> getStaffInfo(Staff staff) {
		ArrayList<Staff> list = null;
		
		staffDao = new StaffDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = staffDao.selectStaffInfo(conn, staff);
			
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
