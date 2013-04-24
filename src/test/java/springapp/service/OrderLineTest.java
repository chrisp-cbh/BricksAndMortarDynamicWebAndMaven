package springapp.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderLineTest {

	@Test
	public void orderLineObjectCanBeInstantiatedAndStoresValuesCorrectly()
	{
		String sku = "1234";
		String unitOfMeasure = "M2";
		int quantity = 1;
		double unitPrice = 2.0;
		double vatRate = 20.0;
		
		OrderLine orderLine = new OrderLine(sku, quantity, unitPrice, vatRate, unitOfMeasure);
		assertEquals(sku, orderLine.sku);
		assertEquals(quantity, orderLine.quantity);
		assertEquals(unitPrice, orderLine.unitPrice, 0);
		assertEquals(vatRate, orderLine.vatRate, 0);
		assertEquals(unitOfMeasure, orderLine.unitOfMeasure);	
	}

	@Test
	public void orderLineObjectCanBeInstantiatedAndStoresDifferentValuesCorrectly()
	{
		String sku = "98765";
		String unitOfMeasure = "C5";
		int quantity = 5;
		double unitPrice = 19.0;
		double vatRate = 22.5;
		
		OrderLine orderLine = new OrderLine(sku, quantity, unitPrice, vatRate, unitOfMeasure);
		assertEquals(sku, orderLine.sku);
		assertEquals(quantity, orderLine.quantity);
		assertEquals(unitPrice, orderLine.unitPrice, 0);
		assertEquals(vatRate, orderLine.vatRate, 0);
		assertEquals(unitOfMeasure, orderLine.unitOfMeasure);	
	}


}
