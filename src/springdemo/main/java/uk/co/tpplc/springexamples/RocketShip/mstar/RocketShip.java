package uk.co.tpplc.springexamples.rocketship.mstar;

public class RocketShip {

	final String shipName;
	protected Engine engine;
	
	public RocketShip(String name)
	{
		this.shipName = name;
	}
	
	public void setEngine(Engine engine)
	{
		this.engine = engine;
	}
	
	public String getEngineType()
	{
		return engine.type;
	}
	
	
	

}
