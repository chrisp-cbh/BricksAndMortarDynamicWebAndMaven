package springapp.domain;

public class Sale {

	private String salesAssistant;
	private String timeStamp;
	private String tillId;
	private long id;

	public Sale(String salesAssistant, String timeStamp, String tillId) {
		this.salesAssistant = salesAssistant;
		this.timeStamp = timeStamp;
		this.tillId = tillId;
	}

	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}

	public String getSalesAssistant() {
		return salesAssistant;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getTillId() {
		return tillId;
	}

	public void setTillId(String tillId) {
		this.tillId = tillId;
	}

}