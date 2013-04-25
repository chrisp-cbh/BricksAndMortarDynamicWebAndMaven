package uk.co.tpplc.springexamples.rocketship.noran;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/uk/co/tpplc/springexamples/rocketship/noran/ManualWiringRocketshipTests-context.xml" })
public class ManualWiringRocketshipTests extends AbstractJUnit4SpringContextTests {

	@Autowired
	private Rocketship rocketship;
	
	@Autowired
	private Pilot pilotDan;
	
	@Autowired
	private Pilot pilotJason;
	
	@Autowired
	private Engine rightEngine;
	
	@Test
	public void seeIfRocketIsWiredUp(){
		rocketship.buildRocketShip();
		assertEquals("Rocket Fuel",rocketship.getFuelType());
	}
	
	@Test
	public void getNameOfPilot(){
		assertEquals("Jason",pilotJason.getName());
	}

	@Test
	public void RocketshipHasDanPilot()
	{
		assertEquals("Dan",rocketship.getPilot().getName());
	}
	
	@Test
	public void RocketshipHasRightEngine()
	{
		assertEquals("6L",rocketship.getRightEngine().getSize());
	}
	@Test
	public void RocketshipHasLeftEngine()
	{
		assertEquals("5L",rocketship.getLeftEngine().getSize());
	}
	
	@Test
	public void RocketshipHasWings()
	{
		assertEquals("30ft",rocketship.getWing().getSpan());
	}
}
