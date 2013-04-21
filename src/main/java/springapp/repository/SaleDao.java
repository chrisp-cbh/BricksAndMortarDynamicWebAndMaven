package springapp.repository;

import java.util.List;

import springapp.domain.Sale;

public interface SaleDao{

	public void saveSale(Sale sale);
	public List<Sale> getSaleList();
}
