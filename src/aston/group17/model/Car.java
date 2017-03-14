package aston.group17.model;

public class Car extends Vehicle {

	private static final double UNIT_SIZE = 1.0;

	public Car(){
		super(3, 7);
	}
	
	public double getUnitSpace() {
		return UNIT_SIZE;
	}

}
