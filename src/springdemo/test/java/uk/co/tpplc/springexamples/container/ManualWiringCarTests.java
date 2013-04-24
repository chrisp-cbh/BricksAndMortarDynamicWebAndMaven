package uk.co.tpplc.springexamples.container;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/uk/co/tpplc/springexamples/container/ManualCarTests-context.xml" })
public class ManualWiringCarTests extends AbstractJUnit4SpringContextTests {

	@Autowired
	private Car car;
	
	@Autowired
	private Engine v8;

	@Test
	public void seeIfCarIsWiredUp() {
		System.out.println(car.start());
	}

}
