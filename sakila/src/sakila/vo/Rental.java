package sakila.vo;

public class Rental {
	private int rentalId;
	private String title;
	private String rentalDate;
	private String returnDate;
	
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Rental [rentalId=" + rentalId + ", title=" + title + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + "]";
	}
	
}
