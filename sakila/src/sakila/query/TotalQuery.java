package sakila.query;

public class TotalQuery {
	// 매장 별 총 판매량
	public final static String SELECT_STORE_TOTAL = "SELECT store, manager, total_sales FROM sales_by_store";
	// 카테고리별 판매량
	public final static String SELECT_CATEGORY_TOTAL = "SELECT category, total_sales FROM sales_by_film_category";
}
