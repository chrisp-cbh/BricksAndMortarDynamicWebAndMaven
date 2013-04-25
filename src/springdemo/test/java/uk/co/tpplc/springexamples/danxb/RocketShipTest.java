package uk.co.tpplc.springexamples.danxb;

import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/uk/co/tpplc/springexamples/container/danxb/ManualRocketShipTests-context.xml" })
public class RocketShipTest extends AbstractJUnit4SpringContextTests
{
	@Autowired
	private RocketShip rocketShip;
	
	@Autowired
	private Engine dansEngine;

	@Autowired
	private Pilot dan;
	
	@Test
	public void RocketShipHasAPilot()
	{
		assertEquals(rocketShip.pilot.getName(), dan.getName());
		assertEquals(rocketShip.pilot.getName(), "Dan");
	}
	
	@Test
	public void RocketShipHasAnEngine()
	{
		assertTrue(rocketShip.engine instanceof Engine);
		
	}
}
