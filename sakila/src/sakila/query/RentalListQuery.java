package sakila.query;

public class RentalListQuery {
	// 대여 목록 쿼리
	public final static String SELECT_RENTAL_LIST = "SELECT r.rental_id, f.title, r.rental_date, r.return_date FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id JOIN film f ON i.film_id = f.film_id ORDER BY r.rental_id ASC LIMIT ?, ?";
	// 대여 목록 검색 쿼리
	public final static String SELECT_RENTAL_SEARCH_LIST = "SELECT r.rental_id, f.title, r.rental_date, r.return_date FROM rental r JOIN inventory i ON r.inventory_id = i.inventory_id JOIN film f ON i.film_id = f.film_id WHERE r.rental_id = ? ORDER BY r.rental_id ASC";
	// 대여 목록 카운트 쿼리
	public final static String SELECT_COUNT_RENTAL_LIST = "SELECT COUNT(*) FROM rental";
	// 반납 쿼리
	public final static String DELETE_RENTAL = "DELETE FROM rental WHERE rental_id = ?";
}
