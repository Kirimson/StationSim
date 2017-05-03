package aston.group17.model;

public class Bike extends Vehicle {

	private static final double UNIT_SIZE = 0.75;

	/**
	 * Constructs a new Bike class, with a tank of 5 gallons
	 */
	public Bike(int globalSeed){
		super(1,5, globalSeed);
		vehicleType = "Bike";
	}

	public double getUnitSize() {
		return UNIT_SIZE;
	}

	public int timeToSpendShopping() {
		return 0;
	}

	public double moneySpentForShopping() {
		return 0;
	}

}
