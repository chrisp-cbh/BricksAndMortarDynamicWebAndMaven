package springapp.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	private Validator validator;

	@Before
	public void SetUp()
	{
		validator = new Validator();
	}
	@Test
	public void OrderLineQuantityIsValidReturnsTrueWhenOrderLineQuantityIsGreaterThanZero() {
		assertTrue(validator.OrderLineQuantityIsValid(1));
	}

	@Test
	public void OrderLineQuantityIsValidReturnsFalseWhenOrderLineQuantityIsZero() {
		assertFalse(validator.OrderLineQuantityIsValid(0));
	}

	@Test
	public void OrderLineQuantityIsValidReturnsFalseWhenOrderLineQuantityLessThanZero() {
		assertFalse(validator.OrderLineQuantityIsValid(-1));
	}
	
	@Test
	public void whenCurrentOrderPresentIsNullValidatorReturnsFalse()
	{
		assertFalse(validator.CurrentOrderIsPresent(null));
	}
	@Test
	public void whenCurrentOrderPresentIsNotNullValidatorReturnsTrue()
	{
		assertTrue(validator.CurrentOrderIsPresent(new Order(1,1,null)));
	}

	
}
