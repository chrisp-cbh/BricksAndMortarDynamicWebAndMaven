package uk.co.tpplc.springexamples.container.anphe.rwind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RocketShipTests {

	
	@Autowired
	private RocketShip enterprise;

	@Autowired
	private RocketShip liberator;


	@Test
	public void whenEnterpriseRocketShipExistsThenEngineIsWarp() {
		assertEquals("warp",enterprise.getEngine().getName());
	}
	
	@Test
	public void whenLiberatorRocketShipExistsThenEngineIsFtl() {
		assertEquals("ftl",liberator.getEngine().getName());
	}
	
	@Test
	public void whenEnterpriseThenPilotIsPicard() {
		assertEquals("Picard",enterprise.getPilot().getSurname());
	}
	
	@Test
	public void whenEnterpriseThenFuelTypeIsDilithium() {
		assertEquals("Dilithium Crystals",enterprise.getEngine().getFuelType().getName());
	}
	
	@Test
	public void whenEnterpriseThenWeaponsArePhotonTorpedoesAndPhasers() {
		String[] weapons = enterprise.getWeapons();
		assertEquals(2, weapons.length);
		assertEquals("Phasers",weapons[0]);
		assertEquals("Photon Torpedoes",weapons[1]);
	}
}
