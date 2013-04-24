package springapp.service.order;

import java.sql.Date;

public class OrderController {

	private Order currentOrder;

	protected Order getCurrentOrder() {
		return this.currentOrder;
	}

	public void createOrder(Date date, int tillId, int salesPersonId) {
		this.currentOrder = new Order(date, tillId, salesPersonId);
	}

	public int addOrderLine(String sku, int quantity, double unitPrice,
			double vatRate, String uom) {
		int lineId = this.currentOrder.addOrderLine(new OrderLine(sku, quantity, unitPrice,
				vatRate, uom));
		return lineId;
	}
}
