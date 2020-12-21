package sakila.service;

import java.util.*;
import java.sql.*;
import sakila.dao.*;
import sakila.vo.*;
import sakila.commons.*;

public class MVPListService {
	private CustomerListDao customerListDao;
	// 매장별 매출 메서드
	public ArrayList<Customer> getMVPList() {
		ArrayList<Customer> list = null;
		
		customerListDao = new CustomerListDao();
		Connection conn = null;
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 쿼리 실행
			list = customerListDao.selectMVPList(conn);
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
