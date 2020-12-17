package sakila.query;

public class FilmStockListQuery {
	// 필름 재고 출력 쿼리
	public final static String SELECT_FILM_STOCK_LIST = "SELECT f.film_id, c.name AS category, f.title, l.name AS language, f.rating, COUNT(rental_id) AS cnt FROM rental r INNER JOIN inventory i ON r.inventory_id = i.inventory_id INNER JOIN film f ON i.film_id = f.film_id INNER JOIN sakila.`language` l ON f.language_id = l.language_id INNER JOIN film_category fc ON f.film_id = fc.film_id INNER JOIN category c ON fc.category_id = c.category_id WHERE r.return_date IS NULL GROUP BY f.film_id ORDER BY f.film_id LIMIT ?, ?";
	// 필름 재고 카운트 쿼리
	public final static String SELECT_COUNT_FILM_STOCK_LIST = "SELECT COUNT(*) FROM rental r INNER JOIN inventory i ON r.inventory_id = i.inventory_id INNER JOIN film f ON i.film_id = f.film_id INNER JOIN sakila.`language` l ON f.language_id = l.language_id INNER JOIN film_category fc ON f.film_id = fc.film_id INNER JOIN category c ON fc.category_id = c.category_id WHERE r.return_date IS NULL";
}