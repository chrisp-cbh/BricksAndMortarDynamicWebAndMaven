package springapp.fitnesse;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class CreateSaleTests {

	@Test
	public void saleIdShouldBePopulatedWithIdIfCreateSaleWorksCorrectly() {
		CreateSale createSale = new CreateSale();
		
		createSale.setSalesAssistant("George");
		createSale.setTillId("3432");
		createSale.setTimeStamp("14 Dec, 2052");
		
		createSale.execute();
		assertNotSame(0, createSale.saleId());
	}

}
