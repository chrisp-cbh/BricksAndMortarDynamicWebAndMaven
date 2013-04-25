package uk.co.tpplc.springexamples.ed.paul.stardestroyer;

public class RocketShip {
	
	final String name;
	
	public RocketShip(String name){
		this.name = name;
	}
	
	protected Engines engines;
	protected Pilots pilots;
	protected Wings wings;
	protected Weapons weapons;
	protected FuelTypes fuelTypes;

	public Engines getEngines() {
		return engines;
	}

	public void setEngines(Engines engines) {
		this.engines = engines;
	}
	
	public String start(){
		StringBuffer buf = new StringBuffer();
		
		buf.append(pilots.pressButton());
		buf.append(" ");
		buf.append(engines.start());
		
		return buf.toString();
	}
	
}