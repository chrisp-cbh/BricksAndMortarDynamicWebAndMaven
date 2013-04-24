package springapp.fitnesse;

import java.util.ArrayList;
import java.util.List;

import springapp.domain.OrderHeaderManager;

public class SadPathCannotCreateInvalidOrder 
{
	private String tillID = "";
	private String userID = "";
	
	public SadPathCannotCreateInvalidOrder(String tillID, String userID)
	{
		this.tillID = tillID;
		this.userID = userID;
	}
	
	public List<Object> query() 
	{
		List<Object> queryResults = new ArrayList<Object>();
		OrderHeaderManager ohm = new OrderHeaderManager();
		queryResults.add(DataRetrieval.buildSingleObjectList(ohm.createResponse(this.tillID, this.userID)));

		return queryResults;
	}

}
