package springapp.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class OrderHeaderManagerTest {

	@Test
	public void createResponseReturnsHeaderResponseObject() {
		OrderHeaderManager ohm = new OrderHeaderManager();
		assertTrue(ohm.createResponse("123","456") instanceof HeaderResponse);
	}
	
	@Test
	public void verifyIsValidIsCalled() {
		Validation v = Mockito.mock(Validation.class);
		OrderHeaderManager ohm = new OrderHeaderManager();
		ohm.validation = v;
		ohm.createResponse("123", "456");
		Mockito.verify(v, Mockito.times(1)).isValid(Mockito.anyString(), Mockito.anyString());
	}
	
	@Test
	public void ifDataIsValidOrderHeaderIsCreated() {
		OrderHeaderManager ohm = new OrderHeaderManager();
		ohm.createResponse("123","456");
		assertTrue(ohm.orderHeader instanceof OrderHeader);
	}
	
	@Test
	public void orderHeaderResponseEqualsSetOrderHeader() {
		OrderHeaderManager ohm = new OrderHeaderManager();
		HeaderResponse response = ohm.createResponse("123","456");
		assertTrue(ohm.orderHeader.tillId == response.orderHeader.tillId);
		assertTrue(ohm.orderHeader.userId == response.orderHeader.userId);
	}
	
	@Test
	public void ifDataIsValidOrderHeaderIsCreatedWithPassedInValues() {
		OrderHeaderManager ohm = new OrderHeaderManager();
		HeaderResponse response = ohm.createResponse("123","456");
		assertTrue(ohm.orderHeader.tillId.equals("123"));
		assertTrue(ohm.orderHeader.userId.equals("456"));
		assertTrue(response.message.equals("OK"));
		assertTrue(response.status.equals("0"));
	}
	
//	@Test
//	public void ifTillIdIsInvalidHeaderResponseReturnedWithInvalidMessageAndStatus() {
//		
//		
//		assertTrue(response.message.equals())
//	}

}
