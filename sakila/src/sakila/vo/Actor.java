package sakila.vo;

public class Actor {
	private int actorId;
	private String firstName;
	private String lastName;
	private String lastUpdate;
	private String filmInfo;
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
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
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getFilmInfo() {
		return filmInfo;
	}
	public void setFilmInfo(String filmInfo) {
		this.filmInfo = filmInfo;
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
				+ lastUpdate + ", filmInfo=" + filmInfo + "]";
	}
}
