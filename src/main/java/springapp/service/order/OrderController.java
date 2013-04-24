package springapp.service.order;

import java.sql.Date;

import springapp.service.Order;

public class OrderController {

	private Order currentOrder;

	protected Order getCurrentOrder() {
		return this.currentOrder;
	}

	public void createOrder(Date date, int tillId, int salesPersonId) {
		this.currentOrder = new Order(tillId, salesPersonId, date);
	}
}
