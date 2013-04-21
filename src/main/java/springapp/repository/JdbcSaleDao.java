package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import springapp.domain.Sale;

public class JdbcSaleDao extends JdbcDaoSupport implements SaleDao {

	public static final String SALES_TABLE = "SALES";
	public static final String TILL_ID_COLUMN = "TILL_ID";
	public static final String TIME_STAMP_COLUMN = "TIME_STAMP";
	public static final String SALES_ASSISTANT_COLUMN = "SALES_ASSISTANT";
	public static final String ID_COLUMN = "ID";

	private static final String SQL_GET_ALL_SALES = "SELECT ID, SALES_ASSISTANT, TIME_STAMP, TILL_ID FROM SALES";
	private static final String SQL_UPDATE_EXISTING_SALE = "UPDATE SALES SET SALES_ASSISTANT = ?, TIME_STAMP = ?, TILL_ID = ? WHERE ID = ?";
	private static final String SQL_CHECK_IF_SALE_EXISTS = "SELECT COUNT(*) FROM SALES WHERE ID=?";

	public void saveSale(Sale sale) {
		JdbcTemplate template = getJdbcTemplate();

		if (doesSaleAlreadyExist(sale, template)) {
			updateExistingSale(sale, template);
		} else {
			saveNewSaleAndPopulateTheId(sale, template);
		}
	}

	private boolean doesSaleAlreadyExist(Sale sale, JdbcTemplate template) {
		int saleCount = template.queryForInt(SQL_CHECK_IF_SALE_EXISTS,
				sale.getId());

		if (saleCount == 1) {
			return true;
		}
		return false;
	}

	private void updateExistingSale(Sale sale, JdbcTemplate template) {
		template.update(SQL_UPDATE_EXISTING_SALE,
				sale.getSalesAssistant(), sale.getTimeStamp(), sale.getTillId(), sale.getId());
	}

	private void saveNewSaleAndPopulateTheId(Sale sale, JdbcTemplate template) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(getJdbcTemplate());
		insert.withTableName(SALES_TABLE);
		insert.usingGeneratedKeyColumns(ID_COLUMN);

		Map<String, Object> parameters = populateMapWithColumnsAndValuesFromSale(sale);
		Number key = insert.executeAndReturnKey(parameters);
		sale.setId(key.longValue());
	}

	private Map<String, Object> populateMapWithColumnsAndValuesFromSale(
			Sale sale) {
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put(TILL_ID_COLUMN, sale.getTillId());
		parameters.put(SALES_ASSISTANT_COLUMN, sale.getSalesAssistant());
		parameters.put(TIME_STAMP_COLUMN, sale.getTimeStamp());
		return parameters;
	}

	public List<Sale> getSaleList() {
		List<Sale> sales = getJdbcTemplate().query(SQL_GET_ALL_SALES,
				new SaleMapper());
		return sales;
	}

	public static class SaleMapper implements ParameterizedRowMapper<Sale> {

		@Override
		public Sale mapRow(ResultSet rs, int rowNumber) throws SQLException {

			long id = rs.getInt(ID_COLUMN);
			String timeStamp = rs.getString(TIME_STAMP_COLUMN);
			String tillId = rs.getString(TILL_ID_COLUMN);
			String salesAssistant = rs.getString(SALES_ASSISTANT_COLUMN);

			Sale sale = new Sale(salesAssistant, timeStamp, tillId);
			sale.setId(id);
			return sale;
		}
	}
}
