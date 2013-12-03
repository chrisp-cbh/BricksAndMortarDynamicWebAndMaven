package springapp.repository;

import springapp.domain.Order;

public interface IOrderDao {

	boolean Place(Order order);

}
