package springapp.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenSales{
	private final List<Sale> sales;

	public OpenSales(List<Sale> salesList) {
		sales = salesList;		
	}
	
	public OpenSales(){
		sales = new ArrayList<Sale>();
	}

	public boolean isEmpty() {
		return true;
	}

	public int getNumberOfSales() {
		return sales.size();
	}

	public void addSale(Sale sale) {
		sales.add(sale);
	}
	
	public Iterator<Sale> iterator(){
		return sales.iterator();
	}

	protected List<Sale> getSalesList() {
		return sales;
	}

}
