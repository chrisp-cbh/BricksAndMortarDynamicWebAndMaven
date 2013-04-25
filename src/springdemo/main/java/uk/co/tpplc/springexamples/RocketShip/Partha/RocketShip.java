package uk.co.tpplc.springexamples.RocketShip.Partha;

public class RocketShip {
	
	protected Engine engine;
	private String type; 
	private Pilot pilot;
	private Weapon weapon;
	
	public RocketShip(String type)
	{
		this.type = type;
	}
	
	public void setEngine(Engine engine){
		this.engine = engine;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public String getType() {
		return type;
	}

	public void setPilot(Pilot pilot)
	{
		this.pilot = pilot;
	}
	
	public Pilot getPilot() {
		// TODO Auto-generated method stub
		return pilot;
	}
	
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}
}
