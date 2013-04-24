package springapp.repository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import springapp.service.Order;

public class OrderDaoTests {

	@Test
	public void OrderCanBePlaced() {
		IOrderDao orderDao = mock(IOrderDao.class);
		Order order = new Order(0,0, null);
		orderDao.Place(order);
		
		verify(orderDao).Place(order);
	}

}
