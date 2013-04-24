package springapp.repository;

import springapp.dummy.Order;

public interface IOrderDao {

	boolean Place(Order order);

}
