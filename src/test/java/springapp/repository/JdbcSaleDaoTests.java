package springapp.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import springapp.domain.Sale;
import springapp.repository.JdbcSaleDao.SaleMapper;

@ContextConfiguration(locations = { "/test-context.xml" })
public class JdbcSaleDaoTests extends
		AbstractTransactionalJUnit4SpringContextTests {

	private static final String LOAD_SALE_DATA_SQL_FILE = "file:db/load_sale_data.sql";

	@Autowired
	private SaleDao saleDao;

	@Before
	public void onSetUpInTransaction() throws Exception {
		deleteFromTables(new String[] { JdbcSaleDao.SALES_TABLE });
		executeSqlScript(LOAD_SALE_DATA_SQL_FILE, true);
	}

	@Test
	public void getSaleListReturnsCorrectTestRows() {
		List<Sale> sales = saleDao.getSaleList();
		assertThat(3, is(sales.size()));
	}

	@Test
	public void testSaveSaleCreatesSaleRecord() {
		Sale sale = new Sale("fred", "18 June, 1782", "23");
		saleDao.saveSale(sale);
		assertThat(0L, not(equalTo(sale.getId())));
		assertThat(1L, not(equalTo(sale.getId())));
	}

	@Test
	public void testSaveSaleUpdateSaleRecord() {

		Date dateNow = new Date();
		String originalTillId = "23";
		String updatedTillId = "40";

		Sale sale = new Sale("fred", dateNow.toString(), originalTillId);
		saleDao.saveSale(sale);
		sale.setTillId(updatedTillId);
		saleDao.saveSale(sale);

		List<Sale> sales = saleDao.getSaleList();
		assertTrue(checkSaleListContainsParticularSale(sales, sale));
	}

	private boolean checkSaleListContainsParticularSale(List<Sale> sales,
			Sale sale) {
		boolean foundSale = false;
		Iterator<Sale> iterator = sales.iterator();
		while (iterator.hasNext()) {
			Sale saleToCheck = iterator.next();
			if (saleToCheck.getId() == sale.getId()
					&& saleToCheck.getTillId().equals(sale.getTillId())) {
				foundSale = true;
			}
		}
		return foundSale;
	}

	@Test
	public void testSalesMapperCallsTheResultSet() {
		SaleMapper saleMapper = new JdbcSaleDao.SaleMapper();
		ResultSet mockResultSet = mock(ResultSet.class);
		try {
			saleMapper.mapRow(mockResultSet, 2);
			verify(mockResultSet).getInt(JdbcSaleDao.ID_COLUMN);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSalesMapperReturnsSalesObject() {
		SaleMapper saleMapper = new JdbcSaleDao.SaleMapper();
		ResultSet mockResultSet = mock(ResultSet.class);
		try {
			assertThat(saleMapper.mapRow(mockResultSet, 2), is(notNullValue()));
		} catch (SQLException e) {
			fail();
		}
	}

	@Test
	public void testSalesMapperPopulatesSaleCorrectly() {

		ResultSet mockResultSet = mock(ResultSet.class);

		SaleMapper saleMapper = new JdbcSaleDao.SaleMapper();
		Sale sale;
		try {
			when(mockResultSet.getInt(JdbcSaleDao.ID_COLUMN)).thenReturn(2);
			when(mockResultSet.getString(JdbcSaleDao.SALES_ASSISTANT_COLUMN))
					.thenReturn("Bob");
			when(mockResultSet.getString(JdbcSaleDao.TIME_STAMP_COLUMN))
					.thenReturn("21 Mar, 2013");
			when(mockResultSet.getString(JdbcSaleDao.TILL_ID_COLUMN))
					.thenReturn("4");

			sale = saleMapper.mapRow(mockResultSet, 2);
			assertThat(2L, is(equalTo(sale.getId())));
			assertThat("Bob", is(equalTo(sale.getSalesAssistant())));
			assertThat("21 Mar, 2013", is(equalTo(sale.getTimeStamp())));
			assertThat("4", is(equalTo(sale.getTillId())));
		} catch (SQLException e) {
			fail();
		}
	}
}
