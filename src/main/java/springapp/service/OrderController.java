package springapp.service;

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

	public int addOrderLine(String sku, int quantity, double unitPrice,
			double vatRate, String uom) {
		return 1;
	}
}
