package springapp.repository;

import springapp.service.Order;

public class OrderDao implements IOrderDao {

	@Override
	public boolean Place(Order order) {


		return true;
	}

}
