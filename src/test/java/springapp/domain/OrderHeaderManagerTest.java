package springapp.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class OrderHeaderManagerTest {

	@Test
	public void createResponseReturnsHeaderResponseObject() {
		OrderHeaderManager ohm = new OrderHeaderManager();
		assertTrue(ohm.createResponse() instanceof HeaderResponse);
	}
	
	@Test
	public void verifyIsValidIsCalled() {
		Validation v = Mockito.mock(Validation.class);
		OrderHeaderManager ohm = new OrderHeaderManager();
		ohm.validation = v;
//		Mo
//		Mockito.verify(v.isValid(Mockito.anyString(), Mockito.anyString()));
		
	}
	
//	@Test
//	public void isValidReturnsTrueWithValidData() {
//		OrderHeaderManager ohm = new OrderHeaderManager();
//		assertTrue(ohm.createResponse() instanceof HeaderResponse);
//	}

}
