package aston.group17.model;

public class Bike extends Vehicle {

	private static final double UNIT_SIZE = 0.75;

	public Bike(){
		super(1,5);
		vehicleType = "Bike";
	}

	public double getUnitSize() {
		return UNIT_SIZE;
	}

	
	public int timeSpent() {
		return 0;
	}

	
	public double moneySpent() {
		return 0;
	}
	

}
