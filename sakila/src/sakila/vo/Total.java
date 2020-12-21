package sakila.vo;

public class Total {
	private String store;		// 매장 이름
	private String manager;		// 매장 매니저 이름
	private float totalSales;	// 총 매출
	private String category;	// 카테고리
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public float getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(float totalSales) {
		this.totalSales = totalSales;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Total [store=" + store + ", manager=" + manager + ", totalSales=" + totalSales + ", category="
				+ category + "]";
	}
}
