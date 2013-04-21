package springapp.fitnesse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import springapp.domain.OpenSales;
import springapp.domain.Sale;

public class AllOpenSales extends SpringFitnesseFixture {

	public List<Object> query() {
		ArrayList<Object> queryResults = new ArrayList<Object>();

		OpenSales openSales = saleService.getOpenSales();
		
		Iterator<Sale> saleIterator = openSales.iterator();

		while (saleIterator.hasNext()) {
			Sale sale = saleIterator.next();
			ArrayList<Object> row = row(Long.toString(sale.getId()), sale.getSalesAssistant(),
					sale.getTimeStamp(), sale.getTillId());
			queryResults.add(row);
		}

		return queryResults;
	}

	private ArrayList<Object> row(String saleId, String salesAssistant, String dateStamp,
			String tillId) {
		ArrayList<Object> row = new ArrayList<Object>();
		row.add(makeColumn("saleid", saleId));
		row.add(makeColumn("sales assistant", salesAssistant));
		row.add(makeColumn("time stamp", dateStamp));
		row.add(makeColumn("till id", tillId));
		return row;
	}

	private ArrayList<Object> makeColumn(String name, String value) {
		ArrayList<Object> column = new ArrayList<Object>();
		column.add(name);
		column.add(value);
		return column;
	}
}