package springapp.web.sale;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class SaleBeanTest {
	private SaleBean sale;
	
	@Before
	public void setUp(){
		sale = new SaleBean();
		sale.setSalesAssistant("Mr Bean");
		sale.setTillId("54321");
		sale.setTimeStamp("23 June, 1742");		
	}

	@Test
	public void checkBeanAttributesAreSettable(){
		String toTest = sale.toString();
		assertThat(toTest, containsString("Mr Bean"));
		assertThat(toTest, containsString("54321"));
		assertThat(toTest, containsString("23 June, 1742"));
	}
	
	@Test
	public void checkToStringGracefullyHandlesNullAttributes(){
		sale.setTimeStamp(null);
		sale.setTillId(null);
		String toTest = sale.toString();
		assertThat(toTest, containsString("Mr Bean"));
		assertThat(toTest, containsString("property tillId='null'"));
		assertThat(toTest, containsString("property timeStamp='null'"));
	}
}
