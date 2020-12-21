package sakila.dao;

import java.sql.*;
import java.util.ArrayList;

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
		stmt.setString(1, staff.getEmail());
		stmt.setString(2, staff.getPassword());
		System.out.println("stmt > "+stmt);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setUsername(rs.getString("username"));
			returnStaff.setStaffId(rs.getInt("staff_Id"));
			
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("staff_Id"));
		}
		
		conn.close();
		return returnStaff;
	}
	// staff info 메서드
	public ArrayList<Staff> selectStaffInfo(Connection conn, Staff staff) throws Exception {
		ArrayList<Staff> list = new ArrayList<Staff>();
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_INFO);
		stmt.setInt(1, staff.getStaffId());
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Staff staffList = new Staff();
			staffList.setFirstName(rs.getString("first_name"));
			staffList.setLastName(rs.getString("last_name"));
			staffList.setStaffId(rs.getInt("staff_id"));
			staffList.setStoreId(rs.getInt("store_id"));
			staffList.setEmail(rs.getString("email"));
			staffList.setAddress(rs.getString("address"));
			
			list.add(staffList);
		}
		return list;
	}
}
