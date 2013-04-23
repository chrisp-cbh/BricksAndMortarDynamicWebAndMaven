package springapp.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void OrderLineQuantityIsValidReturnsTrueWhenOrderLineQuantityIsGreaterThanZero() {
		Validator validator = new Validator();
		assertTrue(validator.OrderLineQuantityIsValid(1));
	}

	@Test
	public void OrderLineQuantityIsValidReturnsFalseWhenOrderLineQuantityIsZero() {
		Validator validator = new Validator();
		assertFalse(validator.OrderLineQuantityIsValid(0));
	}

	@Test
	public void OrderLineQuantityIsValidReturnsFalseWhenOrderLineQuantityLessThanZero() {
		Validator validator = new Validator();
		assertFalse(validator.OrderLineQuantityIsValid(-1));
	}

}
