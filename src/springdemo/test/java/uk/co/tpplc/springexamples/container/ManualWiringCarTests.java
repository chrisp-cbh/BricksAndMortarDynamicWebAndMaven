package uk.co.tpplc.springexamples.container;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/uk/co/tpplc/springexamples/container/ManualCarTests-context.xml" })
public class ManualWiringCarTests extends AbstractJUnit4SpringContextTests {

	@Autowired
	private Car car;
	
	//based on bean id
	@Autowired
	private Engine v8;

	//based on bean id
	@Autowired
	private Engine diesel;
	
	@Test
	public void seeIfCarIsWiredUp() {
		System.out.println(car.start());
		assertEquals("chevrolet", car.getMake());
	}
	
	@Test
	public void v8ShouldBeV8(){
		assertEquals("V8", v8.getType());
	}

	@Test
	public void flat4ShouldBeFlat4Diesel(){
		assertEquals("Flat4Diesel", diesel.getType());
	}
}
