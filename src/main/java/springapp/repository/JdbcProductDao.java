package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import springapp.domain.Product;

public class JdbcProductDao extends JdbcDaoSupport implements ProductDao {

	protected final Log logger = LogFactory.getLog(getClass());

	public List<Product> getProductList() {
		logger.info("Getting products!");
		List<Product> products = getJdbcTemplate().query(
				"select id, description, price from products",
				new ProductMapper());
		return products;
	}

	public void saveProduct(Product prod) {
		logger.info("Saving product: " + prod.getDescription());
		int count = getJdbcTemplate().update(
				"update products set description = ?, price = ? where id = ?",
				prod.getDescription(), prod.getPrice(), prod.getId());
		logger.info("Rows affected: " + count);
	}

	private static class ProductMapper implements
			ParameterizedRowMapper<Product> {

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product prod = new Product();
			prod.setId(rs.getInt("id"));
			prod.setDescription(rs.getString("description"));
			prod.setPrice(new Double(rs.getDouble("price")));
			return prod;
		}

	}

}