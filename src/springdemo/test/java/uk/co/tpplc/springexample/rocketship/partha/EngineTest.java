package uk.co.tpplc.springexample.rocketship.partha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.co.tpplc.springexamples.rocketship.partha2.ArianRocket;
import uk.co.tpplc.springexamples.rocketship.partha2.Engine;
import uk.co.tpplc.springexamples.rocketship.partha2.SpaceShuttle;

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
