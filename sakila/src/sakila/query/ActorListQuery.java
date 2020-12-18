package sakila.query;

public class ActorListQuery {
	// 배우 목록 쿼리
	public final static String SELECT_ACTOR_LIST = "SELECT actor_id, first_name, last_name from actor limit ?, ?";
	// 배우 목록 카운트 쿼리
	public final static String SELECT_COUNT_ACTOR_LIST = "SELECT COUNT(*) FROM actor";
	// 배우 상세보기 쿼리
	public final static String SELECT_ACTOR_ONE = "SELECT actor_id, first_name, last_name, film_info FROM actor_info WHERE actor_id = ?";
}
