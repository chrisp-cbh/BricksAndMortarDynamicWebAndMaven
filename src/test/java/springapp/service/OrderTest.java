package springapp.service;
import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Calendar;
import java.util.Date;
//import java.util.Calender;

public class OrderTest {

	@Test
	public void checkTillIdIsReturnedCorrectly() {
		Order order = new Order(1, 1, new Date());
		assertEquals(1, order.tillId);
	}

	@Test
	public void checkAnotherTillIdIsReturnedCorrectly() {
		Order order = new Order(5, 1, new Date());
		assertEquals(5, order.tillId);
	}

	@Test
	public void checkSalesAssistentIdIsReturnedCorrectly() {
		Order order = new Order(5, 1, new Date());
		assertEquals(1, order.salesAssistentId);
	}

	@Test
	public void checkAnotherSalesAssistentIdIsReturnedCorrectly() {
		Order order = new Order(5, 2, new Date());
		assertEquals(2, order.salesAssistentId);
	}
	
	@Test
	public void checkDateIsReturnedCorrectly() {
		Date dateToCheck = new Date();
		
		Order order = new Order(5, 1, dateToCheck);
		assertEquals(dateToCheck, order.date);
	}

	@Test
	public void checkAnotherDateIsReturnedCorrectly() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 1);
		
		Date dateToCheck = calendar.getTime();
		
		Order order = new Order(5, 2, dateToCheck);
		assertEquals(dateToCheck, order.date);
	}
	
	
//	@Test
//	public void checkOrderIDIsReturnedCorrectly() {
//		Order order = new Order(5, 1);
//		assertEquals(1, order.orderID);
//	}
//
//	@Test
//	public void checkAnotherOrderIDIsReturnedCorrectly() {
//		Order order = new Order(5, 2);
//		assertEquals(2, order.orderID);
//	}

	
	
	
	
}
