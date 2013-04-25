package uk.co.tpplc.springexamples.ed.paul.stardestroyer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "/uk/co/tpplc/springexamples/ed/paul/stardestroyer/RocketShipTests-context.xml" })
public class RocketShipTests extends AbstractJUnit4SpringContextTests {

	@Autowired
	private Pilots pilotEd;
	@Autowired
	private Pilots pilotPaul;
	
	@Test
	public void seeIfCarIsWiredUp() { 
		assertEquals("Ed Pope", pilotEd.getPilotName());
	}
	
	@Test
	public void seeIfPilotPaulHasTheCorrectName() { 
		assertEquals("Paul", pilotPaul.getPilotName());
	}

}
