package sakila.query;

public class FilmListQuery {
	// 전체 필름을 출력하는 쿼리
	public final static String SELECT_FILM_LIST = "SELECT fl.FID, fl.category, fl.title, l.name, fl.rating, fl.price FROM film_list AS fl INNER JOIN film AS f ON fl.FID = f.film_id INNER JOIN language AS l ON f.language_id = l.language_id ORDER BY FID ASC LIMIT ?, ?";
	
	// 영화 목록 카운트 쿼리
	public final static String SELECT_COUNT_FILM_LIST = "SELECT COUNT(*) FROM film_list AS fl INNER JOIN film AS f ON fl.FID = f.film_id INNER JOIN language AS l on f.language_id = l.language_id";
}
