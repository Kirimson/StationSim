package aston.group17.model;
import java.util.Random;

public class Car extends Vehicle {

	private static final double UNIT_SIZE = 1.0;
	private Random rand;

	public Car(){

		super(3, 7);
		vehicleType = "Car";
		rand = new Random();
	}
	
	public double getUnitSpace() {
		return UNIT_SIZE;
	}
	/**
	 * This calculates how long a car driver could spend shopping 
	 */
	public int timeSpent(){
		int timeSpent = rand.nextInt(2)+2;
		return timeSpent;
	}
	
	/**
	 * This calculates how m a car driver could spend shopping 
	 */
	public double moneySpent(){
		double moneySpent = rand.nextInt(5)+5;
		return moneySpent;
	}

}
