package springapp.domain;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ProductTests{

	private Product product;

	@Before
	public void setUp() throws Exception {
		product = new Product();
	}

	@Test
	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription, product.getDescription());
	}

	@Test
	public void testSetAndGetPrice() {
		double testPrice = 100.00;
		assertEquals(0, 0, 0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
	}

	@Test
	public void testSetAndGetId() {
		product.setId(23);
		assertEquals(23, product.getId());
	}

	@Test
	public void checkThatPropertiesEndUpInToString() {
		product.setDescription("Red bricks");
		product.setId(12321);
		double price = 123.56;
		product.setPrice(price);

		String toTest = product.toString();
		assertThat(toTest, containsString("Red bricks"));
		assertThat(toTest, containsString("12321"));
		assertThat(toTest, containsString("123.56"));
	}
}
