package springapp.fitnesse;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import springapp.domain.Order;
import springapp.domain.OrderLine;
import springapp.web.OrderController;

public class OrderTestHarness {
	
//	OrderController oc = new OrderController();
//	
//	public String CreateOrderHeaderForUserAtTillOn(int userId, int till, String orderDate) throws ParseException 
//	{
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		oc.createOrder((Date) sdf.parse(orderDate), till, userId);
//		
//		return oc.getCurrentOrder().id; 
//	}
//	
//	public int AddOrderLineWithSkuOfTheQuantityAtTheCostOfAndVatRateOfPer(String productSku, int quantity, double price, double vat, String uom) 
//	{
//		return oc.addOrderLine(productSku, quantity, price, vat, uom);
//	}
//	
//	public int ChangeQuantityOnOrderLine(int NewQuantity, int OrderLineNumber)
//	{
//		try
//		{
//			oc.updateOrderLineQuantity(OrderLineNumber, NewQuantity);
//		} catch (Exception ex) {}
//		
//		return oc.getCurrentOrderLine(OrderLineNumber).quantity;
//	}
	
}
