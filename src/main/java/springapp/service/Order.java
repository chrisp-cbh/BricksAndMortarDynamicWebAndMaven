package springapp.service;
import java.util.Date;


public class Order {

	public int tillId;
	public int salesAssistentId;
	public int orderID;
	public Date date;

	public Order(int INPtillId, int INPsaleAssistentId, Date orderDate) {
		
		tillId = INPtillId;	
		salesAssistentId = INPsaleAssistentId;
		date = orderDate;
	}



}
