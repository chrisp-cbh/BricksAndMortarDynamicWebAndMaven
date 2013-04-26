package uk.co.tpplc.springexamples.RocketShip.Partha;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

	@Test
	public void testArianRocket() {
	
	Engine rocketType = new ArianRocket();
	assertEquals("Arian", rocketType.getType());	
	
	}

	@Test
	public void testSpaceShuttle() {
	
	Engine rocketType = new SpaceShuttle();
	assertEquals("Space Shuttle", rocketType.getType());		

	}
	

}


