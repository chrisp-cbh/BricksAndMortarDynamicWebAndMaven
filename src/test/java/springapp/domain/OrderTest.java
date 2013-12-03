package springapp.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

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
		assertNotNull(order.id);
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
		assertNotNull(order.id);
	}
	

	@Test
	public void twoInstancesOfOrderDoNotHaveTheSameId()
	{
		Order orderOne = new Order(1,2,new Date());
		Order orderTwo = new Order(1,2,new Date());

		assertNotSame(orderOne.id, orderTwo.id);		
	}
	
	@Test
	public void orderLineCanBeAddedToOrderObject()
	{
		Order order = new Order(10, 4, new Date());
		OrderLine orderLine = new OrderLine("sku", 1, 10.0, 20.0, "uom");
		
		order.orderLines.add(orderLine);		
		assertEquals(orderLine, order.orderLines.get(0));
	}

	@Test
	public void multipleOrderLinesCanBeAddedToOrderObject()
	{
		OrderLine firstOrderLine = new OrderLine("sku1", 1, 15.0, 20.0, "M3");
		OrderLine secondOrderLine = new OrderLine("sku2", 2, 15.0, 20.0, "M3");
		OrderLine thirdOrderLine = new OrderLine("sku3", 3, 15.0, 20.0, "M3");
		
		Order order = new Order(10, 2, new Date());
		
		order.orderLines.add(firstOrderLine);
		order.orderLines.add(secondOrderLine);
		order.orderLines.add(thirdOrderLine);
		
		assertEquals(firstOrderLine, order.orderLines.get(0));
		assertEquals(secondOrderLine, order.orderLines.get(1));
		assertEquals(thirdOrderLine, order.orderLines.get(2));
	}

}
