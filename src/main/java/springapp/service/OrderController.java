package springapp.service;

import java.util.Date;

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
		if (this.currentOrder == null) {
			throw new NoOrderPresentException();
		}
		OrderLine orderLine = new OrderLine(sku, quantity, unitPrice, vatRate,
				uom);
		this.currentOrder.orderLines.add(orderLine);
		return this.currentOrder.orderLines.size();
	}

	public void updateOrderLineQuantity(int lineId, int quantity) {
		if (quantity == 0) {
			throw new OrderLineInvalidException();
		}
		getCurrentOrderLine(lineId).quantity = quantity;
	}

	public OrderLine getCurrentOrderLine(int lineId) {
		return this.currentOrder.orderLines.get(lineId-1);
	}
}
