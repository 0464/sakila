package sakila.query;

public class CustomerListQuery {
	// 회원 목록 쿼리
	public final static String SELECT_CUSTOMER_LIST = "SELECT cust.ID, cust.name, cust.phone, cust.notes, IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cust.ID) > 0,'Y','N') AS overdue FROM customer_list cust ORDER BY cust.id ASC LIMIT ?, ?";
	// 회원 목록 카운트 쿼리
	public final static String SELECT_COUNT_CUSTOMER_LIST = "SELECT COUNT(*) FROM customer_list";
}
