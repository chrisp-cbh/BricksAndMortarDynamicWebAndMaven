package springapp.service;

public class Validator {

	public boolean OrderLineQuantityIsValid(int i) {
		return i > 0;
	}

	public boolean CurrentOrderIsPresent(Order currentOrder) {
		return currentOrder != null;
	}

}
