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
	
	@Test
	public void test() {
		assertEquals("Mr Snuggles", rocketShip.shipName);
	}

}
