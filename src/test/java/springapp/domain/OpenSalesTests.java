package springapp.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class OpenSalesTests {

	private Sale sale;

	private Sale simpleSale() {
		return new Sale("salesAssistant", "timeStamp", "tillId");
	}

	@Test
	public void whenNewIsEmpty() {
		OpenSales openSales = new OpenSales();
		assertTrue(openSales.isEmpty());
	}

	@Test
	public void whenNewHasNoSales() {
		OpenSales openSales = new OpenSales();
		assertEquals(0, openSales.getNumberOfSales());
	}

	@Test
	public void whenSaleAddedNumberOfSalesIncreasesByOne() {
		sale = simpleSale();
		OpenSales openSales = new OpenSales();
		openSales.addSale(sale);
		assertEquals(1, openSales.getNumberOfSales());
	}

	@Test
	public void singleSalesCanBeRetrieveWithAnIterator() {
		OpenSales openSales = new OpenSales();
		sale = simpleSale();
		openSales.addSale(sale);
		Iterator<Sale> salesIterator = openSales.iterator();
		assertEquals(sale, salesIterator.next());
	}

	@Test
	public void canBeCreatedWithListOfChoice() {
		Sale returnedSale;
		Sale sale = simpleSale();
		List<Sale> salesList = new ArrayList<Sale>();
		salesList.add(sale);

		OpenSales openSales = new OpenSales(salesList);

		Iterator<Sale> salesIterator = openSales.iterator();
		returnedSale = salesIterator.next();
		assertEquals(sale, returnedSale);
	}

	@Test
	public void getOpenSalesPopulatesOpenSalesWithSalesListFromDao() {
		List<Sale> openSalesList = new ArrayList<Sale>();
		openSalesList.add(simpleSale());
		
		OpenSales openSales = new OpenSales(openSalesList);
		assertEquals(openSalesList, openSales.getSalesList());
		assertEquals(1, openSales.getNumberOfSales());
	}
}
