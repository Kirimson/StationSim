package aston.group17.model;

public class Familysedans extends Vehicle {

	private static final double UNIT_SIZE = 1.5;

	public Familysedans(){
		super(12,18);
	}

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

}
