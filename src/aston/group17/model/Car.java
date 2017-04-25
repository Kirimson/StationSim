package aston.group17.model;
import java.util.Random;

public class Car extends Vehicle {

	private static final double UNIT_SIZE = 1.0;
	private Random rand;

	public Car()
	{
		super(3, 7);
		vehicleType = "Car";
		rand = new Random();
	}
	
	public double getUnitSize() {
		return UNIT_SIZE;
	}
	
	public int timeToSpendShopping(){
		int timeSpent = rand.nextInt(2)+2;
		return timeSpent * 6;
	}
	
	public double moneySpentForShopping(){
		double moneySpent = rand.nextInt(5)+5;
		return moneySpent;
	}

}