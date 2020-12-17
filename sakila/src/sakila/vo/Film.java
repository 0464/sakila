package sakila.vo;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private String releaseYear;
	private String language;
	private String originalLanguage;
	private int rentalDuration;
	private float rentalRate;
	private int length;
	private float replacementCost;
	private String rating;
	private String lastUpdate;
	
	private String category;		// 카테고리
	private String actors;			// 영화 배우
	private int totalFilm;			// 영화 총 재고
	private int filmStockAmount;	// 영화 현재 재고
	private int filmRentalAmount;	// 영화 대여 수
	
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public float getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(float replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public int getTotalFilm() {
		return totalFilm;
	}
	public void setTotalFilm(int totalFilm) {
		this.totalFilm = totalFilm;
	}
	public int getFilmStockAmount() {
		return filmStockAmount;
	}
	public void setFilmStockAmount(int filmStockAmount) {
		this.filmStockAmount = filmStockAmount;
	}
	public int getFilmRentalAmount() {
		return filmRentalAmount;
	}
	public void setFilmRentalAmount(int filmRentalAmount) {
		this.filmRentalAmount = filmRentalAmount;
	}
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", originalLanguage=" + originalLanguage
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", lastUpdate=" + lastUpdate
				+ ", category=" + category + ", actors=" + actors + ", totalFilm=" + totalFilm + ", filmStockAmount="
				+ filmStockAmount + ", filmRentalAmount=" + filmRentalAmount + "]";
	}
	
}
