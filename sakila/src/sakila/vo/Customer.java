package sakila.vo;

public class Customer {
	private int customerId;
	private int storeId;
	private String firstName;
	private String lastName;
	private String email;
	private int active;
	private String createDate;
	private String lastUpdate;
	private String address;		// 고객 주소
	private String zipCode;		// 고객 우편번호
	private String phone;		// 고객 연락처
	private String name;		// 고객 풀네임
	private String notes;		// 고객 활성화 여부
	private String overdue;		// 연체 여부 (Y 연체, N 미연체)
	private float totalAmount;	// 총 구매액
	private int sid;			// 고객 메인 매장
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", storeId=" + storeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", active=" + active + ", createDate=" + createDate
				+ ", lastUpdate=" + lastUpdate + ", address=" + address + ", zipCode=" + zipCode + ", phone=" + phone
				+ ", name=" + name + ", notes=" + notes + ", overdue=" + overdue + ", totalAmount=" + totalAmount
				+ ", sid=" + sid + "]";
	}
}
