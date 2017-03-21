package aston.group17.model;

public class Sedan extends Vehicle {

	private static final double UNIT_SIZE = 1.5;

	public Sedan(){
		super(7, 12);
		vehicleType = "Sedan";
	}
	

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

}
