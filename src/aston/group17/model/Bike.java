package aston.group17.model;

public class Bike extends Vehicle {

	private static final double UNIT_SIZE = 0.75;

	public Bike(){
		super(1,5);
		vehicleType = "Bike";
	}

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

	
	public int timeSpent() {
		return 0;
	}

	
	public int moneySpent() {
		return 0;
	}
	

}
