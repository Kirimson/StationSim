package aston.group17.model;
/**
 * A Bike vehicle, child class of Vehicle
 * 
 * @author Kieran Gates
 * @author Mitch Feaver
 *
 * @version 2017.4.28
 */
public class Bike extends Vehicle {

	private static final double UNIT_SIZE = 0.75;

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
