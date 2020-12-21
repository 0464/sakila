package sakila.query;

public class StaffQuery {
	// StaffDao.selectStaffByKey
	public final static String SELECT_STAFF_BY_KEY = "SELECT email, username, staff_id FROM staff WHERE email=? AND password=password(?)";
	// 관리자 마이페이지
	public final static String SELECT_STAFF_INFO = "SELECT s.first_name, s.last_name, s.staff_id, s.email, a.address, s.store_id\r\n" + 
			"FROM staff AS s\r\n" + 
			"INNER JOIN address AS a ON s.address_id = a.address_id\r\n" + 
			"WHERE s.staff_id = ?";
}
