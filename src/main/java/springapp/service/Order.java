package springapp.service;
import java.util.ArrayList;
import java.util.Date;


public class Order {

	public int tillId;
	public int salesAssistantId;
	public int orderID;
	public Date date;
	public ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();

	public Order(int INPtillId, int INPsaleAssistentId, Date orderDate) {
		
		tillId = INPtillId;	
		salesAssistantId = INPsaleAssistentId;
		date = orderDate;
	}



}
