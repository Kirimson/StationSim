package aston.group17.model;

public class SmallCar extends Vehicle {

	private static final double UNIT_SIZE = 1;

	public SmallCar(){
		super(9,9);
	}
	
	public double getUnitSpace() {
		return UNIT_SIZE;
	}

}
