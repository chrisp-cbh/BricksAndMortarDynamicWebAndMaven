package uk.co.tpplc.springexamples.rocketship.noran;

import org.springframework.beans.factory.annotation.Autowired;

public class Rocketship {

	final String fueltype;

	private Pilot pilot;
	
	private Engine rightEngine;
	private Engine leftEngine;
	
	private Wing span;
	
	public Rocketship(String fuelType) {
		this.fueltype = fuelType;
	}

	public void buildRocketShip() {

	}

	public Object getFuelType() {

		return fueltype;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Engine getRightEngine() {
		return rightEngine;
	}

	public void setRightEngine(Engine engine) {
		this.rightEngine = engine;
	}

	public Engine getLeftEngine() {
		return leftEngine;
	}

	public void setLeftEngine(Engine engine) {
		this.leftEngine = engine;
	}
	
	public Wing getWing() {
		return span;
	}

	public void setWing(Wing span) {
		this.span = span;
	}
	
}
