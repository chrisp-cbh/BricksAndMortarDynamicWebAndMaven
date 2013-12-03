package springapp.web;

import java.util.Date;

import springapp.domain.Order;
import springapp.domain.OrderLine;
import springapp.domain.OrderLineInvalidException;
import springapp.service.NoOrderPresentException;
import springapp.service.Validator;

public class OrderController {

	private Order currentOrder;
	private Validator validator;

	public OrderController(Validator validator)
	{
		this.validator = validator;
	}
	
	public Order getCurrentOrder() {
		return this.currentOrder;
	}

	public void createOrder(Date date, int tillId, int salesPersonId) {
		this.currentOrder = new Order(tillId, salesPersonId, date);
	}

	public int addOrderLine(String sku, int quantity, double unitPrice,
			double vatRate, String uom) {
		if (!this.validator.CurrentOrderIsPresent(this.currentOrder)) {
			throw new NoOrderPresentException();
		}
		if (!this.validator.OrderLineQuantityIsValid(quantity)) {
			throw new OrderLineInvalidException();
		}
		OrderLine orderLine = new OrderLine(sku, quantity, unitPrice, vatRate,
				uom);
		this.currentOrder.orderLines.add(orderLine);
		return this.currentOrder.orderLines.size();
	}

	public void updateOrderLineQuantity(int lineId, int quantity) {
		if (!this.validator.CurrentOrderIsPresent(this.currentOrder)) {
			throw new NoOrderPresentException();
		}
		if (!this.validator.OrderLineQuantityIsValid(quantity)) {
			throw new OrderLineInvalidException();
		}
		if (lineId > this.currentOrder.orderLines.size()) {
			throw new OrderLineInvalidException();
		}
		getCurrentOrderLine(lineId).quantity = quantity;
	}

	public OrderLine getCurrentOrderLine(int lineId) {
		return this.currentOrder.orderLines.get(lineId-1);
	}
}
