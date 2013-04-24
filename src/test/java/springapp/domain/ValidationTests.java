package springapp.domain;

import static org.junit.Assert.*;
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
	
	@Test
	public void isValidForUpdateReturnsTrueIfTillIdAndUserIdArePassed()
	{
		assertTrue(validation.isValidForUpdate("abc","def"));
	}
	
	@Test
	public void isValidForUpdateReturnsFalseIfTillIdAndUserIdAreNull()
	{
		assertFalse(validation.isValidForUpdate(null, null));
	}
	
	@Test 
	public void isValidForUpdateReturnsTrueIfTillIdIsPassedAndUserIdIsNull(){
		assertTrue(validation.isValidForUpdate("123", null));
	}

	@Test 
	public void isValidForUpdateReturnsTrueIfTillIdIsNullAndUserIdIsPassed(){
		assertTrue(validation.isValidForUpdate(null, "123"));
	}
	
	@Test
	public void isValidForUpdateReturnsFalseIfTillIdIsEmpty(){
		assertFalse(validation.isValidForUpdate("", "afdsaf"));
	}
	
	@Test
	public void isValidForUpdateReturnsFalseIfUserIdIsEmpty(){
		assertFalse(validation.isValidForUpdate("vfdsf", ""));
	}
	
	@Test
	public void isValidForUpdateReturnsFalseIfTillIdIsEmptyAndUserIdIsNull(){
		assertFalse(validation.isValidForUpdate("", null));
	}
	
	@Test
	public void isValidForUpdateReturnsFalseIfTillIdIsNullAndUserIdIsEmpty(){
		assertFalse(validation.isValidForUpdate(null, ""));
	}
	
}
