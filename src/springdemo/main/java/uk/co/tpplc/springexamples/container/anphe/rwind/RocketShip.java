package uk.co.tpplc.springexamples.container.anphe.rwind;


public class RocketShip {

	private Engine engine;
	private Pilot pilot;
	private String[] weapons;

	public Engine getEngine() {
		return this.engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Pilot getPilot() {
		return this.pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public String[] getWeapons() {
		return this.weapons;
	}

	public void setWeapons(String[] weapons) {
		this.weapons = weapons;
	}

}
