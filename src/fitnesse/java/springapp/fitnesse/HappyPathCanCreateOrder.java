package springapp.fitnesse;

import java.util.ArrayList;
import java.util.List;

import springapp.domain.OrderHeaderManager;

public class HappyPathCanCreateOrder 
{
	private String tillID = "";
	private String userID = "";
	
	public HappyPathCanCreateOrder(String tillID, String userID)
	{
		this.tillID = tillID;
		this.userID = userID;
	}
	
	public List<Object> query() 
	{
		ArrayList<Object> queryResults = new ArrayList<Object>();
		OrderHeaderManager ohm = new OrderHeaderManager();
		//queryResults = DataRetrieval.buildSingleObjectList(ohm.CreateOrder(this.tillID, this.userID));

		return queryResults;
	}
}
