package springapp.service;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import springapp.service.OrderController;

public class OrderControllerTest {

	private OrderController orderController;

	@Before
	public void Setup() {
		orderController = new OrderController();
	}

	@Test
	public void whenOrderControllerCreatedThenCurrentOrderIsNull() {
		assertEquals(null, orderController.getCurrentOrder());
	}

	@Test
	public void whenOrderCreatedThenCurrentOrderIsNotNull() {
		orderController.createOrder(new Date(2013, 04, 22), 6, 3);
		assertNotNull(orderController.getCurrentOrder());
	}

	@Test
	public void whenOrderCreatedThenCurrentOrderIsCorrect() {
		orderController.createOrder(new Date(2013, 06, 21), 4, 7);
		assertEquals(4, orderController.getCurrentOrder().tillId);
		assertEquals(7, orderController.getCurrentOrder().salesAssistentId);
		assertEquals(new Date(2013, 6, 21),
				orderController.getCurrentOrder().date);
	}

	@Test
	public void whenAnotherOrderCreatedThenCurrentOrderIsCorrect() {
		orderController.createOrder(new Date(2013, 04, 18), 3, 4);
		orderController.createOrder(new Date(2013, 06, 21), 4, 7);
		assertEquals(4, orderController.getCurrentOrder().tillId);
		assertEquals(7, orderController.getCurrentOrder().salesAssistentId);
		assertEquals(new Date(2013, 6, 21),
				orderController.getCurrentOrder().date);
	}

	@Test
	public void whenOrderLineAddedToOrderThenIdIsReturned() {
		int lineId = orderController.addOrderLine("123456", 4, 5.67, 0.2, "EA");
		assertTrue(lineId != 0);
	}
	
}
