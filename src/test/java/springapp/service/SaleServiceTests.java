package springapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import springapp.domain.OpenSales;
import springapp.domain.Sale;
import springapp.repository.SaleDao;

public class SaleServiceTests {

	private SaleDao mockSaleDao;
	private SaleService salesService;

	@Before
	public void setUp() {
		mockSaleDao = mock(SaleDao.class);
		salesService = new SaleService();
		salesService.setSaleDao(mockSaleDao);
	}

	@Test
	public void openSaleForwardsSaleToSaveSaleOnDao() {
		Sale sale = new Sale("salesAssistant", "timeStamp", "tillId");
		salesService.openSale(sale);
		verify(mockSaleDao).saveSale(sale);
	}

	@Test
	public void getOpenSalesForwardsToSaleDao() {
		salesService.getOpenSales();
		verify(mockSaleDao).getSaleList();
	}

	@Test
	public void openSalesConvertesCorrectNumberOfSalesFromListToOpenSalesObject() {
		List<Sale> saleList = new ArrayList<Sale>();
		Sale sale = new Sale("assistant", "timestamp", "tillid");
		saleList.add(sale);
		when(mockSaleDao.getSaleList()).thenReturn(saleList);
		OpenSales sales = salesService.getOpenSales();

		Iterator<Sale> salesIterator = sales.iterator();
		Sale returnedSale = salesIterator.next();
		
		assertEquals(sale, returnedSale);
		verify(mockSaleDao).getSaleList();
	}
}