package springapp.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import springapp.domain.Product;

@ContextConfiguration(locations={"/test-context.xml"})
public class JdbcProductDaoTests extends AbstractTransactionalJUnit4SpringContextTests  {

	@Autowired
    private ProductDao productDao;

    @Before
    public void onSetUpInTransaction() throws Exception {
        super.deleteFromTables(new String[] {"products"});
        super.executeSqlScript("file:db/load_product_data.sql", true);
    }

    @Test
    public void testGetProductList() {
        List<Product> products = productDao.getProductList();
        assertEquals("wrong number of products?", 3, products.size());   
    }
    
    @Test
    public void testSaveProduct() {
        
        List<Product> products = productDao.getProductList();
        
        for (Product p : products) {
            p.setPrice(200.12);
            productDao.saveProduct(p);
        }
        
        List<Product> updatedProducts = productDao.getProductList();
        for (Product p : updatedProducts) {
            assertEquals("wrong price of product?", Double.valueOf(200.12), p.getPrice());
        }
    }

}