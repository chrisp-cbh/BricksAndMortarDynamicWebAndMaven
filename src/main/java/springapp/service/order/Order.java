package springapp.service.order;

import java.util.Date;

public class Order {

	public int tillId;
	public int salesPersonId;
	public Date date;

	public Order(Date date, int tillId, int salesPersonId) {
		this.tillId = tillId;
		this.salesPersonId = salesPersonId;
		this.date = date;
	}

}
