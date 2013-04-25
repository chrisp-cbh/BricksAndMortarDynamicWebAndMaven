package uk.co.tpplc.springexamples.container;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from
// "classpath:/uk/co/tpplc/springexamples/container/CarTests-context.xml"
@ContextConfiguration
public class AutowiredCarTests {

	@Autowired
	Car car;
	
	@Autowired
	Driver ba;

	@Before
	public void setup() {
	}
	
	@Test
	public void letsSeeIfOurCarIsWiredUp(){
		System.out.println("Autowired - " +car.start());
		assertEquals("gm", car.getMake());
	}
	
	@Test
	public void getAQuoteFromBA(){
		System.out.println("BA, what do you think? " + ba.getQuote());
		assertEquals("BA", ba.getName());
	}
}