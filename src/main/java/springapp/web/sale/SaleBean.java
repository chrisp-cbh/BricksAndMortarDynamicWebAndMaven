package springapp.web.sale;

public class SaleBean {
	private String salesAssistant;
	private String tillId;
	private String timeStamp;

	public String getSalesAssistant() {
		return salesAssistant;
	}

	public String getTillId() {
		return tillId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setSalesAssistant(String val) {
		this.salesAssistant = val;
	}

	public void setTillId(String val) {
		this.tillId = val;
	}

	public void setTimeStamp(String val) {
		this.timeStamp = val;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		prettyfyAttributeToString(sb, "salesAssistant", salesAssistant);
		prettyfyAttributeToString(sb, "tillId", tillId);
		prettyfyAttributeToString(sb, "timeStamp", timeStamp);
		return sb.toString();
	}

	private void prettyfyAttributeToString(StringBuilder sb, String name,
			String val) {
		sb.append("property " + name + "=");
		sb.append("'").append(val).append("', ");
	}

}
