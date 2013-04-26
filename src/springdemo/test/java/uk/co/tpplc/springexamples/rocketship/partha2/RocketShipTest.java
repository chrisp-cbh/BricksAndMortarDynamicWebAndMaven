package uk.co.tpplc.springexamples.rocketship.partha2;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import uk.co.tpplc.springexamples.container.Car;

@ContextConfiguration(locations = { "/uk/co/tpplc/springexamples/RocketShip/Partha/RocketShipTest-context.xml" })
public class RocketShipTest extends AbstractJUnit4SpringContextTests  {

	@Autowired
	private RocketShip rocketShip;

	@Autowired
	private Engine arian;
	
	@Autowired
	private Engine spaceshuttle;
	
	@Autowired
	private Pilot josh;
	
	@Autowired
	private Weapon laser;
	
	@Test
	public void makeSureRocketIsWiredUp()
	{
		assertEquals("Moon Lander", rocketShip.getType());
		assertEquals("Arian Rocket", rocketShip.getEngine().getType());
		assertEquals("Josh reporting for duty!", rocketShip.getPilot().getMessage());
		assertEquals("Dual-mounted hyper laser beams", rocketShip.getWeapon().getType());
	}
	
	@Test
	public void arianShouldReturnCorrectType() {
						
		assertEquals("Arian Rocket", arian.getType());
	
	}

	@Test
	public void spaceShuttleShouldReturnCorrectType()
	{
		assertEquals("Space Shuttle", spaceshuttle.getType());
	}
	
	
}
