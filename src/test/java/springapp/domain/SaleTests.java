package springapp.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class SaleTests {

	@Test
	public void testSaleConstructorPopulatesFields() {

		Sale sale = new Sale("Bob", "21 Mar, 1975", "23");

		assertEquals("Bob", sale.getSalesAssistant());
		assertEquals("21 Mar, 1975", sale.getTimeStamp());
		assertEquals("23", sale.getTillId());
	}

}
