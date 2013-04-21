package springapp.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;


public class PriceIncreaseTest {
	@Test
	public void setPercentageCanBeRetrieved(){
		
		PriceIncrease priceIncrease = new PriceIncrease();
		
		priceIncrease.setPercentage(21);
		
		assertThat(priceIncrease.getPercentage(), is(21));
	}
	

}
