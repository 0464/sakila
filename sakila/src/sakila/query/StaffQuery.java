package sakila.query;

public class StaffQuery {
	// StaffDao.selectStaffByKey
	public final static String SELECT_STAFF_BY_KEY = "SELECT staff_id, username FROM staff WHERE staff_id=? AND password=password(?)";
}
