package springapp.repository;

import springapp.domain.Order;

public class OrderDao implements IOrderDao {

	@Override
	public boolean Place(Order order) {


		return true;
	}

}
