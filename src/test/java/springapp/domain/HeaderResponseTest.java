package springapp.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class HeaderResponseTest {

	@Test
	public void headerResponseCanPopulateStatus() {
		HeaderResponse headerResponse = new HeaderResponse();
		headerResponse.status = "OK";
		assertEquals("OK",headerResponse.status);
	}
	
	@Test
	public void headerResponseCanPopulateOrderHeader(){
		
		HeaderResponse headerResponse = new HeaderResponse();
		OrderHeader orderHeaderMock = mock(OrderHeader.class);
		headerResponse.orderHeader = orderHeaderMock;
		assertEquals("Should be able to populate the OrderHeader member.",orderHeaderMock,headerResponse.orderHeader);
	}
	
}
