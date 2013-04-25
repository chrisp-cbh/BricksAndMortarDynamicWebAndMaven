package uk.co.tpplc.springexamples.ed.paul.stardestroyer;

public class PilotPaul implements Pilots {

	String name;
	
	@Override
	public String pressButton() {
		return "Blast off!!!";
	}
	
	@Override
	public void setPilotName(String name) {
		this.name = name;
	}
	
	public String getPilotName() {
		return this.name;
	}

	@Override
	public int pilotYearsFlying() {
		return 1;
	}	
}
