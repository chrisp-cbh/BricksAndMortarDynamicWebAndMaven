package uk.co.tpplc.springexamples.ed.paul.stardestroyer;

public class RightEngine implements Engines {

	@Override
	public String start() {
		return "WHOOSH";
	}

	@Override
	public String stop() {
		return "pop";
	}
	
}