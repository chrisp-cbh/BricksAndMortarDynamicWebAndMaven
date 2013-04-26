package uk.co.tpplc.springexamples.container.anphe.rwind;

public class Engine {

	private String name;
	private FuelType fuelType;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FuelType getFuelType() {
		return this.fuelType;
	}
	
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
}
