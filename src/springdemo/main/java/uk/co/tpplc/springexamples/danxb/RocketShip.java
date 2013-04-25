package uk.co.tpplc.springexamples.danxb;

public class RocketShip {

	protected Engine engine;
	protected Pilot pilot;
	
	public RocketShip(Engine engine) {
		this.engine = engine;
	}
	
	public Pilot getPilot() {
		return this.pilot;
	}
	
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

}
