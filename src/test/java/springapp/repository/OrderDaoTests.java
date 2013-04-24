package springapp.repository;

import java.util.Calendar;

import org.junit.Test;

import springapp.service.Order;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OrderDaoTests {

	@Test
	public void OrderCanBePlacedUsingInterface() {
		
		IOrderDao orderDao = mock(IOrderDao.class);
		Order order = new Order(4,6,Calendar.getInstance().getTime());
		orderDao.Place(order);
		
		verify(orderDao).Place(order);
	}

	@Test
	public void OrderCanBePlaced() {
		
		IOrderDao orderDao = new OrderDao();
		
		Order order = new Order(4,6,Calendar.getInstance().getTime());
		assertTrue(orderDao.Place(order));
	}

	
}
