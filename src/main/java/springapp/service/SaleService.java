package springapp.service;

import java.util.List;

import springapp.domain.OpenSales;
import springapp.domain.Sale;
import springapp.repository.SaleDao;

public class SaleService {

	private SaleDao saleDao;

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}
	
	public void openSale(Sale sale) {
		saleDao.saveSale(sale);
	}

	public OpenSales getOpenSales() {
		List<Sale> sales = saleDao.getSaleList();
		return new OpenSales(sales);
	}

}