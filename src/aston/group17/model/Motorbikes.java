package aston.group17.model;

public class Motorbikes extends Vehicle {

	private static final double UNIT_SIZE = 0.75;

	public Motorbikes(){
		super(5);
	}

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

}
