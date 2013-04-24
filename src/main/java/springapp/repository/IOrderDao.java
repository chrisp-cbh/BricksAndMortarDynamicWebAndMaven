package springapp.repository;

import springapp.service.Order;

public interface IOrderDao {

	boolean Place(Order order);

}
