package springapp.repository;

import org.junit.Test;
import static org.mockito.Mockito.*;

import springapp.dummy.Order;

public class OrderDaoTests {

	@Test
	public void OrderCanBePlaced() {
		IOrderDao orderDao = mock(IOrderDao.class);
		Order order = new Order(0,0);
		orderDao.Place(order);
		
		verify(orderDao).Place(order);
	}

}
