package uk.co.tpplc.springexamples.rocketship.mstar;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from
//"classpath:/uk/co/tpplc/springexamples/rocketship/mstar/ManualRocketShipTests-context.xml"
@ContextConfiguration
public class ManualWiredRocketShipTests {

	@Autowired
	RocketShip rocketShip;
	
	@Autowired
	Engine engine1;
	
	@Autowired
	Engine engine2;
	
	@Test
	public void test() {
		assertEquals("Mr Snuggles", rocketShip.shipName);
	}
	
	@Test
	public void canReadRocketBeanEngineType() {
		assertEquals("v8", rocketShip.engine.type);
	}
	
	@Test
	public void canReadEngine1BeanAttributes() {
		assertEquals("v8", engine1.type);
	}	
	
	@Test
	public void canReadEngine2BeanAttributes() {
		assertEquals("liquidfuel", engine2.type);
	}		
}
