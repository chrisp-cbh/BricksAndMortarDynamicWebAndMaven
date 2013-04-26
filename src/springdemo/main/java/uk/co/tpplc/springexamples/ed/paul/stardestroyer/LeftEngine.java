package uk.co.tpplc.springexamples.ed.paul.stardestroyer;

public class LeftEngine implements Engines {

	@Override
	public String start() {
		return "BOOOOOOOOOM";
	}

	@Override
	public String stop() {
		return "parp";
	}

}
