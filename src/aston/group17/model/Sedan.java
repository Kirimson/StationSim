package aston.group17.model;
import java.util.Random;

public class Sedan extends Vehicle {

	private static final double UNIT_SIZE = 1.5;
	private Random rand;

	public Sedan(){
		super(7, 12);
		vehicleType = "Sedan";
		rand = new Random();
	}
	

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

	/**
	 * This calculates how long a sedan driver could spend shopping 
	 */
	public int timeSpent(){
		int timeSpent = rand.nextInt(3)+2;
		return timeSpent;	
	}
	
	/**
	 * This calculates how much a sedan driver could spend shopping 
	 */
	public int moneySpent(){
		int moneySpent = rand.nextInt(8)+8;
		return moneySpent;
	}
}
