package springapp.domain;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ValidationTests {

	Validation validation;
	@Before
	public void before()
	{
		validation = new Validation();
	}

	@Test
	public void isValidStatusDefaultsToFalse()
	{
		assertFalse(validation.isValid("", ""));
	}
	
	@Test
	public void isValidReturnsTrueIfTillIdAndUserIdAreNotEmpty()
	{
		assertTrue(validation.isValid("123", "456"));
	}
}
