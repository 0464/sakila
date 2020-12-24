package sakila.query;

public class CustomerListQuery {
	// 회원 목록 쿼리
	public final static String SELECT_CUSTOMER_LIST = "SELECT cust.ID, cust.name, cust.phone, cust.notes, IF((SELECT COUNT(*) "
													+ "FROM rental WHERE return_date IS NULL AND customer_id = cust.ID) > 0,'연체','미연체') AS overdue FROM customer_list cust ORDER BY cust.id ASC LIMIT ?, ?";
	// 회원 목록 카운트 쿼리
	public final static String SELECT_COUNT_CUSTOMER_LIST = "SELECT COUNT(*) FROM customer_list";
	// 회원 상세보기 쿼리
	public final static String SELECT_CUSTOMER_ONE = "SELECT cu.customer_id AS ID, CONCAT(cu.first_name, _utf8mb4' ', cu.last_name) AS name, cu.email, a.address AS address, a.postal_code AS `zip code`, a.phone AS phone, city.city AS city, country.country AS country, IF(cu.active, _utf8mb4'active',_utf8mb4'') AS notes, cu.store_id AS SID "
												+ "FROM customer AS cu JOIN address AS a ON cu.address_id = a.address_id JOIN city ON a.city_id = city.city_id JOIN country ON city.country_id = country.country_id "
												+ "WHERE cu.customer_id = ?";
	// MVP 회원 목록 쿼리
	public final static String SELECT_MVP_LIST = "SELECT c.customer_id AS ID, CONCAT(c.first_name, _utf8mb4' ', c.last_name) AS name, SUM(p.amount) AS totalAmount, c.store_id AS SID\r\n" + 
												"FROM payment AS p\r\n" + 
												"INNER JOIN customer AS c ON p.customer_id = c.customer_id\r\n" + 
												"GROUP BY name\r\n" + 
												"ORDER BY totalAmount DESC\r\n" + 
												"LIMIT 0, 10";
	// 회원 목록 검색 쿼리
	public final static String SELECT_CUSTOMER_SEARCH_LIST = "SELECT cust.ID, cust.name, cust.phone, cust.notes, IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cust.ID) > 0,'연체','미연체') AS overdue FROM customer_list AS cust "
			+ "WHERE (IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cust.ID) > 0,'연체','미연체')) = ? ORDER BY cust.id ASC LIMIT ?, ?";
	// 회원 목록 검색 카운트 쿼리
	public final static String SELECT_COUNT_CUSTOMER_SEARCH_LIST = "SELECT COUNT(*) FROM customer_list AS cust WHERE (IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cust.ID) > 0,'연체','미연체')) = ? ORDER BY cust.id";
}
