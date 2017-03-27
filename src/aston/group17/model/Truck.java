package aston.group17.model;

public class Truck extends Vehicle{
	
	private static final double UNIT_SIZE = 2.0;

	
	public Truck(){
		super(30, 10);
		vehicleType = "Truck";
	}

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

}
