package springapp.domain;

public class OrderHeaderManager 
{
	public Validation validation = new Validation();
	public OrderHeader orderHeader;

	public HeaderResponse createResponse(String tillId, String userId) 
	{
		HeaderResponse headerResponse = new HeaderResponse();
		if(validation.isValid(tillId, userId))
		{
			orderHeader = new OrderHeader();
			orderHeader.tillId = tillId;
			orderHeader.userId = userId;
			headerResponse.status = "0";
			headerResponse.message = "OK";
		}
		headerResponse.orderHeader = orderHeader;
		return headerResponse;
	}

}
