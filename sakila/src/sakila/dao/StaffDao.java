package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	private StatsDao statsDao;
	// id와 pw를 받아와 데이터에 대입하여 정보가 있는지 확인하는 메서드
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception {
		statsDao = new StatsDao();
		Staff returnStaff = null;
		conn = statsDao.getConnection();
		
		// StaffQuery 클래스의 SELECT_STAFF_BY_KEY 메서드 호출
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, staff.getPassword());
		System.out.println("stmt > "+stmt);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setUsername(rs.getString("username"));
			
			System.out.println(rs.getInt("staff_id"));
			System.out.println(rs.getString("username"));
		}
		
		conn.close();
		return returnStaff;
	}
}
