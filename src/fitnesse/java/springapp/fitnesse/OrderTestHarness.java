package springapp.fitnesse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import springapp.service.Order;
import springapp.service.OrderLine;

public class OrderTestHarness {
	
	private Order order;
	private OrderLine orderLine;

	public boolean CreateOrderHeaderForUserAtTillOn(int userId, int till, String orderDate) throws ParseException 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		order = new Order(till, userId, sdf.parse(orderDate));
		
		return true;
	}
	
	public int AddOrderLineWithSkuOfTheQuantityAtTheCostOfAndVatRateOfPer(String productSku, int quantity, double price, double vat, String uom) 
	{		
		orderLine = new OrderLine(productSku, quantity, price, vat, uom);
		
		//return order.addOrderLine(orderLine);
		
		return 1;
	}

	public boolean UpdateOrderLineQuantityOfLineIdSetQuantityTo( int lineId, int quantity) 
	{			
		return false;
	}
}
