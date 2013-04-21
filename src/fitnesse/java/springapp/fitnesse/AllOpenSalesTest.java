package springapp.fitnesse;

import org.junit.Test;

public class AllOpenSalesTest {

	@Test
	public  void exploratoryTestOfHittingTheDao() throws Exception {		
		AllOpenSales allOpenSales = new AllOpenSales();
		allOpenSales.query();
	}
}
