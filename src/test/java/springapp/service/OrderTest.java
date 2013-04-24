package springapp.service;
import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Calendar;
import java.util.Date;
//import java.util.Calender;

public class OrderTest {

	@Test
	public void orderObjectCanBeInstantiatedAndValuesAreSetCorrectly()
	{
		int tillId = 1;
		int salesAssistantId = 12;
		Date orderDate = new Date();
		
		Order order = new Order(tillId, salesAssistantId, orderDate);
		
		assertEquals(tillId, order.tillId);
		assertEquals(salesAssistantId, order.salesAssistantId);
		assertEquals(orderDate, order.date);
	}
	
	@Test
	public void orderObjectCanBeInstantiatedAndOtherValuesAreSetCorrectly()
	{
		int tillId = 2;
		int salesAssistantId = 48;
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 1);
		
		Date orderDate = calendar.getTime();
		
		Order order = new Order(tillId, salesAssistantId, orderDate);
		
		assertEquals(tillId, order.tillId);
		assertEquals(salesAssistantId, order.salesAssistantId);
		assertEquals(orderDate, order.date);
	}
}
