package uk.co.tpplc.springexamples.rocketship.partha2;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

	@Test
	public void testArianRocket() {
		Engine rocketType = new ArianRocket();
		assertEquals("Arian Rocket", rocketType.getType());
	}

	@Test
	public void testSpaceShuttle() {
		Engine rocketType = new SpaceShuttle();
		assertEquals("Space Shuttle", rocketType.getType());
	}
}
