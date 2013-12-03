package springapp.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

	private String description;
	private Double price;
	private int id;
	private int value;
	private String type;

	public void setId(int i) {
		id = i;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Id: " + id + ";");
		buffer.append("Price: " + price);
		return buffer.toString();
	}

	public void setValue(int value) {
		this.value = value;

	}

	public int getValue() {
		return value;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}

}