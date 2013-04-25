package springapp.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import springapp.service.OrderController;

public class OrderControllerTest {

	private OrderController orderController;

	@Before
	public void Setup() {
		orderController = new OrderController(new Validator());
	}

	@Test
	public void whenOrderControllerCreatedThenCurrentOrderIsNull() {
		assertEquals(null, orderController.getCurrentOrder());
	}

	@Test
	public void whenOrderCreatedThenCurrentOrderIsNotNull() {
		orderController.createOrder(createDate(2013, 04, 22), 6, 3);
		assertNotNull(orderController.getCurrentOrder());
	}

	@Test
	public void whenOrderCreatedThenCurrentOrderIsCorrect() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		assertEquals(4, orderController.getCurrentOrder().tillId);
		assertEquals(7, orderController.getCurrentOrder().salesAssistantId);
		assertEquals(createDate(2013, 6, 21),
				orderController.getCurrentOrder().date);
	}

	@Test
	public void whenAnotherOrderCreatedThenCurrentOrderIsCorrect() {
		orderController.createOrder(createDate(2013, 04, 18), 3, 4);
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		assertEquals(4, orderController.getCurrentOrder().tillId);
		assertEquals(7, orderController.getCurrentOrder().salesAssistantId);
		assertEquals(createDate(2013, 6, 21),
				orderController.getCurrentOrder().date);
	}

	@Test
	public void whenOrderLineAddedToOrderThenIdIsReturned() {
		orderController.createOrder(createDate(2013, 6, 21), 4, 7);
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		assertTrue(lineId != 0);
	}

	@Test
	public void whenOrderLineAddedToOrderThenIdIsReturnedAs1() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		assertEquals(1, lineId);
	}

	@Test
	public void whenSecondOrderLineAddedToOrderThenIdIsReturnedAs2() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		int line1Id = orderController.addOrderLine("987654", 3, 4.67, 0.1,
				"BOX");
		int line2Id = orderController
				.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		assertEquals(1, line1Id);
		assertEquals(2, line2Id);
	}

	@Test(expected = NoOrderPresentException.class)
	public void whenOrderLineAddedToOrderAndNoOrderPresentInControllerThenExceptionIsThrown() {
		orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
	}

	@Test
	public void whenOrderLineIsUpdatedNewQtyReturned() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		orderController.updateOrderLineQuantity(lineId, 5);
		assertEquals(5, orderController.getCurrentOrderLine(lineId).quantity);
	}

	@Test(expected = OrderLineInvalidException.class)
	public void whenOrderLineIsUpdatedToZeroThenThrowException() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		orderController.updateOrderLineQuantity(lineId, 0);
	}

	@Test(expected = OrderLineInvalidException.class)
	public void whenOrderLineIsUpdatedToNegativeThenThrowException() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		orderController.updateOrderLineQuantity(lineId, -2);
	}

	@Test(expected = OrderLineInvalidException.class)
	public void whenOrderLineIsUpdatedButNotCreatedThenThrowException() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		orderController.updateOrderLineQuantity(5, 3);
	}

	@Test(expected = OrderLineInvalidException.class)
	public void whenOrderLineIsAddedWithZeroQtyThenThrowException() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		orderController.addOrderLine("123456", 0, 5.67, 0.2, "EA");
	}

	@Test(expected = OrderLineInvalidException.class)
	public void whenOrderLineIsAddedWithNegativeQtyThenThrowException() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		orderController.addOrderLine("123456", -1, 5.67, 0.2, "EA");
	}

	@Test(expected = NoOrderPresentException.class)
	public void whenOrderLineUpdatedWhenNoOrderThenThrowException() {
		orderController.updateOrderLineQuantity(1, 4);
	}

	@Test
	public void whenOrderLineIsUpdatedNewQtyReturnedMaxValue() {
		orderController.createOrder(createDate(2013, 06, 21), 4, 7);
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		orderController.updateOrderLineQuantity(lineId, Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE,
				orderController.getCurrentOrderLine(lineId).quantity);
	}

	private Date createDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
